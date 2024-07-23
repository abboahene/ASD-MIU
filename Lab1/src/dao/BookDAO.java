package dao;

import domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BookDAO {
    private List<Book> books;
    private AtomicInteger idGenerator = new AtomicInteger(1);

    public BookDAO() {
        this.books = new ArrayList<>(generateDummyBooks());
        for (Book book : books) {
            book.setId(idGenerator.getAndIncrement());
        }
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(idGenerator.getAndIncrement());
        books.add(book);
    }
    public List<Book> searchBooks(String query) {
        String lowercaseQuery = query.toLowerCase();
        return books.stream()
                .filter(book ->
                        book.getTitle().toLowerCase().contains(lowercaseQuery) ||
                                book.getAuthor().toLowerCase().contains(lowercaseQuery) ||
                                book.getIsbn().toLowerCase().contains(lowercaseQuery))
                .toList();
    }

    private List<Book> generateDummyBooks() {
        List<Book> dummyBooks = new ArrayList<>();

        dummyBooks.add(new Book("The Great Gatsby", "9780743273565", "F. Scott Fitzgerald", 12.99, 50));
        dummyBooks.add(new Book("To Kill a Mockingbird", "9780446310789", "Harper Lee", 14.99, 75));
        dummyBooks.add(new Book("1984", "9780451524935", "George Orwell", 11.99, 60));
        dummyBooks.add(new Book("Pride and Prejudice", "9780141439518", "Jane Austen", 9.99, 40));
        dummyBooks.add(new Book("The Catcher in the Rye", "9780316769174", "J.D. Salinger", 13.99, 55));
        dummyBooks.add(new Book("The Hobbit", "9780547928227", "J.R.R. Tolkien", 15.99, 70));
        dummyBooks.add(new Book("The Da Vinci Code", "9780307474278", "Dan Brown", 16.99, 80));
        dummyBooks.add(new Book("The Alchemist", "9780062315007", "Paulo Coelho", 10.99, 65));
        dummyBooks.add(new Book("The Hunger Games", "9780439023528", "Suzanne Collins", 12.99, 90));
        dummyBooks.add(new Book("Harry Potter and the Sorcerer's Stone", "9780590353427", "J.K. Rowling", 17.99, 100));

        return dummyBooks;
    }
}
