package com.sopt.kwy.soptseminar.service;

import com.sopt.kwy.soptseminar.common.exception.SoptForbiddenException;
import com.sopt.kwy.soptseminar.common.exception.SoptNotFoundException;
import com.sopt.kwy.soptseminar.controller.post.dto.request.PostReqDto;
import com.sopt.kwy.soptseminar.controller.post.dto.response.PostResDto;
import com.sopt.kwy.soptseminar.domian.Post;
import com.sopt.kwy.soptseminar.exception.ErrorStatus;
import com.sopt.kwy.soptseminar.infrastructure.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
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

    @Transactional
    public List<PostResDto> getPosts() {
        return postRepository.findAllBy()
                .stream()
                .map(PostResDto::to)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updatePost(Long userId, Long postId, PostReqDto body) {
        Post post = getPost(postId, userId);
        post.update(body.getTitle(), body.getContent());
    }

    @Transactional
    public void deletePost(Long userId, Long postId) {
        getPost(postId, userId);
        postRepository.deleteById(postId);
    }

    @Transactional
    public Post getPost(Long postId, Long userId) {
        Post post = postRepository.findById(postId);
        if (post == null) throw new SoptNotFoundException(ErrorStatus.NOT_FOUND_POST_EXCEPTION);
        if (!userId.equals(post.getUserId())) throw new SoptForbiddenException(ErrorStatus.FORBIDDEN_EXCEPTION);
        return post;
    }
}
