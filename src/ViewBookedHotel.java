import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {
    String username;
    JButton back;
    ViewBookedHotel(String username)
    {

        setBounds(550,250,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //heading
        JLabel text=new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setBounds(50,5,400,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        //username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,60,150,25);
        add(lblusername);
        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,60,150,25);
        add(labelusername);
        //hotelname
        JLabel lblname=new JLabel("Hotel Name");
        lblname.setBounds(30,100,150,25);
        add(lblname);
        JLabel labelname=new JLabel();
        labelname.setBounds(220,100,150,25);
        add(labelname);
        //persons
        JLabel lblpersons=new JLabel("No. of People");
        lblpersons.setBounds(30,140,150,25);
        add(lblpersons);
        JLabel labelpersons=new JLabel();
        labelpersons.setBounds(220,140,150,25);
        add(labelpersons);
        //no of day
        JLabel lbldays=new JLabel("No of Days");
        lbldays.setBounds(30,180,150,25);
        add(lbldays);
        JLabel labeldays=new JLabel();
        labeldays.setBounds(220,180,150,25);
        add(labeldays);
        //ac included
        JLabel lblac=new JLabel("Ac Included");
        lblac.setBounds(30,220,150,25);
        add(lblac);
        JLabel labelac=new JLabel();
        labelac.setBounds(220,220,150,25);
        add(labelac);
        //food included
        JLabel lblfood=new JLabel("Food Included");
        lblfood.setBounds(30,260,150,25);
        add(lblfood);
        JLabel labelfood=new JLabel();
        labelfood.setBounds(220,260,150,25);
        add(labelfood);
        //id
        JLabel lblid=new JLabel("Id Type");
        lblid.setBounds(30,300,150,25);
        add(lblid);
        JLabel labelid=new JLabel();
        labelid.setBounds(220,300,150,25);
        add(labelid);
        //number
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,340,150,25);
        add(lblnumber);
        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,340,150,25);
        add(labelnumber);
        //phone
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,380,150,25);
        add(lblphone);
        JLabel labelphone=new JLabel();
        labelphone.setBounds(220,380,150,25);
        add(labelphone);
        //Price
        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(30,420,150,25);
        add(lblprice);
        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,420,150,25);
        add(labelprice);
        //bookingid
        JLabel lblbookingId=new JLabel("Booking Id");
        lblbookingId.setBounds(30,460,150,25);
        add(lblbookingId);
        JLabel labelbookingId=new JLabel();
        labelbookingId.setBounds(220,460,150,25);
        add(labelbookingId);
        //location
        JLabel lblloc=new JLabel("Location");
        lblloc.setBounds(30,500,150,25);
        add(lblloc);
        JLabel labelloc=new JLabel();
        labelloc.setBounds(220,500,150,25);
        add(labelloc);

        //back
        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(130,550,100,30);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewbookedhotel.png"));
        Image i2= i1.getImage().getScaledInstance(430,430,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,50,430,430);
        add(image);


        try{
            Conn con=new Conn();
            String query="select* from bookhotel where username='"+username+"'";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                labelpersons.setText(rs.getString("persons"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
                labelbookingId.setText(rs.getString("bookingId"));
                labelloc.setText(rs.getString("location"));
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
        new ViewBookedHotel("Pijush");
    }
}