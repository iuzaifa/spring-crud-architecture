package com.bitsnbyte_product.services;

import com.bitsnbyte_product.dto.CategoriesDTO;
import com.bitsnbyte_product.entities.Categories;
import com.bitsnbyte_product.exception.CategoriesExitsException;
import com.bitsnbyte_product.mapper.CategoriesMapper;
import com.bitsnbyte_product.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriesServiceImpl implements CategoriesService{

    @Autowired
    private CategoriesRepository categoriesRepository;


    // CREATE CATEGORIES
    @Override
    public CategoriesDTO createCategories(CategoriesDTO categoriesDTO) {
        Optional<Categories> categoriesOptional = categoriesRepository.findByCategoryName(categoriesDTO.getCategoryName());
        if (categoriesOptional.isPresent()){
            throw new CategoriesExitsException("Category `"+ categoriesDTO.getCategoryName() +"` already exits");
        }

        Categories categories = CategoriesMapper.toCategoriesEntity(categoriesDTO); // DTO to Entity
        categories = categoriesRepository.save(categories); // entity save
        return CategoriesMapper.toCategoryDTO(categories); // return dto
    }


    // FIND BY ID CATEGORIES
    @Override
    public CategoriesDTO getCategoryById(Long categoryId) {
        Categories categories = categoriesRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category Id not found please try again category_Id : " +categoryId));
        return CategoriesMapper.toCategoryDTO(categories);
    }

    // FIND ALL CATEGORIES
    @Override
    public List<CategoriesDTO> getAllCategories() {
        return categoriesRepository.findAll().stream().map(CategoriesMapper::toCategoryDTO).toList();
    }


    @Override
    public void deleteCategoryById(Long categoryId) {
        // Fetch the category before deleting
        Categories category = categoriesRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoriesRepository.deleteById(category.getCategoryId());
    }

    @Override
    public CategoriesDTO updateCategory(Long categoryId, CategoriesDTO categoriesDTO) {
        Categories category = categoriesRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setCategoryName(categoriesDTO.getCategoryName());
        Categories savedCategory = categoriesRepository.save(category);
        return CategoriesMapper.toCategoryDTO(savedCategory);
    }
}
