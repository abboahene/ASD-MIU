package service;

import dao.BookDAO;
import domain.Book;

import java.util.List;

public class BookService {
    private BookDAO bookDAO = new BookDAO();

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public List<Book> searchBooks(String query) {
        return bookDAO.searchBooks(query);
    }
}
