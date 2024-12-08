import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewAdmin extends JFrame implements ActionListener {
    JButton back;
    ViewAdmin(String username){
        setBounds(650,300,500,250);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("View Admin Details");
        text.setBounds(50,5,300,25);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(30,110,150,25);
        add(lblpassword);

        JLabel labelpassword = new JLabel();
        labelpassword.setBounds(220,110,150,25);
        add(labelpassword);


        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(110,160,100,30);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewprofile.png"));
        Image i2 = i1.getImage().getScaledInstance(120,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300,45,120,100);
        add(image);

        try{
            Conn c= new Conn();
            String query = "select * from admin where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpassword.setText(rs.getString("password"));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new ViewAdmin("");
    }
}
