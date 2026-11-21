package pl.wsb.socialapi.profile.entity;

import jakarta.persistence.*;
import pl.wsb.socialapi.account.domain.UserAccount;
import pl.wsb.socialapi.post.entity.SocialPost;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false,
            unique = true, length = 40)
    private String username;

    @Column(name = "display_name", nullable = false, length = 80)
    private String displayName;

    @Column(name = "email", nullable = false,
            unique = true, length = 120)
    private String email;

    @Column(name = "bio", length = 250)
    private String bio;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Embedded
    private Address address;

    // Each public profile belongs to one login account.
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false, unique = true)
    private UserAccount userAccount;

    // The inverse side of SocialPost.author. mappedBy is the Java field name.
    @OneToMany(mappedBy = "author")
    private List<SocialPost> posts = new ArrayList<>();

    protected UserProfile() {
    }

    public UserProfile(String username, String displayName,
                       String email, String bio,
                       LocalDateTime createdAt, Boolean active,
                       Address address, UserAccount userAccount) {
        this.username = username;
        this.displayName = displayName;
        this.email = email;
        this.bio = bio;
        this.createdAt = createdAt;
        this.active = active;
        this.address = address;
        this.userAccount = userAccount;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public Address getAddress() {
        return address;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public List<SocialPost> getPosts() {
        return posts;
    }
}
