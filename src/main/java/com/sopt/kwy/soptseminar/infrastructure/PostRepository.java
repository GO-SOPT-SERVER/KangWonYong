package com.sopt.kwy.soptseminar.infrastructure;

import com.sopt.kwy.soptseminar.domian.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {
    void save(Post post);

    List<Post> findAllBy();

    Optional<Post> findById(Long postId);

    void deleteById(Long postId);
}
