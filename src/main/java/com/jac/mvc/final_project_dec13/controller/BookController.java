package com.jac.mvc.final_project_dec13.controller;

import com.jac.mvc.final_project_dec13.model.Author;
import com.jac.mvc.final_project_dec13.model.Book;
import com.jac.mvc.final_project_dec13.model.Category;
import com.jac.mvc.final_project_dec13.service.AuthorService;
import com.jac.mvc.final_project_dec13.service.BookService;
import com.jac.mvc.final_project_dec13.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {


    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;


    @PreAuthorize("hasAuthority('world_exec')")
//    @PreAuthorize("hasRole('hr')")
    //display a list of accounts
    @GetMapping("/books")
    public String viewHomePage(Model model) {
        model.addAttribute("listBooks",bookService.getAllBooks());
        return "book_list";

//        return findPaginated(1, model);
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        //create model attribute to bind form data
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        // Check if the category of the book already exists in the database
        Category category = categoryService.findCategoryById(book.getCategory().getCategoryId());

        // If the category doesn't exist, save it to the database
        if (category == null) {
            categoryService.saveCategory(book.getCategory());
        }

        Author author = authorService.findAuthorById(book.getAuthor().getAuthorId());
        if(author == null) {
            authorService.saveAuthor(book.getAuthor());
        }

        //save employee to database
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/showFormForUpdateBook/{bookId}")
    public String showFormForUpdateBook(@PathVariable(value = "bookId") Long bookId, Model model) {

        //get account from the service
        Book book = bookService.findBookById(bookId);

        //set account as a model attribute to pre-populate the form
        model.addAttribute("book",book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable(value = "bookId") Long bookId) {

        //call delete account method
        this.bookService.deleteBookById(bookId);
        return "redirect:/books";
    }

}
