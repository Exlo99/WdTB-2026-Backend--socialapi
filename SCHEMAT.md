# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 (w tym tabele łączące @ManyToMany: social_post_hashtag) · kolumny: 41 · relacje: 5 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 2 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| hashtag | Hashtag | 5 | — |
| post_comment | PostComment | 7 | author_profile_id, post_id |
| reaction | Reaction | 6 | post_id, profile_id |
| social_post | SocialPost | 7 | author_profile_id |
| user_account | UserAccount | 5 | — |
| user_profile | UserProfile | 11 | user_account_id |

```mermaid
erDiagram
    hashtag {
        Long id PK
        LocalDateTime created_at
        String description
        String name
        Integer usage_count
    }
    post_comment {
        Long id PK
        Boolean active
        Long author_profile_id FK
        String content
        LocalDateTime created_at
        LocalDateTime edited_at
        Long post_id FK
    }
    reaction {
        Long id PK
        Boolean active
        LocalDateTime created_at
        Long post_id FK
        Long profile_id FK
        ReactionType type
    }
    social_post {
        Long id PK
        Long author_profile_id FK
        Integer comment_count
        String content
        LocalDateTime created_at
        Integer likes_count
        PostStatus status
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    user_profile {
        Long id PK
        Boolean active
        String bio
        String city
        LocalDateTime created_at
        String display_name
        String email
        String postal_code
        String street
        Long user_account_id FK
        String username
    }
    social_post ||--o{ post_comment : "post_id"
    social_post ||--o{ reaction : "post_id"
    social_post }o--o{ hashtag : "social_post_hashtag"
    user_account ||--o| user_profile : "user_account_id"
    user_profile ||--o{ post_comment : "author_profile_id"
    user_profile ||--o{ reaction : "profile_id"
    user_profile ||--o{ social_post : "author_profile_id"
```
