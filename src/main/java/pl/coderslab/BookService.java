package pl.coderslab;

import java.util.List;

public interface BookService {
    public Book readBook(Long id);
    List<Book> listBooks();
    void addBook(Book book);
    void deleteBook(Long id);
    void updateBook(Book book);
}
