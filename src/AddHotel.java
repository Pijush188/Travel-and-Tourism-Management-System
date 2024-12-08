import javax.swing.*;
import javax.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddHotel extends JFrame implements ActionListener {
    JButton add, back;
    JTextField tfhotelname, tfcostperson, tfac, tffood;
    AddHotel(){
        //create frame
        setBounds(550,250,850,300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("ADD HOTEL DETAILS");
        text.setBounds(50,5,300,25);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        //username
        JLabel lblhotelname = new JLabel("Hotel Name");
        lblhotelname.setBounds(30,50,150,25);
        add(lblhotelname);

        tfhotelname = new JTextField();
        tfhotelname.setBounds(220,50,150,25);
        add(tfhotelname);


        JLabel lblcostperson = new JLabel("Cost per person");
        lblcostperson.setBounds(30,90,150,25);
        add(lblcostperson);

        tfcostperson = new JTextField();
        tfcostperson.setBounds(220,90,150,25);
        add(tfcostperson);

        JLabel lblac = new JLabel("AC Room Included Price");
        lblac.setBounds(30,130,150,25);
        add(lblac);

        tfac = new JTextField();
        tfac.setBounds(220,130,150,25);
        add(tfac);

        JLabel lblfood = new JLabel("Food Included Price");
        lblfood.setBounds(30,170,150,25);
        add(lblfood);

        //name
        tffood = new JTextField();
        tffood.setBounds(220,170,150,25);
        add(tffood);

        //add
        add=new JButton("Add");
        add.setBounds(70,220,100,25);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setFocusable(false);
        add(add);

        //back
        back=new JButton("Back");
        back.setBounds(220,220,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addhotel.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,12,300,250);
        add(image);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String hotelname = tfhotelname.getText();
            String costperperson = tfcostperson.getText();
            String ac = tfac.getText();
            String food = tffood.getText();
            try{
                Conn c = new Conn();
                String query = "insert into hotel values('"+hotelname+"', '"+costperperson+"', '"+ac+"', '"+food+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Hotel Details Added Successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddHotel();
    }
}
