package com.jac.mvc.final_project_dec13.controller;

import com.jac.mvc.final_project_dec13.model.Category;
import com.jac.mvc.final_project_dec13.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-10
 * Project: thymleaf_crud
 */

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //display a list of accounts
    @GetMapping("/categories")
    public String viewHomePage(Model model) {
        model.addAttribute("listCategories",categoryService.getAllCategories());
        return "category_list";

//        return findPaginated(1, model);
    }

    @GetMapping("/showNewCategoryForm")
    public String showNewCategoryForm(Model model) {
        //create model attribute to bind form data
       Category category = new Category();
        model.addAttribute("category", category);
        return "new_category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") Category category) {
        //save employee to database
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/showFormForUpdateCategory/{categoryId}")
    public String showFormForUpdateCategory(@PathVariable(value = "categoryId") Long categoryId, Model model) {

        //get account from the service
        Category category = categoryService.findCategoryById(categoryId);

        //set account as a model attribute to pre-populate the form
        model.addAttribute("category", category);
        return "update_category";
    }

    @GetMapping("/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {

        //call delete account method
        this.categoryService.deleteCategoryById(categoryId);
        return "redirect:/categories";
    }


}

