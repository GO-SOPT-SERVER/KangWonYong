package com.sopt.kwy.soptseminar.infrastructure;

import com.sopt.kwy.soptseminar.domian.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);
}
