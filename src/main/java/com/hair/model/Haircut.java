package com.hair.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "haircut")
public class Haircut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private Long customerId;
    private Long hairdresserId;
    private String nameHaircut;
    private LocalDate createdAt;
}