package Models;

import java.util.Objects;

public class Car {
    private int car_id;
    private String car_type;


    public Car(int car_id, String car_type) {
        this.car_id = car_id;
        this.car_type = car_type;

    }


    public Car() {
    }

    public int getCar_id() {
        return this.car_id;
    }

    public int setCar_id(int car_id) {
        this.car_id = car_id;
        return car_id;
    }

    public String getCar_type() {
        return this.car_type;
    }

    public String setCar_type(String car_type) {
        this.car_type = car_type;
        return car_type;
    }



    @Override
    public String toString() {
        return "OffenseCar{" +
                "car_id=" + car_id +
                ", car_type=" + car_type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return getCar_id() == that.getCar_id() &&  Objects.equals(getCar_type(), that.getCar_type());
    }

}
