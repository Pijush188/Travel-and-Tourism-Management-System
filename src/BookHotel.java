import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class BookHotel extends JFrame implements ActionListener {
    Choice chotel, cac, cfood, cloc;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JTextField tfpersons, tfdays;
    JButton checkPrice, bookPackage, back;
    String username;
    Random random;

    BookHotel(String username) {
        this.username = username;
        setBounds(200, 175, 1100, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Heading
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 5, 300, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        // Username
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 150, 25);
        add(labelusername);

        // Select Hotel
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40, 110, 150, 25);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 110, 150, 25);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT DISTINCT name FROM hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Location
        JLabel lblloc = new JLabel("Location");
        lblloc.setBounds(40, 150, 150, 25);
        lblloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblloc);

        cloc = new Choice();
        cloc.setBounds(250, 150, 150, 25);
        add(cloc);

        chotel.addItemListener(e -> updateLocations());
        updateLocations();

        // Number of People
        JLabel lblpersons = new JLabel("No. of People");
        lblpersons.setBounds(40, 190, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 190, 150, 25);
        add(tfpersons);

        // Number of Days
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40, 230, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 230, 150, 25);
        add(tfdays);

        // AC/Non-AC
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40, 270, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 270, 150, 25);
        add(cac);

        // Food Included
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40, 310, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 310, 150, 25);
        add(cfood);

        // ID Type
        JLabel lblid = new JLabel("ID Type");
        lblid.setBounds(40, 350, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 350, 150, 25);
        add(labelid);

        // Number
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 390, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 390, 150, 25);
        add(labelnumber);

        // Phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 430, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 430, 150, 25);
        add(labelphone);

        // Total Price
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(40, 470, 150, 25);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(250, 470, 150, 25);
        add(labelprice);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username='" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Buttons
        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(600, 420, 120, 25);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBackground(Color.BLACK);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Book Hotel");
        bookPackage.setBounds(740, 420, 120, 25);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBackground(Color.BLACK);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back = new JButton("Back");
        back.setBounds(880, 420, 120, 25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        setVisible(true);
    }

    private void updateLocations() {
        cloc.removeAll();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT location FROM hotel WHERE name='" + chotel.getSelectedItem() + "'");
            while (rs.next()) {
                cloc.add(rs.getString("location"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkPrice) {
            try {
                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());

                if (persons <= 0 || days <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter valid data");
                    return;
                }

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT * FROM hotel WHERE name='" + chotel.getSelectedItem() + "' AND location='" + cloc.getSelectedItem() + "'");
                if (rs.next()) {
                    int cost = rs.getInt("costperperson");
                    int ac = rs.getInt("acroom");
                    int food = rs.getInt("foodincluded");

                    int total = cost * persons * days;
                    total += cac.getSelectedItem().equals("AC") ? ac * persons * days : 0;
                    total += cfood.getSelectedItem().equals("Yes") ? food * persons * days : 0;

                    labelprice.setText("Rs " + total);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookPackage) {
            try {
                random = new Random();
                int bId = random.nextInt(9000) + 1000;
                String bookingId = Integer.toString(bId);

                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookhotel VALUES('" + labelusername.getText() + "', '"
                        + chotel.getSelectedItem() + "', '" + tfpersons.getText() + "', '"
                        + tfdays.getText() + "', '" + cac.getSelectedItem() + "', '"
                        + cfood.getSelectedItem() + "', '" + labelid.getText() + "', '"
                        + labelnumber.getText() + "', '" + labelphone.getText() + "', '"
                        + labelprice.getText() + "', '" + bookingId + "', '" + cloc.getSelectedItem() + "')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("");
    }
}


