package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.OderBook;
import com.example.book.service.IBookService;
import com.example.book.service.IOderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;


@Controller
public class BookController {
    @Autowired
   private IBookService bookService;
    @Autowired
   private IOderBookService oderBookService;

    @GetMapping("/book")
    public String showList(@PageableDefault(page = 0, size = 2) Pageable pageable, Model model) {
        Page<Book> pages = bookService.findAll(pageable);
        model.addAttribute("list", pages);
        return "list";
    }

    @GetMapping("oder")
    public String showOder(@RequestParam int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);

        return "oder";
    }

    @PostMapping("oderBook")
    public String update(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        Random random = new Random();
        String bookCode = String.valueOf(random.nextInt(99999 - 10000 + 1) + 10000);
        if (book.getQuantity() == 0) {
            return "error";
        }
        book.setQuantity(book.getQuantity() - 1);
        bookService.update(book);
        Book book1 = new Book(book.getId());
        OderBook oderBook = new OderBook(bookCode, book1);
        oderBookService.save(oderBook);
        redirectAttributes.addFlashAttribute("mess", "success");
        redirectAttributes.addFlashAttribute("code", "mã mượn sách của bạn là " + bookCode);
        return "redirect:/book";
    }

    @PostMapping("/pay")
    public String bookReturn(@RequestParam String codeBook, RedirectAttributes redirectAttributes) {
        Book book;
        for (OderBook oderBook : oderBookService.findAll()) {
            if (oderBook.getIdCard().equals(codeBook)) {
                book = bookService.findById(oderBook.getBook().getId());
                book.setQuantity(book.getQuantity() + 1);
                bookService.update(book);
                redirectAttributes.addFlashAttribute("mess", "success");
                return "redirect:/book";
            }

        }
        return "error";
    }


}
