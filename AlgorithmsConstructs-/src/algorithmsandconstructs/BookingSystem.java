package algorithmsandconstructs;

import algorithmsandconstructs.enums.Make;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas de Castro
 */
public class BookingSystem implements BookingSystemInterface {

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {

        RentACar rentACar = new RentACar();

        int id = 1;
        String s;
        List<CarInterface> cars = new ArrayList<>();
        while ((s = in.readLine()) != null) {
            if (rentACar.getName() == null) {
                rentACar.setName(s);
            } else {
                String[] values = s.split(":");

                for (int i = 0; i < Integer.valueOf(values[2]); i++) {
                    Car car = new Car();
                    car.setId(id);
                    id++;
                    car.setMake(Make.valueOf(values[0]));
                    car.setRate(Double.valueOf(values[1]));
                    cars.add(car);
                }
                rentACar.setCars(cars);
            }
        }
        
        return rentACar;
    }

}
