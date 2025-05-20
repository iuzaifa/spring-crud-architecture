package com.bitsnbyte_product.controller;


import com.bitsnbyte_product.constant.CommonConstants;
import com.bitsnbyte_product.dto.CategoriesDTO;
import com.bitsnbyte_product.services.CategoriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Tag(
        name = "Categories Rest APIS CRUD Operations",
        description = "CREATE, READ, DELETE and UPDATE operation for Categories Rest APIS"
)
@RestController
@RequestMapping(CommonConstants.API_BASE_PATH)
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @Operation(
            summary = "CREATE CATEGORIES",
            description = "This REST API is used to create a new category and Avoid to duplicate entry "
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(CommonConstants.CREATE_CATEGORIES)
    public ResponseEntity<CategoriesDTO> createCategories(@RequestBody CategoriesDTO categoriesDTO){
//        CategoriesDTO savedCategory = categoriesService.createCategories(categoriesDTO);
//        return new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
        return new ResponseEntity<>(categoriesService.createCategories(categoriesDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET CATEGORIES",
            description = "This REST API is used to GET CATEGORIES"
    )
    @GetMapping(CommonConstants.GET_ALL_CATEGORIES)
    public ResponseEntity<List<CategoriesDTO>> getAllCategories(){
        List<CategoriesDTO> categories = categoriesService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Operation(
            summary = "GET CATEGORIES BY ID",
            description = "This REST API is used to GET CATEGORIES BY ID"
    )
    @GetMapping(CommonConstants.GET_CATEGORY_BY_ID)
    public ResponseEntity<CategoriesDTO> getById (@PathVariable Long categoryId){
        return new ResponseEntity<>(categoriesService.getCategoryById(categoryId),HttpStatus.OK);
    }

    @Operation(
            summary = "DELETE CATEGORIES BY ID",
            description = "This REST API is used to DELETE CATEGORIES BY ID"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(CommonConstants.DELETE_CATEGORY_BY_ID)
    public ResponseEntity<String> deleteById (@PathVariable Long categoryId){
        categoriesService.deleteCategoryById(categoryId);
        String message = "Category deleted successfully : " + categoryId;
        return ResponseEntity.ok(message);
    }

    @Operation(
            summary = "UPDATE CATEGORIES BY ID",
            description = "This REST API is used to UPDATE CATEGORIES BY ID"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(CommonConstants.UPDATE_CATEGORY_BY_ID)
    public ResponseEntity<CategoriesDTO> updateById(@PathVariable Long categoryId, @RequestBody CategoriesDTO categoriesDTO){
        return new ResponseEntity<>(categoriesService.updateCategory(categoryId, categoriesDTO), HttpStatus.OK);
    }




}
