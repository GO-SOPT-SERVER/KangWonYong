package com.sopt.kwy.soptseminar.service;

import com.sopt.kwy.soptseminar.common.exception.SoptNotFoundException;
import com.sopt.kwy.soptseminar.controller.board.dto.BoardRequestDto;
import com.sopt.kwy.soptseminar.domian.Board;
import com.sopt.kwy.soptseminar.domian.User;
import com.sopt.kwy.soptseminar.exception.ErrorStatus;
import com.sopt.kwy.soptseminar.infrastructure.BoardRepository;
import com.sopt.kwy.soptseminar.infrastructure.UserRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void create(Long userId, String boardThumbnailImageUrl, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new SoptNotFoundException(ErrorStatus.NOT_FOUND_USER_EXCEPTION));

        Board newBoard = Board.newInstance(
                user,
                boardThumbnailImageUrl,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);
    }
}
