package com.bitsnbyte_product.services;

import com.bitsnbyte_product.dto.ProductsDTO;
import com.bitsnbyte_product.entities.Categories;
import com.bitsnbyte_product.entities.Products;
import com.bitsnbyte_product.mapper.ProductMapper;
import com.bitsnbyte_product.repositories.CategoriesRepository;
import com.bitsnbyte_product.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public ProductsDTO createProducts(ProductsDTO productsDTO) {
        Categories categories = categoriesRepository.findById(productsDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category Not Found "));
        Products products = ProductMapper.toProductsEntity(productsDTO, categories);
        products = productsRepository.save(products);
        return ProductMapper.toProductDTO(products); // entity to dto
    }

    // GET ALL PRODUCTS
    @Override
    public List<ProductsDTO> getAllProducts() {
        return productsRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }


    // GET PRODUCT BY ID
    @Override
    public ProductsDTO getProductById(Long productId) {
        Products products = productsRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Product not found with this ID : " + productId));
        return ProductMapper.toProductDTO(products); // entity to dto
    }

    @Override
    public void deleteProductsById(Long productId) {
        Products products = productsRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Product not found with this ID : " + productId));
        productsRepository.deleteById(products.getProductId());
    }

    @Override
    public ProductsDTO updateProductsById(Long productId, ProductsDTO productsDTO) {
        Products products = productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product Not Found")); // get product id
        Categories categories = categoriesRepository.findById(productsDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Product Not Found")); // get category id
        products.setProductName(productsDTO.getProductName());
        products.setProductDescription(productsDTO.getProductDescription());
        products.setProductPrice(productsDTO.getProductPrice());
        products.setCategories(categories); // set same category who get product
        Products savedProduct = productsRepository.save(products); // update product with id
        return ProductMapper.toProductDTO(savedProduct);// entity to dto
    }


}
