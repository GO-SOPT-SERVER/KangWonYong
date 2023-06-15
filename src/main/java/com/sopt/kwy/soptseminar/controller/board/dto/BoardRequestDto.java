package com.sopt.kwy.soptseminar.controller.board.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BoardRequestDto {
    @NotNull
    private MultipartFile thumbnail;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private Boolean isPublic;
}
