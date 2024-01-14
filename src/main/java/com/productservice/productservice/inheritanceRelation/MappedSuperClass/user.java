package com.productservice.productservice.inheritanceRelation.MappedSuperClass;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@MappedSuperclass
public class user {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String email;
}
