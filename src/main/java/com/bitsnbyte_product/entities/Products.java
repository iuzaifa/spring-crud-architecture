package com.bitsnbyte_product.entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Setter @Getter
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false )
    private Categories categories;


}
