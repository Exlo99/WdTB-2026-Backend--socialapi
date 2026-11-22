package pl.wsb.socialapi.comment.entity;

import jakarta.persistence.*;
import pl.wsb.socialapi.post.entity.SocialPost;
import pl.wsb.socialapi.profile.entity.UserProfile;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "edited_at")
    private LocalDateTime editedAt;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private SocialPost post;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_profile_id", nullable = false)
    private UserProfile author;

    protected PostComment() {
    }

    public PostComment(String content, LocalDateTime createdAt,
                       LocalDateTime editedAt, Boolean active,
                       SocialPost post, UserProfile author) {
        this.content = content;
        this.createdAt = createdAt;
        this.editedAt = editedAt;
        this.active = active;
        this.post = post;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public SocialPost getPost() {
        return post;
    }

    public UserProfile getAuthor() {
        return author;
    }
}
