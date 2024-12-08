import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

public class BookPackages extends JFrame implements ActionListener {
    Choice cpackage;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JTextField tfpersons;
    JButton checkPrice, bookPackage,back;
    String username;
    Random random;
    BookPackages(String username){
        this.username=username;
        setBounds(430,250,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        //heading
        JLabel text=new JLabel("BOOK PACKAGE");
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
        JLabel lblpackage=new JLabel("Select Package");
        lblpackage.setBounds(40,110,150,25);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        cpackage=new Choice();
        cpackage.add("Gold-Summer Package");
        cpackage.add("Gold-Winter Package");
        cpackage.add("Silver-Summer Package");
        cpackage.add("Silver-Winter Package");
        cpackage.add("Bronze-Summer Package");
        cpackage.add("Bronze-Winter Package");
        cpackage.setBounds(250,110,150,25);
        add(cpackage);
        //head count
        JLabel lblpersons=new JLabel("No. of People");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpersons);
        tfpersons=new JTextField("1");
        tfpersons.setBounds(250,150,150,25);
        add(tfpersons);
        //id
        JLabel lblid=new JLabel("Id Type");
        lblid.setBounds(40,190,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        labelid=new JLabel();
        labelid.setBounds(250,190,150,25);
        add(labelid);
        //number
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(40,230,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        labelnumber=new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        //phone
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,270,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        labelphone=new JLabel();
        labelphone.setBounds(250,270,150,25);
        add(labelphone);
        //price
        JLabel lblprice=new JLabel("Total Price");
        lblprice.setBounds(40,310,150,25);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblprice);
        labelprice=new JLabel();
        labelprice.setBounds(250,310,150,25);
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
        checkPrice.setBounds(60,380,120,25);
        checkPrice.setFocusable(false);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBackground(Color.BLACK);
        checkPrice.addActionListener(this);
        add(checkPrice);
        //book package
        bookPackage=new JButton("Book Package");
        bookPackage.setBounds(200,380,120,25);
        bookPackage.setFocusable(false);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBackground(Color.BLACK);
        bookPackage.addActionListener(this);
        add(bookPackage);
        //back
        back=new JButton("Back");
        back.setBounds(340,380,120,25);
        back.setFocusable(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackages.png"));
        Image i2= i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkPrice){
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if (pack.equals("Gold-Summer Package")){
                cost=14000;
            }
            else if(pack.equals("Gold-Winter Package")){
                cost=14500;
            }
            else if (pack.equals("Silver-Summer Package")){
                cost=12000;
            }
            else if(pack.equals("Silver-Winter Package")){
                cost=12500;
            }
            else if (pack.equals("Bronze-Summer Package")){
                cost=10000;
            }
            else {
                cost=10500;
            }
            int persons=Integer.parseInt(tfpersons.getText());
            cost*=persons;
            labelprice.setText("Rs "+cost);
        }
        else if(ae.getSource()==bookPackage){
            try{
                random = new Random();
                int bId =random.nextInt(1000,9999);
                String bookingId= Integer.toString(bId);
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"','"+bookingId+"') ");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }

    }
    public static void main(String[] args){
        new BookPackages("Pijush");
    }
}