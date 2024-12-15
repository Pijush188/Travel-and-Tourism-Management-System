import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.LinkedList;

public class UpdateHotel extends JFrame implements ActionListener {
    Choice chotel;
    JTextField tfcostperson, tfac, tffood;
    JButton update, back, search,retrieve;
    JComboBox<String> comboloc;

    UpdateHotel() {

        setBounds(500, 250, 1100, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Heading
        JLabel text = new JLabel("UPDATE HOTEL DETAILS");
        text.setBounds(100, 5, 300, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        // Select Hotel
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40, 70, 150, 25);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 70, 150, 25);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT DISTINCT Name FROM hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Search Button
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(420, 70, 100, 25);
        search.addActionListener(this);
        search.setFocusable(false);
        add(search);

        // Location
        JLabel lblloc = new JLabel("Location");
        lblloc.setBounds(40, 110, 150, 25);
        lblloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblloc);

        comboloc = new JComboBox<>();
        comboloc.setBounds(250, 110, 150, 25);
        comboloc.setBackground(Color.WHITE);
        add(comboloc);
        // Search Button
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(420, 110, 100, 25);
        retrieve.addActionListener(this);
        retrieve.setFocusable(false);
        add(retrieve);

        // Cost per person
        JLabel lblcostperson = new JLabel("Cost per person");
        lblcostperson.setBounds(40, 150, 150, 25);
        lblcostperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcostperson);

        tfcostperson = new JTextField();
        tfcostperson.setBounds(250, 150, 150, 25);
        add(tfcostperson);

        // No. of Days
        JLabel lblac = new JLabel("No. of Days");
        lblac.setBounds(40, 190, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);

        tfac = new JTextField("1");
        tfac.setBounds(250, 190, 150, 25);
        add(tfac);

        // Food Included
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40, 230, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        tffood = new JTextField();
        tffood.setBounds(250, 230, 150, 25);
        add(tffood);

        // Update Button
        update = new JButton("Update");
        update.setBounds(600, 420, 120, 25);
        update.setFocusable(false);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        // Back Button
        back = new JButton("Back");
        back.setBounds(880, 420, 120, 25);
        back.setFocusable(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updatehotel.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 20, 500, 400);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String name = chotel.getSelectedItem();
            String location = (String) comboloc.getSelectedItem();
            String cost = tfcostperson.getText();
            String ac = tfac.getText();
            String food = tffood.getText();

            try {
                Conn c = new Conn();
                String query = "UPDATE hotel SET costperperson='" + cost + "', acroom='" + ac + "', foodincluded='" + food + "' WHERE name='" + name + "' AND location='" + location + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == search) {
            try {
                Conn c = new Conn();
                String name = chotel.getSelectedItem();

                // Populate comboloc with locations based on the selected hotel
                ResultSet rs = c.s.executeQuery("SELECT DISTINCT location FROM hotel WHERE name='" + name + "'");
                comboloc.removeAllItems();
                while (rs.next()) {
                    comboloc.addItem(rs.getString("location"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == retrieve) {
            try {
                Conn c = new Conn();
                String name = chotel.getSelectedItem();

                // Populate comboloc with locations based on the selected hotel
                ResultSet rs = c.s.executeQuery("SELECT DISTINCT location FROM hotel WHERE name='" + name + "' and location ='"+comboloc.getSelectedItem()+"'");
                comboloc.removeAllItems();
                while (rs.next()) {
                    comboloc.addItem(rs.getString("location"));
                }

                // Populate the fields based on the selected hotel and location
                rs = c.s.executeQuery("SELECT * FROM hotel WHERE name='" + name + "'");
                if (rs.next()) {
                    tfcostperson.setText(rs.getString("costperperson"));
                    tfac.setText(rs.getString("acroom"));
                    tffood.setText(rs.getString("foodincluded"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateHotel();
    }
}