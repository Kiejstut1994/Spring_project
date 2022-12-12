package pl.coderslab;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    private MockBookService mockBookService = new MockBookService();

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("/add")
    public void addBooks() {
        mockBookService.MockBookService();
    }

    //GET 	/books 	Zwraca listę wszystkich książek.
    @GetMapping
    public List<Book> listBook() {
        return mockBookService.listBooks();
    }

    //POST 	/books 	Tworzy nową książkę na podstawie danych przekazanych z formularza i zapisuje ją do bazy danych.
    @PostMapping
    public void addBook(@RequestBody Book book) {
        mockBookService.addBook(book);
    }

    //GET 	/books/{id} 	Wyświetla informacje o książce o podanym id.
    @GetMapping("/show/{id}")
    public Book getBook(@PathVariable Long id) {
        return mockBookService.readBook(id);
    }

    //PUT 	/books 	Zmienia informacje o książce o podanym id na nową.
    @PutMapping("/edit")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        mockBookService.updateBook(book);
    }

    //DELETE 	/books/{id} 	Usuwa książkę o podanym id z bazy danych.
    @DeleteMapping("/delete/{id}")
    public void removeBook(@PathVariable Long id) {
        mockBookService.deleteBook(id);
    }
}