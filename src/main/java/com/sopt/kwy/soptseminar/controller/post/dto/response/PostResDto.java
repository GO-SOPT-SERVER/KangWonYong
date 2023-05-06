package com.sopt.kwy.soptseminar.controller.post.dto.response;

import com.sopt.kwy.soptseminar.controller.user.dto.response.UserResDto;
import com.sopt.kwy.soptseminar.domian.Post;
import com.sopt.kwy.soptseminar.domian.User;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostResDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private UserResDto user;

    public PostResDto(Long id, String title, String content, LocalDateTime createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = UserResDto.to(user);
    }

    public static PostResDto to(Post post) {
        return new PostResDto(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(), post.getUser());
    }
}
