package com.sopt.kwy.soptseminar.infrastructure;

import com.sopt.kwy.soptseminar.domian.Board;
import org.springframework.data.repository.Repository;

public interface BoardRepository extends Repository<Board, Long> {
    void save(Board board);
}
