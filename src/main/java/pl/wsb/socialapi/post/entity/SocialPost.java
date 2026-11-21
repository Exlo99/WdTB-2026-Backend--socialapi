package pl.wsb.socialapi.post.entity;

import jakarta.persistence.*;
import pl.wsb.socialapi.profile.entity.UserProfile;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "social_post")
public class SocialPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private PostStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "likes_count", nullable = false)
    private Integer likesCount;

    @Column(name = "comment_count", nullable = false)
    private Integer commentCount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_profile_id", nullable = false)
    private UserProfile author;

    @ManyToMany
    @JoinTable(
            name = "social_post_hashtag",
            joinColumns = @JoinColumn(name = "social_post_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private Set<Hashtag> hashtags = new HashSet<>();

    protected SocialPost() {
    }

    public SocialPost(String content, PostStatus status,
                      LocalDateTime createdAt,
                      Integer likesCount, Integer commentCount,
                      UserProfile author) {
        this.content = content;
        this.status = status;
        this.createdAt = createdAt;
        this.likesCount = likesCount;
        this.commentCount = commentCount;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public PostStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public UserProfile getAuthor() {
        return author;
    }

    public Set<Hashtag> getHashtags() {
        return hashtags;
    }
}
