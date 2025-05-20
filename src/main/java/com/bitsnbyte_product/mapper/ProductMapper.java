package com.bitsnbyte_product.mapper;

import com.bitsnbyte_product.dto.ProductsDTO;
import com.bitsnbyte_product.entities.Categories;
import com.bitsnbyte_product.entities.Products;

public class ProductMapper {


    // Entity TO DTO
    public static ProductsDTO toProductDTO (Products products){
        return new ProductsDTO(
                products.getProductId(),
                products.getProductName(),
                products.getProductDescription(),
                products.getProductPrice(),
                products.getCategories().getCategoryId()
        );

    }

    // DTO TO  Entity
    public static Products toProductsEntity(ProductsDTO productsDTO, Categories categories){
        Products products = new Products();
        products.setProductName(productsDTO.getProductName());
        products.setProductDescription(productsDTO.getProductDescription());
        products.setProductPrice(productsDTO.getProductPrice());
        products.setCategories(categories);
        return products;
    }
}
