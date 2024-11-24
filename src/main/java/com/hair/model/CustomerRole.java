package com.hair.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_roles")
public class CustomerRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "customer_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;
}
