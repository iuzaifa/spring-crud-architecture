package com.bitsnbyte_product.services;

import com.bitsnbyte_product.dto.ProductsDTO;

import java.util.List;

public interface ProductsService {


    ProductsDTO createProducts(ProductsDTO productsDTO);

    List<ProductsDTO> getAllProducts();

    ProductsDTO getProductById(Long productId);

    void deleteProductsById(Long productId);

    ProductsDTO updateProductsById(Long productId, ProductsDTO productsDTO);
}
