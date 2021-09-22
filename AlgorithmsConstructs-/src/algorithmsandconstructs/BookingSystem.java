package algorithmsandconstructs;

import algorithmsandconstructs.enums.Make;
import algorithmsandconstructs.enums.Month;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    
                    Map<Month, boolean[]> availability = new HashMap<>();
                    for (Month month : Month.values()) {
                        availability.put(month, new boolean[month.getNumberOfDays()]);
                    }
                    car.setAvailability(availability);
                    cars.add(car);
                }
                rentACar.setCars(cars);
            }
        }
        
        return rentACar;
    }

}
