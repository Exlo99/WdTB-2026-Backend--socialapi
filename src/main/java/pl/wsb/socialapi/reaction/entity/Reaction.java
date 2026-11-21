package pl.wsb.socialapi.reaction.entity;

import jakarta.persistence.*;
import pl.wsb.socialapi.post.entity.SocialPost;
import pl.wsb.socialapi.profile.entity.UserProfile;

import java.time.LocalDateTime;

@Entity
@Table(name = "reaction", uniqueConstraints = {
        @UniqueConstraint(name = "uk_reaction_post_profile", columnNames = {"post_id", "profile_id"})
})
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    private UserProfile profile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private SocialPost post;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 20)
    private ReactionType type;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "active", nullable = false)
    private Boolean active;

    protected Reaction() {
    }

    public Reaction(UserProfile profile, SocialPost post,
                    ReactionType type, LocalDateTime createdAt,
                    Boolean active) {
        this.profile = profile;
        this.post = post;
        this.type = type;
        this.createdAt = createdAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public SocialPost getPost() {
        return post;
    }

    public ReactionType getType() {
        return type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getActive() {
        return active;
    }
}
