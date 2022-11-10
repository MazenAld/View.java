package Main;

import Models.Car;
import Models.Controller;
import Models.Violation;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class View {
    static Scanner in= new Scanner(System.in);
    static Controller cont;

    static {
        try {
            cont = new Controller();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  void start() throws FileNotFoundException {
        System.out.println(" <<<______________________________>>>");
        System.out.println("|<< Traffic violation Registration System >>|");
        System.out.println(" <<<<____________________________>>>>");

        while (true) {
            System.out.println(" ************************************ ");

            System.out.println("1: Add New Violation\n2: View All Violation\n" +
                    "3: Search For Violation\n4: Delete Violation\n0: Save and Exit\n");
            System.out.print("your Choice:");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    find();
                    break;

                case 4:
                    delete();
                    break;
                case 0:
                    cont.writeTrafficOffenceFile();
                    System.out.println("تم حفظ البيانات المدخلة الى ملف");
                    System.exit(0);
            }

        }
    }

    private void add() {
        int offence_id,car_id;
        String offence_type,car_type,date;
        Violation v;
        System.out.println( "<<<______________________>>>");
        System.out.println("|     New Violation Form    |");
        System.out.println( "<<<______________________>>>");
        System.out.println("Violation_ID    Violation_type    Violation_date  Car_ID  Car_type  ");
        offence_id=in.nextInt();
        offence_type=in.next();
        date=in.next();
        car_id=in.nextInt();
        car_type= in.next();

        boolean duplicated=cont.checkForDuplicate(new Violation( offence_id , offence_type, date, car_id, car_type));
        if (duplicated)
            System.out.println(" there is already Violation with this data");
        else {
            boolean success = cont.addNewTrafficOffence(offence_id,offence_type,date,car_id, car_type);
            if (success)
                System.out.println("New Violation Added Successfully");
            else
                System.out.println("incomplete addition process");

        }
    }
    private void delete() {
        int offence_id;
        System.out.print("input a Violation ID to Delete:");
        offence_id=in.nextInt();
        boolean deleted= cont.DeleteTrafficOffence(offence_id);
        if (deleted)
        {
            System.out.println("Violation "+offence_id+" Deleted SuccessFully");
        }
        else System.out.println("Sorry, There is no Violation with "+offence_id+" ID");

    }

    private void find() {

        int offence_id;
        System.out.print("input a Violation ID to search:");
        offence_id=in.nextInt();
        Violation v= cont.searchForTrafficOffence(offence_id);

        if (v!=null)

    {
            Violation l;
            System.out.println(" ________________________________________");
            System.out.println("|        Violation Search Form    | ");
            System.out.println(" ________________________________________");
            System.out.println("Violation_ID  Violation_type   Violation_date   Car_ID  Car_type ");
            System.out.println(" ________________________________________");
            System.out.println(v.getOffence_id()+"\t"+v.getOffence_type()+"\t" +
                    v.getDate()+"\t"+ v.getCar_id()+"\t"+v.getCar_type());
            System.out.println(" ________________________________________");


        }
        else System.out.println("Sorry, There is no Violation with "+offence_id+" ID");

    }



    public void view()  {
        System.out.println(" ________________________________________");
        System.out.println("|       ALL Registered Violation Report    | ");
        System.out.println(" ________________________________________");
        System.out.println("Violation_ID\t\tViolation_type\t\tViolation_date\t\tCar_ID\t\tCar_type ");
        System.out.println(" ________________________________________");

        Violation[] all= cont.viewAllTrafficOffence();
        for (int i = 0; i <all.length ; i++) {
            if (all[i]!=null)
                System.out.println(all[i].print());
        }
        System.out.println(" ________________________________________");
    }


}
