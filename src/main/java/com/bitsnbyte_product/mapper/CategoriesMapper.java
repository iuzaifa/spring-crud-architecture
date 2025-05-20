package com.bitsnbyte_product.mapper;

import com.bitsnbyte_product.dto.CategoriesDTO;
import com.bitsnbyte_product.entities.Categories;
import java.util.Collections;

public class CategoriesMapper {



    // Entity To DTO
    public static CategoriesDTO toCategoryDTO (Categories categories){
        if (categories == null){
            return null;  // if categories is empty by chance
        }

        CategoriesDTO categoriesDTO = new CategoriesDTO();
        categoriesDTO.setCategoryID(categories.getCategoryId());
        categoriesDTO.setCategoryName(categories.getCategoryName());
//        categoriesDTO.setProductsDTO(categories.getProducts().stream()
//                .map(ProductMapper::toProductDTO).toList());
        categoriesDTO.setProductsDTO((categories.getProducts() != null)
                ? categories.getProducts().stream().map(ProductMapper::toProductDTO).toList()
                : Collections.emptyList());


        return categoriesDTO;

    }


    // DTO to Entity
    public static Categories toCategoriesEntity(CategoriesDTO categoriesDTO){
        if (categoriesDTO == null) {
            return null;
        }
        Categories categories = new Categories();
        categories.setCategoryId(categories.getCategoryId());
        categories.setCategoryName(categoriesDTO.getCategoryName());
        return categories;
    }
}
