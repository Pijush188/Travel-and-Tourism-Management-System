import javax.swing.*;
import javax.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel labelusername;
    JButton add, back;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone, tfgender, tfname;
    String username;
    UpdateCustomer(String username){
        this.username = username;
        //create frame
        setBounds(550,250,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        //username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        //show username
        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        //ID
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        //ID Choice
        comboid = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Voter Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        //ID number
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        //ID number put
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        //name
        tfname = new JTextField();
        tfname.setBounds(220,170,150,25);
        add(tfname);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        add(gender);

        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);
        //add
        add=new JButton("Update");
        add.setBounds(70,430,100,25);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setFocusable(false);
        add(add);

        //back
        back=new JButton("Back");
        back.setBounds(220,430,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image i2 = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,90,300,300);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username = '"+this.username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                comboid.setSelectedItem(rs.getString("id"));
                tfname.setText(rs.getString("name"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username= labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            try{
                Conn c = new Conn();
                String query = "update customer set id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"' where username = '"+username+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
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
        new UpdateCustomer("");
    }
}
