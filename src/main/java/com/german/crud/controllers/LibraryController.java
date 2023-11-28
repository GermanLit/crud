package com.german.crud.controllers;

import com.german.crud.models.Book;
import com.german.crud.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class LibraryController {

    @Autowired
    private BookRepository bookRepository;

    //функция которая отслеживает определённые url адреса
    @GetMapping("/library")
    public String libraryMain(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "library-main";
    }

    @GetMapping("/library/add")
    public String libraryAdd(Model model) {
        return "library-add";
    }

    @PostMapping("/library/add")
    public String libraryBookAdd(@RequestParam String title_book,@RequestParam String author,@RequestParam String book_description, Model model) {
        Book book = new Book(title_book, author, book_description);
        bookRepository.save(book);
        return "redirect:/library";
    }

    @GetMapping("/library/{id}")
    public String libraryDetaisl(@PathVariable(value = "id") long id, Model model) {
        if (!bookRepository.existsById(id)){
            return "redirect:/library";
        }
        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "library-details";
    }

    @GetMapping("/library/{id}/edit")
    public String libraryEdit(@PathVariable(value = "id") long id, Model model) {
        if (!bookRepository.existsById(id)){
            return "redirect:/library";
        }
        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "library-edit";
    }

    @PostMapping("/library/{id}/edit")
    public String libraryBookUpdate(@PathVariable(value = "id") long id, @RequestParam String title_book, @RequestParam String author,@RequestParam String book_description, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle_book(title_book);
        book.setAuthor(author);
        book.setBook_description(book_description);
        bookRepository.save(book);
        return "redirect:/library";
    }

    @PostMapping("/library/{id}/remove")
    public String libraryBookDelete(@PathVariable(value = "id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return "redirect:/library";
    }

}
