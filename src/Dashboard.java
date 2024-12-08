import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Dashboard extends JFrame implements ActionListener {
    JButton addPersonalDetails,updatePersonalDetails,viewPersonalDetails,deletePersonalDetails,checkpackages,bookpackages,viewpackages,viewhotels,bookhotels,viewbookedhotels,destinations,payments,calculator,notepad,about;
    int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    String username;
    Dashboard(String username){
        this.username = username;
        //setBounds(0,0,1600,100);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,screenWidth,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(9,7,50,50);
        p1.add(icon);

        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,screenHeight);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.setFocusable(false);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.setFocusable(false);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.setFocusable(false);
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,30));
        deletePersonalDetails.setFocusable(false);
        p2.add(deletePersonalDetails);

        checkpackages = new JButton("Check Package");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.setFocusable(false);
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        //book packages
        bookpackages=new JButton("Book Packages");
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,105));
        bookpackages.setFocusable(false);
        bookpackages.addActionListener(this);
        p2.add(bookpackages);

        //view packages
        viewpackages=new JButton("View Packages");
        viewpackages.setBounds(0,300,300,50);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackages.setMargin(new Insets(0,0,0,105));
        viewpackages.setFocusable(false);
        viewpackages.addActionListener(this);
        p2.add(viewpackages);

        //view hotels
        viewhotels=new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,130));
        viewhotels.setFocusable(false);
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        //book hotels
        bookhotels=new JButton("Book Hotels");
        bookhotels.setBounds(0,400,300,50);
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotels.setMargin(new Insets(0,0,0,130));
        bookhotels.setFocusable(false);
        bookhotels.addActionListener(this);
        p2.add(bookhotels);

        //view booked hotels
        viewbookedhotels=new JButton("View Booked Hotels");
        viewbookedhotels.setBounds(0,450,300,50);
        viewbookedhotels.setBackground(new Color(0,0,102));
        viewbookedhotels.setForeground(Color.WHITE);
        viewbookedhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookedhotels.setMargin(new Insets(0,0,0,60));
        viewbookedhotels.setFocusable(false);
        viewbookedhotels.addActionListener(this);
        p2.add(viewbookedhotels);

        //destinations
        destinations=new JButton("Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,125));
        destinations.setFocusable(false);
        destinations.addActionListener(this);
        p2.add(destinations);

        //payments
        payments=new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,145));
        payments.setFocusable(false);
        payments.addActionListener(this);
        p2.add(payments);

        //calculator
        calculator=new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,145));
        calculator.setFocusable(false);
        calculator.addActionListener(this);
        p2.add(calculator);

        //notepad
        notepad=new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,155));
        notepad.setFocusable(false);
        notepad.addActionListener(this);
        p2.add(notepad);

        //about
        about=new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,175));
        about.setFocusable(false);
        about.addActionListener(this);
        p2.add(about);

        //background image
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5= i4.getImage().getScaledInstance(screenWidth,screenHeight,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel bgimage=new JLabel(i6);
        bgimage.setBounds(0,0,screenWidth,screenHeight);
        add(bgimage);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(500,70,1500,80);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN,65));
        bgimage.add(text);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }
        else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }
        else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }
        else if(ae.getSource() == checkpackages){
            new CheckPackages();
        }
        else if(ae.getSource() == bookpackages){
            new BookPackages(username);
        }
        else if(ae.getSource() == viewpackages){
            new ViewPackages(username);
        }
        else if(ae.getSource() == viewhotels){
            new CheckHotels();
        }
        else if(ae.getSource() == destinations){
            new Destinations();
        }
        else if(ae.getSource() == bookhotels){
            new BookHotel(username);
        }
        else if(ae.getSource() == viewbookedhotels){
            new ViewBookedHotel(username);
        }
        else if(ae.getSource() == payments){
            new Payment(username);
        }
        else if (ae.getSource()==calculator)
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else if (ae.getSource()==notepad)
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else if(ae.getSource() == about){
            new About();
        }
        else
            new Delete(username);
    }
    public static void main(String[] args){
        new Dashboard("");
    }
}
