import javax.swing.*;
import javax.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateAdmin extends JFrame implements ActionListener {
    JLabel labelusername;
    JButton add, back;
    JComboBox comboid;
    JTextField tfpassword;
    String username;
    UpdateAdmin(String username){
        this.username = username;
        //create frame
        setBounds(600,300,600,230);
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
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(30,90,150,25);
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220,90,150,25);
        add(tfpassword);

        //add
        add=new JButton("Update");
        add.setBounds(70,140,100,25);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setFocusable(false);
        add(add);

        //back
        back=new JButton("Back");
        back.setBounds(220,140,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,5,150,150);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from admin where username = '"+this.username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                tfpassword.setText(rs.getString("password"));
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
            String password = tfpassword.getText();
            try{
                Conn c = new Conn();
                String query = "update admin set password = '"+password+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Admin Details Updated Successfully");
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
        new UpdateAdmin("");
    }
}
