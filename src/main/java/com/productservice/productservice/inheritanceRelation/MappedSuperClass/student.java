package com.productservice.productservice.inheritanceRelation.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "ms_student")
public class student extends user{
    private long psp;
}
