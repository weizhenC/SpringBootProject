package com.jac.mvc.final_project_dec13.controller;

import com.jac.mvc.final_project_dec13.model.Author;
import com.jac.mvc.final_project_dec13.service.AuthorService;
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
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //display a list of accounts
    @GetMapping("/authors")
    public String viewHomePage(Model model) {
        model.addAttribute("listAuthors",authorService.getAllAuthors());
        return "author_list";

//        return findPaginated(1, model);
    }

    @GetMapping("/showNewAuthorForm")
    public String showNewAuthorForm(Model model) {
        //create model attribute to bind form data
       Author author = new Author();
        model.addAttribute("author", author);
        return "new_author";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        //save employee to database
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/showFormForUpdateAuthor/{authorId}")
    public String showFormForUpdateAuthor(@PathVariable(value = "authorId") Long authorId, Model model) {

        //get account from the service
        Author author = authorService.findAuthorById(authorId);

        //set account as a model attribute to pre-populate the form
        model.addAttribute("author", author);
        return "update_author";
    }

    @GetMapping("/deleteAuthor/{authorId}")
    public String deleteAuthor(@PathVariable(value = "authorId") Long authorId) {

        //call delete account method
        this.authorService.deleteAuthorById(authorId);
        return "redirect:/authors";
    }


}

