package com.productservice.productservice.inheritanceRelation.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity( name = "tpc_mentor")
public class Mentor extends user {
    private int rating;
}
