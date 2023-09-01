package employee.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    
    Home(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(100,30,1200,60);
        heading.setFont(new Font("serif", Font.PLAIN, 50));
        heading.setForeground(Color.red);
        
        add(heading);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i1 = i.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel image = new JLabel(i2);
        image.setBounds(52,100,950,500);
        
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(320,420,300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.white);
        
        Border whiteBorder = BorderFactory.createLineBorder(Color.WHITE);
        clickhere.setBorder(whiteBorder);

        clickhere.setFocusPainted(false); // This line removes the inside border
        clickhere.addActionListener(this);

        image.add(clickhere);
        
        
        setSize(1070,650);
        setLocation(100,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false); 
        new Login();
        
    }
    
    public static void main(String args[]){
        new Home();
        
        
    }
    
}



