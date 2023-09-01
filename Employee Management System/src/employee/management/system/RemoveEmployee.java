
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice cEmpId;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50,50,100,30);
        add(labelempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(160,50,100,30);
        add(cEmpId);
        
        try{
            JDBC c = new JDBC();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
        
        try{
            JDBC c = new JDBC();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));

                                
            }
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
            try{
            JDBC c = new JDBC();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));

                                
            }
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
                
            }
        
    });
        
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.BLACK);
        delete.addActionListener(this);
        delete.setFocusPainted(false); 
        add(delete);
        
        back= new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setFocusPainted(false); 
        add(back);
        
                
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i1 = i.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel image = new JLabel(i2);
        image.setBounds(350,0,600,400);
        add(image);
        
        setSize(1000,400);
        setLocation(150,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==delete){
            try{
                JDBC jc = new JDBC();
                String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                jc.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee information deleted sucessfully");
                setVisible(false);
                new Index();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Index();
        }
             
        
    }
    
    public static void main(String args[]){
        new RemoveEmployee();
    }
    
}
