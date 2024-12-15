import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Delete extends JFrame implements ActionListener {
    JButton back,delete;
    String username;
    Delete(String username){
        this.username=username;
        setBounds(400,175,870,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(210,50,150,25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,110,150,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(210,110,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(210,170,150,25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(210,230,150,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(210,290,150,25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(350,50,150,25);
        add(lblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(530,50,150,25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(350,110,150,25);
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(530,110,150,25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(350,170,150,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(530,170,150,25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(350,230,150,25);
        add(lblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(530,230,200,25);
        add(labelemail);
        //back
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(175,350,100,30);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        //delete
        delete=new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(375,350,100,30);
        delete.setFocusable(false);
        delete.addActionListener(this);
        add(delete);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(620,30,200,200);
        add(image);

        try{
            Conn c= new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back)
            setVisible(false);
        else
        {
            try{
                Conn c=new Conn();
                c.s.executeUpdate("delete from account where username='"+this.username+"'");
                c.s.executeUpdate("delete from customer where username='"+this.username+"'");
                c.s.executeUpdate("delete from bookpackage where username='"+this.username+"'");
                c.s.executeUpdate("delete from bookhotel where username='"+this.username+"'");
                JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
                setVisible(false);
                new User();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new Delete("");
    }
}