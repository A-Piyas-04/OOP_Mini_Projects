
import java.util.List;

public interface BookService {

    public Book getBookById(String bookId);

    public List<Book> getAllBooks();

    public List<Book> getBooksByCommaSeperatedBookIds(String commaSeperatedBookIds);

    public String deleteBookById(String bookId);

    public String addBook(Book book);

    public String updateBookQtyById(String bookId, int quantity);

    public String updateBook(Book book);

    public String sendEmailNotification(User user,String message);
}
