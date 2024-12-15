import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class deleteHotel extends JFrame implements ActionListener {
    JButton back,delete,search;

    Choice chotel;
    JComboBox comboloc;
    deleteHotel(){
        setBounds(550,300,570,220);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("DELETE HOTEL DETAILS");
        text.setBounds(50,5,300,25);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        // Select Hotel
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40, 50, 150, 25);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 50, 150, 25);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT DISTINCT Name FROM hotel");
            while (rs.next()) {
                chotel.add(rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Search Button
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(420, 50, 100, 25);
        search.addActionListener(this);
        search.setFocusable(false);
        add(search);

        // Location
        JLabel lblloc = new JLabel("Location");
        lblloc.setBounds(40, 90, 150, 25);
        lblloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblloc);

        comboloc = new JComboBox<>();
        comboloc.setBounds(250, 90, 150, 25);
        comboloc.setBackground(Color.WHITE);
        add(comboloc);

        //back
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(70,130,100,30);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        //delete
        delete=new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(220,130,100,30);
        delete.setFocusable(false);
        delete.addActionListener(this);
        add(delete);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/deletehotel.png"));
        Image i2 = i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430,90,80,80);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back)
            setVisible(false);
        else if (ae.getSource() == search) {
            try {
                Conn c = new Conn();
                String name = chotel.getSelectedItem();

                // Populate comboloc with locations based on the selected hotel
                ResultSet rs = c.s.executeQuery("SELECT DISTINCT Location FROM hotel WHERE Name='" + name + "'");
                comboloc.removeAllItems();
                while (rs.next()) {
                    comboloc.addItem(rs.getString("Location"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            try{
                String hotelname=chotel.getSelectedItem();
                String location= (String)comboloc.getSelectedItem();

                Conn c=new Conn();
                c.s.executeUpdate("delete from hotel where Name='"+hotelname+"' and Location='"+location+"'");
                c.s.executeUpdate("delete from bookhotel where HotelName='"+hotelname+"' and Location='"+location+"'");
                JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
                setVisible(false);
                new AdminDashboard("Admin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new deleteHotel();
    }
}