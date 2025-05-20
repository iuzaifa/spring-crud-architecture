package com.bitsnbyte_product.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Categories {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Products> products;



}
