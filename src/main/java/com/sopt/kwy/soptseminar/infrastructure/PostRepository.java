package com.sopt.kwy.soptseminar.infrastructure;

import com.sopt.kwy.soptseminar.domian.Post;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {
    void save(Post post);
}
