package com.example.books.web;

import com.example.books.service.BookService;
import com.example.books.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private UserService userService;
    private BookService bookService;

    public MainController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String mainHome(Model model){
        model.addAttribute("book",bookService.getAllBooks());
        return "home";
    }

    @GetMapping("/adminLogin")
    public String login() {
        return "adminLogin";
    }

    @GetMapping("/admin")
    public String home(Model model) {
        model.addAttribute("user", userService.getAllUser() );
        model.addAttribute("book",bookService.getAllBooks());
        return "adminIndex";
    }
}
