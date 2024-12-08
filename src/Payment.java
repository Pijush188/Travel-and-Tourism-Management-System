import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {
    JButton pay,back;
    Payment(String username){
        setBounds(550,200,800,600);
        setLayout(null);
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2= i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);
        //pay
        pay=new JButton("Pay");
        pay.setBounds(310,5,80,40);
        pay.setFocusable(false);
        pay.addActionListener(this);
        image.add(pay);
        //back
        back=new JButton("Back");
        back.setBounds(410,5,80,40);
        back.setFocusable(false);
        back.addActionListener(this);
        image.add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay)
        {
            setVisible(false);
            new Paytm();
        }
        else
            setVisible(false);
    }
    public static void main(String[] args)
    {
        new Payment("");
    }
}