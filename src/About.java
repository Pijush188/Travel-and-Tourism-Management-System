import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
    About(){
        setBounds(750,250,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        //heading
        JLabel l1=new JLabel("ABOUT");
        l1.setBounds(200,10,100,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        String s="About Our Travel and Tourism App\n"+"\nWelcome to Travel and Tourism Management , your ultimate travel companion! Our app is designed to make exploring the world seamless and exciting. Whether you're planning a weekend getaway or a once-in-a-lifetime adventure, we've got everything you need to create unforgettable memories.\n"+"\nWith Travel and Tourism Management, discover breathtaking destinations, book packages and accommodations, and curate personalized itineraries—all in one place. Stay informed with real-time updates, and unlock insider tips to explore like a local.\n\nOur user-friendly interface ensures stress-free planning, while exclusive deals and budget tools help you travel smarter. Share your experiences, find inspiration, and connect with a global community of travelers.\n\nExperience travel reimagined with Travel and Tourism Management—because the journey is just as important as the destination. Download now and start your next adventure!";
        TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        JButton back=new JButton("Back");
        back.setBounds(200,420,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new About();
    }
}