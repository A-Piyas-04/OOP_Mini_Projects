import java.awt.print.Book;

public class LibraryRental {
    Book book;


    public double calculateRentalFee(Book book, double days,double finedRent) {
        if(days<=20){
            return days*6;
        } else if (days>20) {
            return (20*6)+(days-20)*(finedRent);
        }

        return 0;
    }

}
