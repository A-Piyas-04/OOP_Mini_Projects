import org.junit.jupiter.api.Test;
//import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest{

    @Test
    public void testFiction17Days() {
        Book fictionBook = new Book("Fiction");
        LibraryRental rent=new LibraryRental();
        double Rent = rent.calculateRentalFee(fictionBook,17,7.00);
        assertEquals(102,Rent);
    }

    @Test
    public void testFiction31Days() {
        Book fictionBook = new Book("Fiction");
        LibraryRental rent=new LibraryRental();
        double Rent = rent.calculateRentalFee(fictionBook,31,7.00);
        assertEquals(197,Rent);
    }



    @Test
    public void testNonFiction57Days() {
        Book fictionBook = new Book("Non-Fiction");
        LibraryRental rent=new LibraryRental();
        double Rent = rent.calculateRentalFee(fictionBook,57,7.50);
        assertEquals(397.5,Rent);
    }


    @Test
    public void testChildren42Days() {
        Book fictionBook = new Book("Children");
        LibraryRental rent=new LibraryRental();
        double Rent = rent.calculateRentalFee(fictionBook,42,6.50);
        assertEquals(263,Rent);
    }

}
