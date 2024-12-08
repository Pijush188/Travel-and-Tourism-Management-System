import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewPackages extends JFrame implements ActionListener {
    String username;
    JButton back;
    ViewPackages(String username)
    {

        setBounds(550,250,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //heading
        JLabel text=new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(50,5,300,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        //username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,60,150,25);
        add(lblusername);
        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,60,150,25);
        add(labelusername);
        //package
        JLabel lblpackage=new JLabel("Package");
        lblpackage.setBounds(30,100,150,25);
        add(lblpackage);
        JLabel labelpackage=new JLabel();
        labelpackage.setBounds(220,100,150,25);
        add(labelpackage);
        //persons
        JLabel lblpersons=new JLabel("No. of People");
        lblpersons.setBounds(30,140,150,25);
        add(lblpersons);
        JLabel labelpersons=new JLabel();
        labelpersons.setBounds(220,140,150,25);
        add(labelpersons);
        //id
        JLabel lblid=new JLabel("Id Type");
        lblid.setBounds(30,180,150,25);
        add(lblid);
        JLabel labelid=new JLabel();
        labelid.setBounds(220,180,150,25);
        add(labelid);
        //number
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,220,150,25);
        add(lblnumber);
        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,220,150,25);
        add(labelnumber);
        //phone
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,260,150,25);
        add(lblphone);
        JLabel labelphone=new JLabel();
        labelphone.setBounds(220,260,150,25);
        add(labelphone);
        //Price
        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(30,300,150,25);
        add(lblprice);
        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,300,150,25);
        add(labelprice);
        //BookingId
        JLabel lblbookingid=new JLabel("Booking Id");
        lblbookingid.setBounds(30,340,150,25);
        add(lblbookingid);
        JLabel labelbookingId=new JLabel();
        labelbookingId.setBounds(220,340,150,25);
        add(labelbookingId);

        //back
        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(130,400,100,30);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewpackage.png"));
        Image i2= i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(370,30,400,400);
        add(image);


        try{
            Conn con=new Conn();
            String query="select* from bookpackage where username='"+username+"'";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next())
            {
                labelusername.setText(rs.getString("Username"));
                labelpackage.setText(rs.getString("Package"));
                labelpersons.setText(rs.getString("Persons"));
                labelid.setText(rs.getString("Id"));
                labelnumber.setText(rs.getString("Number"));
                labelphone.setText(rs.getString("Phone"));
                labelprice.setText(rs.getString("Price"));
                labelbookingId.setText(rs.getString("BookingId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);

    }
    public static void main(String[] args){
        new ViewPackages("");
    }
}