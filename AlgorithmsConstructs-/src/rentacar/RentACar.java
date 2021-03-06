package rentacar;

// This line will give you an error until you create the needed class.
import algorithmsandconstructs.BookingSystem;

import algorithmsandconstructs.BookingSystemInterface;
import algorithmsandconstructs.RentACarInterface;
import algorithmsandconstructs.enums.Make;
import algorithmsandconstructs.enums.Month;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// INCLUDE HERE THE LINK TO THE GIT REPOSITORY AS A COMMENT!!!!
//https://github.com/JulianaMWViana/AlgorithmsConstructs-
/**
 *
 * @author apont
 */
public class RentACar {

    /**
     * Do not change the signature of the main method!
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        BookingSystemInterface bookingSystem = new BookingSystem();

        String file = "amilcar_rentals.txt";
        BufferedReader in = new BufferedReader(new FileReader(file));

        RentACarInterface rentACar = bookingSystem.setupRentACar(in);

        // Get the name of the car rental
        System.out.println("Name of the company: " + rentACar.getName());

        // Print the number of cars in the rent-a-car
        System.out.println("Number of cars: " + rentACar.getNumberOfCars());

        // Check if there is a BMW car available for 5 days from the 1st
        // of January
        System.out.println("BMW car available for 5 days from the 1st of January: "
                + rentACar.checkAvailability(Month.JANUARY, 1, Make.BMW, 5));

        // Get the id of the car available
        System.out.println("Id of the car available: " + rentACar.getCarAvailable(Month.JANUARY, 1, Make.BMW, 5));

        // Try some bookings
        System.out.println(rentACar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentACar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentACar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentACar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentACar.bookCar(Month.JANUARY, 6, Make.BMW, 7));
        System.out.println(rentACar.bookCar(Month.FEBRUARY, 3, Make.FIAT, 10));
        System.out.println(rentACar.bookCar(Month.MARCH, 10, Make.FORD, 12));

    }

}
