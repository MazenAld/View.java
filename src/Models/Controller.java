package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Controller {
    private int counter_TrafficOffence;
      private Violation[] offences;
      Car[] cars;
    public Controller() throws FileNotFoundException {
        this.counter_TrafficOffence=0;
        offences = new Violation[100];
        readTrafficOffenceFile();
    }
    public boolean addNewTrafficOffence(int offence_id ,String offence_type, String date, int car_id, String car_type) {
        if (counter_TrafficOffence < offences.length ) {
            Violation.conuter++;
            Violation t = new Violation( offence_type,offence_id, date, car_id,car_type);
            offences[counter_TrafficOffence]=t;
            counter_TrafficOffence++;
            return true;
        } else
            return false;
    }
    public Violation[] viewAllTrafficOffence()  {
        return offences;
    }

    public Violation searchForTrafficOffence(int id)
    {
        int i=0;
        boolean found=false;
        while (!found&&i<counter_TrafficOffence)
        {
            if (offences[i].getOffence_id()==id)
                found=true;
            else
                i++;

        }
        if (i<counter_TrafficOffence)
            return offences[i];
        else
            return null;
    }

    public int searchForTrafficOffenceindex(int id)
    {
        int i=0;
        boolean found=false;
        while (!found&&i<counter_TrafficOffence)
        {
            if (offences[i].getOffence_id()==id)
                found=true;
            else
                i++;

        }
        if (i<counter_TrafficOffence)
            return i;
        else
            return -1;
    }




    public boolean DeleteTrafficOffence(int id)
    {
        int index=searchForTrafficOffenceindex(id);
        if (index!=-1)
        {int i=index;
            while (i<counter_TrafficOffence)
            {
                offences[i]=offences[i + 1];
                i++;}
            offences[i]=null;
            counter_TrafficOffence--;
            return true;}
        else return false;
    }

    public boolean checkForDuplicate(Violation t)
    {
        for (int i = 0; i <counter_TrafficOffence ; i++) {
            if (offences[i].equals(t))
                return true;
        }
        return false;
    }

    public void readTrafficOffenceFile() throws FileNotFoundException {
        Scanner in= new Scanner(new File("C:\\Users\\Dell\\Desktop\\Registration system traffic violations\\src\\file\\Studentfile.txt"));
        while (in.hasNext())
        {
            int offence_id =in.nextInt();
            String offence_type=in.next();
            String date=in.next();
            int car_id =in.nextInt();
            String car_type=in.next();
            addNewTrafficOffence(offence_id,offence_type,date,car_id, car_type);
        }
        in.close();
    }
    public void writeTrafficOffenceFile() throws FileNotFoundException {
        PrintWriter writer=new PrintWriter(new File("C:\\Users\\Dell\\Desktop\\Registration system traffic violations\\src\\file\\Studentfile.txt"));
        int i=0;
        while (i<counter_TrafficOffence) {

            writer.write(offences[i].getOffence_id()+ " " + offences[i].getOffence_type()
                    + " " + offences[i].getDate() + " " + offences[i].getCar_id() + " " +offences[i].getCar_type() +"\n");
            i++;
        }
        writer.close();
    }
}
