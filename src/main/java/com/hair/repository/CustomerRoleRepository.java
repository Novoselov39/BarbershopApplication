package com.hair.repository;

import com.hair.model.CustomerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

    public interface CustomerRoleRepository extends JpaRepository<CustomerRole, Long> {
        @Query(nativeQuery = true, value = "select role_id from customer_roles ur where ur.customer_id = :userId")
        List<Long> findRoleIdByCustomerId(Long userId);
    }