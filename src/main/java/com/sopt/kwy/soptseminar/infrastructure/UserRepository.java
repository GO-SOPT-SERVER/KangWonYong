package com.sopt.kwy.soptseminar.infrastructure;

import com.sopt.kwy.soptseminar.domian.User;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);

    User findByAndNicknameOrEmail(String name, String email);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
