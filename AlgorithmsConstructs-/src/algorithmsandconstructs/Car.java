package algorithmsandconstructs;

import algorithmsandconstructs.enums.Make;
import algorithmsandconstructs.enums.Month;
import java.util.Map;

/**
 *
 * @author Lucas de Castro
 */
public class Car implements CarInterface {

    private int id;
    private double rate;
    private Make make;
    private Map<Month, boolean[]> availability;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public Make getMake() {
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;
    }

    @Override
    public Map<Month, boolean[]> createAvailability() {
        return null;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        return false;
    }

    @Override
    public boolean book(Month month, int day) {
        return false;
    }

}
