package com.productservice.productservice.inheritanceRelation.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tpc_student")
public class student extends user {
    private long psp;
}
