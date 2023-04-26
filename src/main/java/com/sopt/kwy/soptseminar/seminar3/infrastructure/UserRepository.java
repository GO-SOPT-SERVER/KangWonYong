package com.sopt.kwy.soptseminar.seminar3.infrastructure;

import com.sopt.kwy.soptseminar.seminar3.domain.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);
}
