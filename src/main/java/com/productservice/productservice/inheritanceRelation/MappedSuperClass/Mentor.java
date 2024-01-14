package com.productservice.productservice.inheritanceRelation.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity( name = "ms_mentor")
public class Mentor extends user {
    private int rating;
}
