
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class BookServiceImpl implements BookService {
    private final BookQueryBuilder queryBuilder;

    public BookServiceImpl() {
        this.queryBuilder = new DefaultBookQueryBuilder();
    }

    public BookServiceImpl(BookQueryBuilder queryBuilder) {
        this.queryBuilder = queryBuilder;
    }

    interface BookQueryBuilder {
        String buildGetAllBooksQuery();
        String buildGetBookByIdQuery();
        String buildDeleteBookByIdQuery();
        String buildAddBookQuery();
        String buildUpdateBookQtyByIdQuery();
        String buildUpdateBookByIdQuery();
    }

    class DefaultBookQueryBuilder implements BookQueryBuilder {
        @Override
        public String buildGetAllBooksQuery() {
            return "SELECT * FROM " + BooksDBConstants.TABLE_BOOK;
        }

        @Override
        public String buildGetBookByIdQuery() {
            return "SELECT * FROM " + BooksDBConstants.TABLE_BOOK +
                   " WHERE " + BooksDBConstants.COLUMN_BARCODE + " = ?";
        }

        @Override
        public String buildDeleteBookByIdQuery() {
            return "DELETE FROM " + BooksDBConstants.TABLE_BOOK + " WHERE " +
                   BooksDBConstants.COLUMN_BARCODE + "=?";
        }

        @Override
        public String buildAddBookQuery() {
            return "INSERT INTO " + BooksDBConstants.TABLE_BOOK + " VALUES(?,?,?,?,?)";
        }

        @Override
        public String buildUpdateBookQtyByIdQuery() {
            return "UPDATE " + BooksDBConstants.TABLE_BOOK + " SET " +
                   BooksDBConstants.COLUMN_QUANTITY + "=? WHERE " +
                   BooksDBConstants.COLUMN_BARCODE + "=?";
        }

        @Override
        public String buildUpdateBookByIdQuery() {
            return "UPDATE " + BooksDBConstants.TABLE_BOOK + " SET " +
                   BooksDBConstants.COLUMN_NAME + "=? , " +
                   BooksDBConstants.COLUMN_AUTHOR + "=?, " +
                   BooksDBConstants.COLUMN_PRICE + "=?, " +
                   BooksDBConstants.COLUMN_QUANTITY + "=? " +
                   "WHERE " + BooksDBConstants.COLUMN_BARCODE + "=?";
        }
    }

    @Override
    public Book getBookById(String bookId) {
        Book book = null;
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(queryBuilder.buildGetBookByIdQuery());
            ps.setString(1, bookId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String bCode = rs.getString(1);
                String bName = rs.getString(2);
                String bAuthor = rs.getString(3);
                int bPrice = rs.getInt(4);
                int bQty = rs.getInt(5);

                book = new Book(bCode, bName, bAuthor, bPrice, bQty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        Connection con = DBUtil.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(queryBuilder.buildGetAllBooksQuery());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String bCode = rs.getString(1);
                String bName = rs.getString(2);
                String bAuthor = rs.getString(3);
                int bPrice = rs.getInt(4);
                int bQty = rs.getInt(5);

                Book book = new Book(bCode, bName, bAuthor, bPrice, bQty);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public String deleteBookById(String bookId) {
        String response = ResponseCode.FAILURE.name();
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(queryBuilder.buildDeleteBookByIdQuery());
            ps.setString(1, bookId);
            int k = ps.executeUpdate();
            if (k == 1) {
                response = ResponseCode.SUCCESS.name();
            }
        } catch (Exception e) {
            response += " : " + e.getMessage();
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public String addBook(Book book) {
        String responseCode = ResponseCode.FAILURE.name();
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(queryBuilder.buildAddBookQuery());
            ps.setString(1, book.getBarcode());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, book.getQuantity());
            int k = ps.executeUpdate();
            if (k == 1) {
                responseCode = ResponseCode.SUCCESS.name();
            }
        } catch (Exception e) {
            responseCode += " : " + e.getMessage();
            e.printStackTrace();
        }
        return responseCode;
    }

    @Override
    public String updateBookQtyById(String bookId, int quantity) {
        String responseCode = ResponseCode.FAILURE.name();
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(queryBuilder.buildUpdateBookQtyByIdQuery());
            ps.setInt(1, quantity);
            ps.setString(2, bookId);
            ps.executeUpdate();
            responseCode = ResponseCode.SUCCESS.name();
        } catch (Exception e) {
            responseCode += " : " + e.getMessage();
            e.printStackTrace();
        }
        return responseCode;
    }

    @Override
    public List<Book> getBooksByCommaSeperatedBookIds(String commaSeperatedBookIds) {
        List<Book> books = new ArrayList<Book>();
        Connection con = DBUtil.getConnection();
        try {
            String query = "SELECT * FROM " + BooksDBConstants.TABLE_BOOK +
                          " WHERE " + BooksDBConstants.COLUMN_BARCODE + 
                          " IN (" + commaSeperatedBookIds + ")";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String bCode = rs.getString(1);
                String bName = rs.getString(2);
                String bAuthor = rs.getString(3);
                int bPrice = rs.getInt(4);
                int bQty = rs.getInt(5);

                Book book = new Book(bCode, bName, bAuthor, bPrice, bQty);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public String updateBook(Book book) {
        String responseCode = ResponseCode.FAILURE.name();
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(queryBuilder.buildUpdateBookByIdQuery());
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getQuantity());
            ps.setString(5, book.getBarcode());
            ps.executeUpdate();
            responseCode = ResponseCode.SUCCESS.name();
        } catch (Exception e) {
            responseCode += " : " + e.getMessage();
            e.printStackTrace();
        }
        return responseCode;
    }

    @Override
    public String sendEmailNotification(User user, String message) {
        final String fromEmail = "bookstore@gmail.com";
        final String password = "book-store-12345";
        String toEmail = user.getEmailId();
        String subject = "Notification";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject(subject);
            msg.setText(message);

            Transport.send(msg);
            return "Email sent successfully to " + toEmail;
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send email: " + e.getMessage();
        }
    }

}
