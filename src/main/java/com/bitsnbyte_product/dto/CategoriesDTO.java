package com.bitsnbyte_product.dto;
import lombok.*;

import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter @Getter
public class CategoriesDTO {

    private Long categoryID;
    private String categoryName;
    private List<ProductsDTO> productsDTO;


}
