package com.bitsnbyte_product.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Schema(
        name = "Products",
        description = "It hold Categories information"
)
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
