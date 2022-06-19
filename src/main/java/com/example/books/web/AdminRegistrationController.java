package com.example.books.web;


import com.example.books.model.Book;
import com.example.books.model.User;
import com.example.books.service.AdminService;
import com.example.books.service.BookService;
import com.example.books.service.UserService;
import com.example.books.web.dto.AdminRegistrationDto;
import com.example.books.web.dto.BookAddDto;
import com.example.books.web.dto.UserAddDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adminRegistration")
public class AdminRegistrationController {
    private AdminService adminService;

    private UserService userService;

    private BookService bookService;

    public AdminRegistrationController(AdminService adminService, UserService userService, BookService bookService) {
        super();
        this.adminService = adminService;
        this.userService = userService;
        this.bookService = bookService;
    }


//    MOdel attribute values
    @ModelAttribute("admin")
    public AdminRegistrationDto adminRegistrationDto(){
        return new AdminRegistrationDto();
    }

    @ModelAttribute("user")
    public UserAddDto userAddDto(){
        return new UserAddDto();
    }

    @ModelAttribute("book")
    public BookAddDto bookAddDto(){
        return new BookAddDto();
    }


//    Mapping Web Pages
    @GetMapping
    public String showRegistration(){
        return "adminRegistration";
    }

    @GetMapping("/adduser")
    public String adduser(){
        return "adduser";
    }

    @GetMapping("/edituser/{id}")
    public String edituser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edituser";
    }
    @GetMapping("/delete/{id}")
    public String deleteuser(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/addbook")
    public String addBook(){return "addbook";}

    @GetMapping("/editbook/{id}")
    public String editbook(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "editbook";
    }

    @GetMapping("/deletebook/{id}")
    public String deletebook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/admin";
    }






//    Mapping Operations
    @PostMapping
    public String registerAdminAccount(@ModelAttribute("admin") AdminRegistrationDto adminRegistrationDto){
        adminService.save(adminRegistrationDto);
        return "redirect:/adminRegistration?success";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") UserAddDto userAddDto){
        userService.save(userAddDto);
        return "redirect:/admin";
    }

    @PostMapping("/edituser/{id}")
    public String edituser(@PathVariable Long id,@ModelAttribute("user") UserAddDto userAddDto){
        User existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setFirstName(userAddDto.getFirstName());
        existingUser.setLastName(userAddDto.getLastName());
        existingUser.setEmail(userAddDto.getEmail());
        userService.update(existingUser);
        System.out.println(userAddDto.getEmail());
        return "redirect:/admin";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute("book") BookAddDto bookAddDto){
        bookService.save(bookAddDto);
        return "redirect:/admin";
    }

    @PostMapping("/editbook/{id}")
    public String editbook(@PathVariable Long id,@ModelAttribute("book") BookAddDto bookAddDto){
        Book exitingBook = bookService.getBookById(id);
        exitingBook.setId(id);
        exitingBook.setBook_name(bookAddDto.getBook_name());
        exitingBook.setAuthor(bookAddDto.getAuthor());
        bookService.update(exitingBook);
        return "redirect:/admin";
    }
}
