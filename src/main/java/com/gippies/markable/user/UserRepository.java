package com.gippies.markable.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDTO, Long> {

    @Query(value="SELECT * FROM markable.users u WHERE u.username = :username", nativeQuery=true)
    Optional<UserDTO> findByUsername(@Param("username") String username);
}
