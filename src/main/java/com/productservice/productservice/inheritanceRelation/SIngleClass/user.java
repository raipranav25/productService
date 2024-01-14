package com.productservice.productservice.inheritanceRelation.SIngleClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "single_user" )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
public class user {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String email;
}
