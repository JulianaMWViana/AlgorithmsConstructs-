package algorithmsandconstructs;

import algorithmsandconstructs.enums.Make;
import algorithmsandconstructs.enums.Month;
import java.util.List;

/**
 *
 * @author Juliana
 */
public class RentACar implements RentACarInterface {

    private static Integer availableCarId = null;
    private List<CarInterface> cars;
    private String name;

    @Override
    public List<CarInterface> getCars() {
        return cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        boolean available = false;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getMake().equals(make)) {
                for (int j = day; j <= lengthOfRent; j++) {
                    if (cars.get(i).isAvailable(month, j - 1)) {
                        available = true;
                        availableCarId = cars.get(i).getId();
                    } else {
                        available = false;
                        availableCarId = null;
                        break;
                    }
                }
                if (available) {//searches are no longer needed
                    break;
                }
            }
        }
        return available;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        //Month.JANUARY, 1, Make.BMW, 5
        if (checkAvailability(month, day, make, lengthOfRent)) {
            return availableCarId;
        }
        return availableCarId;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        if (checkAvailability(month, day, make, lengthOfRent)) {
            for (CarInterface car : cars) {
                if(car.getId() == availableCarId){
                    for (int i = day; i <= lengthOfRent; i++) {
                        car.book(month, i - 1);
                    }
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

}
