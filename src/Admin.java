import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Admin extends JFrame implements ActionListener {
    JButton login, back;
    JTextField tfusername,tfpassword;
    Admin()
    {
        //create frame
        setSize(900,400);
        setLocation(550,300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        //panel for user icon
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        //user icon
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/admin-login.png"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,80,200,200);
        p1.add(image);
        //panel for elements
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        //username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        p2.add(lblusername);
        tfusername=new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        //password
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        p2.add(lblpassword);
        tfpassword=new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        //login button
        login=new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.setFocusable(false);
        login.addActionListener(this);
        p2.add(login);

        back=new JButton("Back");
        back.setBounds(230,200,130,30);
        back.setBackground(new Color(133,193,233));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setFocusable(false);
        back.addActionListener(this);
        p2.add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String username=tfusername.getText();
            String password=tfpassword.getText();
            try {
                String query = "select * from admin where password='" + password+ "' AND username='" + username + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading("Admin",username);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                    setVisible(false);
                    new User();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new User();
        }
    }
    public static void main(String[] args)
    {

        new Admin();
    }
}