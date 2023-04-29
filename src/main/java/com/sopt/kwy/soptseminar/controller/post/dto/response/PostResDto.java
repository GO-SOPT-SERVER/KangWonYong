package com.sopt.kwy.soptseminar.controller.post.dto.response;

import com.sopt.kwy.soptseminar.controller.user.dto.response.UserResDto;
import java.util.Date;
import lombok.Getter;

@Getter
public class PostResDto {
    private Long id;
    private String title;
    private String content;
    private Date createdAt;
    private UserResDto user;
}
