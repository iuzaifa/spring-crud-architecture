package com.bitsnbyte_product.repositories;

import com.bitsnbyte_product.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Optional<Categories> findByCategoryName(String categoryName);

}
