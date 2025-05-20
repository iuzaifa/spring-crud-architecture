package com.bitsnbyte_product.controller;


import com.bitsnbyte_product.constant.CommonConstants;
import com.bitsnbyte_product.dto.CategoriesDTO;
import com.bitsnbyte_product.entities.Categories;
import com.bitsnbyte_product.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(CommonConstants.API_BASE_PATH)
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    // CREATE CATEGORIES
    @PostMapping(CommonConstants.CREATE_CATEGORIES)
    public ResponseEntity<CategoriesDTO> createCategories(@RequestBody CategoriesDTO categoriesDTO){
        return new ResponseEntity<>(categoriesService.createCategories(categoriesDTO), HttpStatus.CREATED);
    }

    // GET ALL CATEGORIES
    @GetMapping(CommonConstants.GET_ALL_CATEGORIES)
    public ResponseEntity<List<CategoriesDTO>> getAllCategories(){
        List<CategoriesDTO> categories = categoriesService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // GET BY ID
    @GetMapping(CommonConstants.GET_CATEGORY_BY_ID)
    public ResponseEntity<CategoriesDTO> getById (@PathVariable Long categoryId){
        return new ResponseEntity<>(categoriesService.getCategoryById(categoryId),HttpStatus.OK);
    }

    // DELETE BY ID
    @DeleteMapping(CommonConstants.DELETE_CATEGORY_BY_ID)
    public ResponseEntity<String> deleteById (@PathVariable Long categoryId){
        categoriesService.deleteCategoryById(categoryId);
        String message = "Category deleted successfully : " + categoryId;
        return ResponseEntity.ok(message);
    }

    // UPDATE BY ID
    @PutMapping(CommonConstants.UPDATE_CATEGORY_BY_ID)
    public ResponseEntity<CategoriesDTO> updateById(@PathVariable Long categoryId, @RequestBody CategoriesDTO categoriesDTO){
        return new ResponseEntity<>(categoriesService.updateCategory(categoryId, categoriesDTO), HttpStatus.OK);
    }




}
