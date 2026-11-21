package pl.wsb.socialapi.post.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "usage_count", nullable = false)
    private Integer usageCount;

    @ManyToMany(mappedBy = "hashtags")
    private Set<SocialPost> posts = new HashSet<>();

    protected Hashtag() {
    }

    public Hashtag(String name, String description,
                   LocalDateTime createdAt, Integer usageCount) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.usageCount = usageCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public Set<SocialPost> getPosts() {
        return posts;
    }
}
