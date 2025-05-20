package com.bitsnbyte_product.controller;

import com.bitsnbyte_product.constant.CommonConstants;
import com.bitsnbyte_product.dto.ProductsDTO;
import com.bitsnbyte_product.services.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Products Rest APIS CRUD Operations",
        description = "CREATE, READ, DELETE and UPDATE operation for Products Rest APIS"
)
@RestController
@RequestMapping(CommonConstants.API_BASE_PATH)
public class ProductsController {


    @Autowired
    private ProductsService productsService;

    @Operation(
            summary = "CREATE PRODUCTS",
            description = "This REST API is used to create a new Products"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping(CommonConstants.CREATE_PRODUCTS)
    public ResponseEntity<ProductsDTO> createProducts(@RequestBody ProductsDTO productsDTO){
        return new ResponseEntity<>(productsService.createProducts(productsDTO), HttpStatus.CREATED);
    }


    @Operation(
            summary = "GET ALL PRODUCTS",
            description = "This REST API is used to Get All Products"
    )
    @GetMapping(CommonConstants.GET_ALL_PRODUCTS)
    public ResponseEntity<List<ProductsDTO>> getAllProducts(){
        return new ResponseEntity<>(productsService.getAllProducts(), HttpStatus.OK);
    }


    @Operation(
            summary = "GET PRODUCT BY ID",
            description = "This REST API is used to GET PRODUCT BY ID"
    )
    @GetMapping(CommonConstants.GET_PRODUCT_BY_ID)
    public ResponseEntity<ProductsDTO> getProductViaId(@PathVariable Long productId){
        return new ResponseEntity<>(productsService.getProductById(productId),HttpStatus.OK);
    }


    @Operation(
            summary = "DELETE PRODUCT BY ID",
            description = "This REST API is used to DELETE PRODUCT BY ID"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping(CommonConstants.DELETE_PRODUCT_BY_ID)
    public ResponseEntity<String> deleteProductViaId(@PathVariable Long productId){
        productsService.deleteProductsById(productId);
        String message = "Product has been deleted via this ID : " + productId;
        return new ResponseEntity<>(message  , HttpStatus.OK);
    }


    @Operation(
            summary = "UPDATE PRODUCT BY ID",
            description = "This REST API is used to UPDATE PRODUCT BY ID"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping(CommonConstants.UPDATE_PRODUCT_BY_ID)
    public ResponseEntity<ProductsDTO> updateProductViaId(@PathVariable Long productId, @RequestBody ProductsDTO productsDTO){
        String message = "Update product Via ID : " + productId;
        return new ResponseEntity<>(productsService.updateProductsById(productId, productsDTO), HttpStatus.OK);
    }


}
