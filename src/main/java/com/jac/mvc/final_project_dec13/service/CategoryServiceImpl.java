package com.jac.mvc.final_project_dec13.service;

import com.jac.mvc.final_project_dec13.model.Category;
import com.jac.mvc.final_project_dec13.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-11
 * Project: programming3
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        Optional<Category> optional = categoryRepository.findById(categoryId);
        Category category = null;
        if (optional.isPresent()) {
            category = optional.get();
        } else {
            throw new RuntimeException("Account not found for id:: " + category);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);

    }
}

