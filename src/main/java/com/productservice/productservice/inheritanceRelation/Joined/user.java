package com.productservice.productservice.inheritanceRelation.Joined;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "join_user")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class user {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String email;
}
