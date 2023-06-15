package com.sopt.kwy.soptseminar.controller.board;

import com.sopt.kwy.soptseminar.common.dto.ApiResponseDto;
import com.sopt.kwy.soptseminar.config.jwt.JwtService;
import com.sopt.kwy.soptseminar.config.resolver.UserId;
import com.sopt.kwy.soptseminar.controller.board.dto.BoardRequestDto;
import com.sopt.kwy.soptseminar.exception.SuccessStatus;
import com.sopt.kwy.soptseminar.external.client.aws.S3Service;
import com.sopt.kwy.soptseminar.service.BoardService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final S3Service s3Service;
    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto create(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardRequestDto request) {
        String boardThumbnailImageUrl = s3Service.uploadImage(request.getThumbnail(), "board");
        boardService.create(userId, boardThumbnailImageUrl, request);
        return ApiResponseDto.success(SuccessStatus.POST_CREATED_SUCCESS);
    }
}
