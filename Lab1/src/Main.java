import dao.CartDAO;
import domain.Book;
import domain.Cart;
import domain.Customer;
import domain.Order;
import service.BookService;
import service.CartService;
import service.OrderService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookService bookService = new BookService();
        OrderService orderService = new OrderService();
        CartService cartService = new CartService();

        List<Book> books = bookService.getAllBooks();

        List<Book> searchedBook = bookService.searchBooks("Hunger");

        System.out.println("Searched Book:" + searchedBook);

        Customer customer = new Customer("Rene De Jong", "8984329", "rene@email.com");

       String customerCartId = cartService.createCart(customer);
       cartService.addToCart(customerCartId, books.get(0), 2);
       cartService.addToCart(customerCartId, books.get(1), 1);
       cartService.addToCart(customerCartId, books.get(2), 3);

       cartService.changeQuantity(customerCartId, books.get(1), 3);

       cartService.removeFromCart(customerCartId, books.get(2));

       Cart customerCart = cartService.getCart(customerCartId);

       Order order = orderService.placeOrder(customerCart,
               "Fairfield Shipping",
               "Fairfield Billing");

       System.out.println(order);


    }
}