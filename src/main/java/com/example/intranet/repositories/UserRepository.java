package com.example.intranet.repositories;

import com.example.intranet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Optional<List<User>> findByUserNameLikeAndUserSurnameLikeAllIgnoreCase(String userName,
                                                                           String userSurname);

    Optional<User> findByPhone(String phone);

    Optional<User> findByEmail(String email);

    Optional<User> findById(long id);

    Optional<List<User>> findByDepartmentNameLikeAllIgnoreCase(String departmentName);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);
}
