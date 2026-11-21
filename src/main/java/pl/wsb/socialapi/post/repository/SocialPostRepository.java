package pl.wsb.socialapi.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.socialapi.post.entity.SocialPost;

import java.util.List;

public interface SocialPostRepository extends JpaRepository<SocialPost, Long> {

    List<SocialPost> findByAuthor_Username(String username);
}
