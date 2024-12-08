import javax.swing.*;
import java.awt.*;

public class CheckPackages extends JFrame {
    CheckPackages()
    {
        setBounds(500,250,900,600);

        String[] package1={"GOLD PACKAGE","5 Days and 6 Nights","Full Airport Assistance","Full Day City Tour","Airport Greet & Hotel Drop","Free Day 3 Island Cruise","Daily Buffet","Welcome Drinks on Arrival","English Speaking Guide","BOOK NOW","SUMMER SPECIAL","Rs 14000/-","package1.jpg"};
        String[] package2={"GOLD PACKAGE","5 Days and 6 Nights","Full Airport Assistance","Full Day City Tour","Airport Greet & Hotel Drop","Bonfire & BBQ Dinner","Daily Buffet","Welcome Drinks on Arrival","English Speaking Guide","BOOK NOW","WINTER SPECIAL","Rs 14500/-","package2.jpg"};
        String[] package3={"SILVER PACKAGE","4 Days and 5 Nights","Return Airfare","Half Day City Tour","Airport Greet & Hotel Drop","Cruise with Dinner","Daily Buffet","Welcome Drinks on Arrival","English Speaking Guide","BOOK NOW","SUMMER SPECIAL","Rs 12000/-","package3.jpg"};
        String[] package4={"SILVER PACKAGE","4 Days and 5 Nights","Return Airfare","Half Day City Tour","Airport Greet & Hotel Drop","Cruise with Dinner","Daily Buffet","Welcome Drinks on Arrival","English Speaking Guide","BOOK NOW","WINTER SPECIAL","Rs 12500/-","package4.jpg"};
        String[] package5={"BRONZE PACKAGE","2 Days and 3 Nights","Toll and Entrance Free ","Visit to Park","Airport Greet & Hotel Drop","Night Safari","Daily Buffet","Welcome Drinks on Arrival","English Speaking Guide","BOOK NOW","SUMMER SPECIAL","Rs 10000/-","package5.jpg"};
        String[] package6={"BRONZE PACKAGE","2 Days and 3 Nights","Toll and Entrance Free ","Visit to Park","Airport Greet & Hotel Drop","Dawn Safari","Daily Buffet","Welcome Drinks on Arrival","English Speaking Guide","BOOK NOW","WINTER SPECIAL","Rs 10500/-","package6.jpg"};

        JTabbedPane tab=new JTabbedPane();
        tab.setBackground(new Color(252, 251, 244));
        // setLayout(null);
        JPanel p1=createPackages(package1);
        //package 1 tab
        tab.addTab("Package 1",null, p1);
        //package 2
        JPanel p2=createPackages(package2);
        tab.addTab("Package 2",null, p2);
        //package 3
        JPanel p3=createPackages(package3);
        tab.addTab("Package 3",null, p3);
        //package 4
        JPanel p4=createPackages(package4);
        tab.addTab("Package 4",null, p4);
        //package 5
        JPanel p5=createPackages(package5);
        tab.addTab("Package 5",null, p5);
        //package 6
        JPanel p6=createPackages(package6);
        tab.addTab("Package 6",null, p6);

        add(tab);

        setVisible(true);
    }
    public JPanel createPackages(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        //gold package
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(40, 5, 300, 30);
        l1.setForeground(new Color(92,139,21));
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l1);
        //package entry 1
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(70, 60, 300, 30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l2);
        //package entry 2
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(70, 105, 300, 30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l3);
        //package entry 3
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(70, 150, 300, 30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l4);
        //package entry 4
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(70, 195, 300, 30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l5);
        //package entry 5
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(70, 240, 300, 30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l6);
        //package entry 6
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(70, 285, 300, 30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l7);
        //package entry 7
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(70, 330, 300, 30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l8);
        //package entry 8
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(70, 375, 300, 30);
        l9.setForeground(Color.BLUE);
        l9.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l9);
        //package booking
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(40, 430, 300, 30);
        l10.setForeground(Color.BLACK);
        l10.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l10);
        //package booking offers
        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(60, 480, 300, 30);
        l11.setForeground(Color.MAGENTA);
        l11.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l11);
        //price
        JLabel l12 = new JLabel(pack[11]);
        l12.setBounds(500, 480, 300, 30);
        l12.setForeground(Color.CYAN);
        l12.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(l12);
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[12]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l13 = new JLabel(i3);
        l13.setBounds(360, 80, 500, 300);
        p1.add(l13);

        return p1;
    }
    public static void main(String[] args)
    {
        new CheckPackages();
    }
}