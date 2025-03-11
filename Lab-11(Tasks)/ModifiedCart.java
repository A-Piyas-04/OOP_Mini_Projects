import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ModifiedCart implements Serializable {
    private Map<Book, Integer> books;
    private LocalDate date;

    public Cart() {
        this.books = new HashMap<>();
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void addBook(Book book, int quantity) {
        if (book == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid book or quantity");
        }
        books.merge(book, quantity, Integer::sum);
    }

    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.remove(book);
    }

    public void updateQuantity(Book book, int quantity) {
        if (book == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid book or quantity");
        }
        if (!books.containsKey(book)) {
            throw new IllegalStateException("Book not found in cart");
        }
        books.put(book, quantity);
    }

    public Map<Book, Integer> getBooks() {
        return new HashMap<>(books);
    }

    public void printCartDetails() {
        if (books.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        System.out.println("Cart contains:");
        books.forEach((book, qty) ->
                System.out.println(qty + " copies of " + book.getName() + " at $" + book.getPrice() + " each")
        );
        System.out.println("Total price: $" + calculateTotal());
    }

    public void addMore(Book book, int more) {
        if (book == null || more <= 0) {
            throw new IllegalArgumentException("Invalid book or quantity");
        }
        books.merge(book, more, Integer::sum);
    }

    public void removeSome(Book book, int some) {
        if (book == null || some <= 0) {
            throw new IllegalArgumentException("Invalid book or quantity");
        }
        int currentQty = books.getOrDefault(book, 0);
        if (currentQty < some) {
            throw new IllegalStateException("Not enough quantity to remove");
        }
        int newQty = currentQty - some;
        if (newQty == 0) {
            books.remove(book);
        } else {
            books.put(book, newQty);
        }
    }

    public double calculateTotal() {
        return books.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int getTotalQuantity() {
        return books.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void clear() {
        books.clear();
    }
}