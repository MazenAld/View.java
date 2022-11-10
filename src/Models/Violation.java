package Models;

import java.util.Objects;

public class Violation {
    private int offence_id;
    private String offence_type;
    private String date;
    static int conuter;
    int car_id;
    String car_type;

    private Car car;


    public Violation() {
    }



    public Violation(int offence_id, String offence_type, String date, int car_id , String car_type) {
        Car c=new Car();
        this.offence_id=offence_id;
        this.offence_type=offence_type;
        this.date=date;
        this.car_id=c.setCar_id(car_id);
        this.car_type=c.setCar_type(car_type);

    }

    public Violation(String offence_type,int offence_id,  String date, int car_id , String car_type) {

        this.offence_id=offence_id;
        this.offence_type=offence_type;
        this.date=date;
        this.car_id=car_id;
        this.car_type=car_type;

    }


    public int getOffence_id() {
        return offence_id;
    }

    public void setOffence_id(int offence_id) {
        this.offence_id = offence_id;
    }

    public String getOffence_type() {
        return offence_type;
    }

    public void setOffence_type(String offence_type) {
        this.offence_type = offence_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public int getConuter() {
        return conuter;
    }


    @Override
    public String toString() {
        return " <<<Violation>>>" + "\n"+
                "  Violation_id= " + offence_id +"\n"+
                "  Violation_type= " + offence_type + '\'' + "\n"+
                "  Violation_date= " + date +"\n"+ "  Car_id= "+car_id+ "\n" +"  Car_type= "+car_type+ "\n" +"  counter= "+Violation.conuter;
    }

    public String print() {
        Car c=new Car();
        return  offence_id + "\t\t" + offence_type + "\t\t" + date + "\t\t"+ car_id +"\t\t" + car_type +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Violation that = (Violation) o;
        return getOffence_id() == that.getOffence_id() && getDate() == that.getDate() && Objects.equals(getOffence_type(), that.getOffence_type());
    }




    }

