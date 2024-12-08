import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class BookHotel extends JFrame implements ActionListener {
    Choice chotel, cac, cfood;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice ;
    JTextField tfpersons, tfdays;
    JButton checkPrice, bookPackage,back;
    String username;
    Random random;
    BookHotel(String username){
        this.username=username;
        setBounds(430,250,1100,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        //heading
        JLabel text=new JLabel("BOOK HOTEL");
        text.setBounds(100,0,300,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        //username
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblusername.setBounds(40,70,150,25);
        add(lblusername);
        labelusername=new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,150,25);
        add(labelusername);
        //select package
        JLabel lblpackage=new JLabel("Select Hotel");
        lblpackage.setBounds(40,110,150,25);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        chotel=new Choice();
        chotel.setBounds(250,110,150,25);
        add(chotel);
        try{
            Conn c=new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //head count
        JLabel lblpersons=new JLabel("No. of People");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpersons);
        tfpersons=new JTextField("1");
        tfpersons.setBounds(250,150,150,25);
        add(tfpersons);
        //Days
        JLabel lbldays=new JLabel("No. of Days");
        lbldays.setBounds(40,190,150,25);
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldays);
        tfdays=new JTextField("1");
        tfdays.setBounds(250,190,150,25);
        add(tfdays);

        JLabel lblac=new JLabel("AC/Non-Ac");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblac);
        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,150,25);
        add(cac);

        JLabel lblfood=new JLabel("Food Included");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfood);
        cfood=new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250,270,150,25);
        add(cfood);
        //id
        JLabel lblid=new JLabel("Id Type");
        lblid.setBounds(40,310,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        labelid=new JLabel();
        labelid.setBounds(250,310,150,25);
        add(labelid);
        //number
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(40,350,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        labelnumber=new JLabel();
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);
        //phone
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,390,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        labelphone=new JLabel();
        labelphone.setBounds(250,390,150,25);
        add(labelphone);
        //price
        JLabel lblprice=new JLabel("Total Price");
        lblprice.setBounds(40,430,150,25);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblprice);
        labelprice=new JLabel();
        labelprice.setBounds(250,430,150,25);
        add(labelprice);

        try{
            Conn con=new Conn();
            String query="select* from customer where username='"+username+"'";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next())
            {
                labelusername.setText(rs.getString("Username"));
                labelid.setText(rs.getString("Id"));
                labelnumber.setText(rs.getString("Number"));
                labelphone.setText(rs.getString("Phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //check price
        checkPrice=new JButton("Check Price");
        checkPrice.setBounds(600,400,120,25);
        checkPrice.setFocusable(false);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBackground(Color.BLACK);
        checkPrice.addActionListener(this);
        add(checkPrice);
        //book package
        bookPackage=new JButton("Book Hotel");
        bookPackage.setBounds(740,400,120,25);
        bookPackage.setFocusable(false);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBackground(Color.BLACK);
        bookPackage.addActionListener(this);
        add(bookPackage);
        //back
        back=new JButton("Back");
        back.setBounds(880,400,120,25);
        back.setFocusable(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel.png"));
        Image i2= i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(620,50,350,300);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkPrice) {
            Conn c = new Conn();
            try {

                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("YES") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("RS " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter valid number!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == bookPackage) {
                try {
                    random = new Random();
                    int bId =random.nextInt(1000,9999);
                    String bookingId= Integer.toString(bId);
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"', '"+labelprice.getText()+"','"+bookingId+"')");
                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                setVisible(false);
            }
        }
    public static void main(String[] args){
        new BookHotel("");
    }
}