package com.productservice.productservice.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    //CascadeType
    //Remove: Removes price when product is deleted
    //Persist: Saves price in db if not saved when product is added in DB
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(nullable = false)
    private Price price;
    private String image;
    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST})
    private Category category;
    private int inventoryCount;
}
