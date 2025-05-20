package com.bitsnbyte_product.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
public class ProductsDTO {


    private Long productId;
    private String productName;
    private String ProductDescription;
    private double productPrice;

    private Long categoryId;


}
