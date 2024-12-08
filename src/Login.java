import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, passwordbt, back;
    JTextField tfusername, tfpassword;
    Login(){
        //create Frame
        setSize(900,400);
        setLocation(550,300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        //panel for usericon
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        //usericon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/user-login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,80,200,200);
        p1.add(image);

        //panel for elements
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        //username
        JLabel username= new JLabel("Username");
        username.setBounds(60,20,100,25);
        username.setFont(new Font("SAN SERIF",Font.PLAIN,22));
        p2.add(username);

        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        //password
        JLabel password= new JLabel("Password");
        password.setBounds(60,100,100,25);
        password.setFont(new Font("SAN SERIF",Font.PLAIN,22));
        p2.add(password);

        tfpassword=new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        //login button
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133, 193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.setFocusable(false);
        login.addActionListener(this);
        p2.add(login);

        back=new JButton("Back");
        back.setBounds(60,250,130,30);
        back.setBackground(new Color(133,193,233));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.setFocusable(false);
        back.addActionListener(this);
        p2.add(back);

        //signup button
        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133, 193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.setFocusable(false);
        signup.addActionListener(this);
        p2.add(signup);

        //forget password button
        passwordbt = new JButton("Forget Password?");
        passwordbt.setBounds(230,250,130,30);
        passwordbt.setBackground(new Color(133, 193,233));
        passwordbt.setForeground(Color.WHITE);
        passwordbt.setBorder(new LineBorder(new Color(133,193,233)));
        passwordbt.setFocusable(false);
        passwordbt.addActionListener(this);
        p2.add(passwordbt);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login)
        {
            String username=tfusername.getText();
            String password=tfpassword.getText();
            try {
                String query = "select * from account where password='" + tfpassword.getText() + "' AND username='" + tfusername.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    //JOptionPane.showMessageDialog(null, "Account Logged In");
                    setVisible(false);
                    new Loading(rs.getString("name"),username);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    setVisible(false);
                    new Login();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();

        }
        else{
            setVisible(false);
            new ForgetPassword();

        }
    }
    public static void main(String[] args){
        new Login();
    }
}
