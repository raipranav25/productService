package com.productservice.productservice.inheritanceRelation.SIngleClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "single_ta")
public class Ta extends user{
}
