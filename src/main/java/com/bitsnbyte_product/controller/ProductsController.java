package com.bitsnbyte_product.controller;

import com.bitsnbyte_product.constant.CommonConstants;
import com.bitsnbyte_product.dto.ProductsDTO;
import com.bitsnbyte_product.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CommonConstants.API_BASE_PATH)
public class ProductsController {


    @Autowired
    private ProductsService productsService;


    // CREATE PRODUCTS
    @PostMapping(CommonConstants.CREATE_PRODUCTS)
    public ResponseEntity<ProductsDTO> createProducts(@RequestBody ProductsDTO productsDTO){
        return new ResponseEntity<>(productsService.createProducts(productsDTO), HttpStatus.CREATED);
    }

    // GET ALL PRODUCTS
    @GetMapping(CommonConstants.GET_ALL_PRODUCTS)
    public ResponseEntity<List<ProductsDTO>> getAllProducts(){
        return new ResponseEntity<>(productsService.getAllProducts(), HttpStatus.OK);
    }

    // GET PRODUCT WITH ID
    @GetMapping(CommonConstants.GET_PRODUCT_BY_ID)
    public ResponseEntity<ProductsDTO> getProductViaId(@PathVariable Long productId){
        return new ResponseEntity<>(productsService.getProductById(productId),HttpStatus.OK);
    }

    // DELETE PRODUCT VIA ID
    @DeleteMapping(CommonConstants.DELETE_PRODUCT_BY_ID)
    public ResponseEntity<String> deleteProductViaId(@PathVariable Long productId){
        productsService.deleteProductsById(productId);
        String message = "Product has been deleted via this ID : " + productId;
        return new ResponseEntity<>(message  , HttpStatus.OK);
    }

    // UPDATE PRODUCT VIA ID
    @PutMapping(CommonConstants.UPDATE_PRODUCT_BY_ID)
    public ResponseEntity<ProductsDTO> updateProductViaId(@PathVariable Long productId, @RequestBody ProductsDTO productsDTO){
        String message = "Update product Via ID : " + productId;
        return new ResponseEntity<>(productsService.updateProductsById(productId, productsDTO), HttpStatus.OK);
    }


}
