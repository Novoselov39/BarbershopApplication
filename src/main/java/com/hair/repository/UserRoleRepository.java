package com.hair.repository;

import com.hair.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query(nativeQuery = true, value = "select role_id from users_roles ur where ur.user_id = :userId")
    List<Long> findRoleIdByUserId(Long userId);
}
