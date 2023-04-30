package com.sopt.kwy.soptseminar.service;

import com.sopt.kwy.soptseminar.controller.post.dto.request.PostReqDto;
import com.sopt.kwy.soptseminar.domian.Post;
import com.sopt.kwy.soptseminar.infrastructure.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void createPost(Long userId, PostReqDto body) {
        Post newPost = Post.builder()
                .title(body.getTitle())
                .content(body.getContent())
                .userId(userId)
                .build();
        postRepository.save(newPost);
    }
}
