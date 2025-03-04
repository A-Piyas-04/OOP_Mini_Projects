import java.io.Serializable;
import java.time.LocalDate;

public class Cart implements Serializable {

    private Book book;
    private int quantity;
    private LocalDate date;

    public Cart(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
        this.date=LocalDate.now();
    }

    
    public LocalDate getDate(){
        return date;
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void printCartDetails() {
        System.out.println("Cart contains " + quantity + " copies of " + book.getName());
    }

    public void addMore(int more) {
        quantity += more;
    }

   
    public void removeSome(int some) {
        quantity -= some;
    }

    public void updateBookPrice(double newPrice) {
        book.setPrice(newPrice);
    }
}
