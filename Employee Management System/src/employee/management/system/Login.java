package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{ 
    
    JTextField userTF , PasswordTF;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);
        
         userTF = new JTextField();
        userTF.setBounds(150,20,150,30);
        add(userTF);
        
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);
        
        PasswordTF = new JTextField();
        PasswordTF.setBounds(150,70,150,30);
        add(PasswordTF);
        
        JButton Login = new JButton("Login");
        Login.setBounds(150,140,150,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.white);
        Login.setFocusPainted(false); // This line removes the inside border
        Login.addActionListener(this);
        add(Login);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpg"));
        Image i1 = i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(350,0,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(350,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String UserName = userTF.getText();
            String Password = PasswordTF.getText();
            
            JDBC c = new JDBC();
            
            String query = "select * from login where username = '" + UserName+"' and password = '"+Password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                        new Index();
                
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Username or password");
                setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
