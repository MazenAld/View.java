package GUI;

import Models.Controller;
import Models.Violation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GUI {
    Controller c;
    private JPanel mainPanel;
    private JButton addViolationButton;
    private JButton deleteViolationButton;
    private JButton viewAllViolationsButton;
    private JButton searchForViolationButton;
    private JButton saveAndExitButton;
    private JPanel allCards;
    private JPanel c1;
    private JPanel c2;
    private JPanel c3;
    private JPanel c4;
    private JPanel c5;
    private JTextField Violation_number_TextField;
    private JTextField Violation_type_textField;
    private JTextField Violation_date_textField;
    private JTextField Car_number_textfield;
    private JTextField Car_type_textField;
    private JButton addViolationButton1;
    private JTextArea textArea1;
    private JTextField Delete_violation_textFiled;
    private JButton deleteButton;
    private JTextField Search_for_violation_textfield;
    private JTextArea textArea2;
    private JButton searchButton;
    private JTextField save_and_exit_textfield;
    private JButton saveAndExitButton1;
    private JTextField addViolationTextField;

    public GUI() throws FileNotFoundException {
        c=new Controller();
        addViolationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c1);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        deleteViolationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c2);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        viewAllViolationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c3);
                allCards.repaint();
                allCards.revalidate();
                String s="Violation_ID  Violation_type   Violation_date   Car_ID  Car_type \n";
                Violation[] all=c.viewAllTrafficOffence();
                for (Violation x:all){
                    if (x!=null)
                        s=s+x.print();
                }
                textArea1.setText(s);
            }
        });
        searchForViolationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c4);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        saveAndExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c5);
                allCards.repaint();
                allCards.revalidate();
            }
        });

        addViolationButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(Violation_number_TextField.getText());
                String t=Violation_type_textField.getText();
                String d=Violation_date_textField.getText();
                int c_id=Integer.parseInt(Car_number_textfield.getText());
                String ct=Car_type_textField.getText();
                boolean added=c.addNewTrafficOffence(id,t,d,c_id,ct);
                if (added)
                {
                    JOptionPane.showMessageDialog(null,"Added Succesfully");
                Violation_number_TextField.setText("");
                Violation_type_textField.setText("");
                Violation_date_textField.setText("");
                Car_number_textfield.setText("");
                Car_type_textField.setText("");

                }
                else JOptionPane.showMessageDialog(null,"Error");
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(Delete_violation_textFiled.getText());
               boolean deleted= c.DeleteTrafficOffence(id);
               if (deleted)
               {
                   JOptionPane.showMessageDialog(null,"Deleted Successfully");
                   Delete_violation_textFiled.setText("");
               }
               else JOptionPane.showMessageDialog(null,"Sorry, There is no Violation with this ID");
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(Search_for_violation_textfield.getText());
              Violation v=  c.searchForTrafficOffence(id);
              if (v!=null) {
                  textArea2.setText(v.toString());
                  Search_for_violation_textfield.setText("");
              }
              else{
                  textArea2.setText("Not found");
                  Search_for_violation_textfield.setText("");

              }

            }
        });
        saveAndExitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   c.writeTrafficOffenceFile();
                   JOptionPane.showMessageDialog(null,"Save Successfully");
                    System.exit(0);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(800,800);
        frame.setVisible(true);
    }
}
