package com.productservice.productservice.inheritanceRelation.TablePerClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
public class user {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String email;
}
