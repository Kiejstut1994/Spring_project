package pl.coderslab;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockBookService implements BookService {

    private static Long nextId = 4L;
    private List<Book> list = new ArrayList<>();

    public void MockBookService() {
        list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra	Kathy, Bates Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    public static Long getNextId() {
        return nextId;
    }

    public static Long setNextId(Long nextId) {
        return nextId = nextId;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public Book readBook(Long id) {
        for (Book book : list) {
            if(book.getId().equals(id)){
                return book;
            }
        }
        return list.get(0);
    }

    @Override
    public List<Book> listBooks() {
        return getList();
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        list.add(book);
    }

    @Override
    public void deleteBook(Long id) {
        setList(list.stream()
                .filter(bookId -> !(bookId.getId().equals(id)))
                .collect(Collectors.toList()));
    }

    @Override
    public void updateBook(Book book) {
        deleteBook(book.getId());
        list.add(book);
    }
}
