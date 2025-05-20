package com.bitsnbyte_product.services;

import com.bitsnbyte_product.dto.CategoriesDTO;

import java.util.List;

public interface CategoriesService {


    CategoriesDTO createCategories(CategoriesDTO categoriesDTO);

    CategoriesDTO getCategoryById(Long categoryId);

    List<CategoriesDTO> getAllCategories();

    void deleteCategoryById(Long categoryId);

    CategoriesDTO updateCategory(Long categoryId, CategoriesDTO categoriesDTO);


}
