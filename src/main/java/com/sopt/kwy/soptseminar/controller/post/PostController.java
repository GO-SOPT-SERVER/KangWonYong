package com.sopt.kwy.soptseminar.controller.post;

import com.sopt.kwy.soptseminar.common.dto.ApiResponseDto;
import com.sopt.kwy.soptseminar.controller.post.dto.request.PostReqDto;
import com.sopt.kwy.soptseminar.controller.post.dto.response.PostResDto;
import com.sopt.kwy.soptseminar.exception.SuccessStatus;
import com.sopt.kwy.soptseminar.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto createPost(
            @PathVariable final Long userId,
            @RequestBody final PostReqDto body
    ) {
        postService.createPost(userId, body);
        return ApiResponseDto.success(SuccessStatus.POST_CREATED_SUCCESS);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<List<PostResDto>> getPosts() {
        return ApiResponseDto.success(
                SuccessStatus.POSTS_GET_SUCCESS,
                postService.getPosts()
        );
    }

    @PutMapping("/{userId}/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto updatePost(
            @PathVariable final Long userId,
            @PathVariable final Long postId,
            @RequestBody final PostReqDto body
    ) {
        postService.updatePost(userId, postId, body);
        return ApiResponseDto.success(SuccessStatus.POST_UPDATE_SUCCESS);
    }

    @DeleteMapping("/{userId}/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto removePost(
            @PathVariable final Long userId,
            @PathVariable final Long postId
    ) {
        postService.deletePost(userId, postId);
        return ApiResponseDto.success(SuccessStatus.POST_DELETE_SUCCESS);
    }
}
