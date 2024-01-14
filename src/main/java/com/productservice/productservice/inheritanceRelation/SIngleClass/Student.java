package com.productservice.productservice.inheritanceRelation.SIngleClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "single_student")
@Getter
@Setter
public class Student extends user{
    private float psp;
}
