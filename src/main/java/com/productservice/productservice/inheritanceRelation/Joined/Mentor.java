package com.productservice.productservice.inheritanceRelation.Joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "join_mentor")
public class Mentor extends user {
    private int rating;
}
