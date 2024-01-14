package com.productservice.productservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @Column(nullable = false, unique = true)
    private String name;

    //Fetch type eager will cause joins when category is fetched
    //from DB to get the list of products
    //Drawback is slower fetching time and uses more memory while executing DB query
    //Advantage is data is always available and single DB call over n/w.
    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER, mappedBy = "category")
    private List<Product> productlist;
}
