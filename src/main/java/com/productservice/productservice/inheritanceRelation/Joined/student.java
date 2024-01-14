package com.productservice.productservice.inheritanceRelation.Joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "join_student")
public class student extends user{
    private float psp;
}
