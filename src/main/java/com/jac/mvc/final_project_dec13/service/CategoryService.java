package com.jac.mvc.final_project_dec13.service;



import com.jac.mvc.final_project_dec13.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

   void saveCategory(Category category);

    Category findCategoryById (Long categoryId);

    void deleteCategoryById(Long CategoryId);
}
