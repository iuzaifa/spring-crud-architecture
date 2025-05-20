package com.bitsnbyte_product.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;


@Schema (
        name = "Categories",
        description = "It hold Categories information along with their Product"
)

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter @Getter
public class CategoriesDTO {

    private Long categoryID;
    private String categoryName;
    private List<ProductsDTO> productsDTO;


}
