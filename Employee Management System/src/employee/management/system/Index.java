
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Index extends JFrame implements ActionListener{
    
    JButton view,add,update,remove;
    
    Index(){
        setLayout(null);
        
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i1 = i.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        image.add(heading);
        
        add = new JButton("Add Employee ");
        add.setBounds(650,80,150,40);
        add.setFocusPainted(false); 
        add.addActionListener(this);

        image.add(add);
        
        view = new JButton("View Employees ");
        view.setBounds(820,80,150,40);
        view.setFocusPainted(false); 
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee ");
        update.setBounds(650,140,150,40);
        update.setFocusPainted(false); 
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee ");
        remove.setBounds(820,140,150,40);
        remove.setFocusPainted(false); 
        remove.addActionListener(this);
        image.add(remove);

        
        setSize(1120,630);
        setLocation(80,30);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
            
        }else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
            
        }else if(ae.getSource()==update){
            setVisible(false);
            new ViewEmployee();
            
        }else{
            setVisible(false);
            new RemoveEmployee();
            
        }
        
    }
    
    public static void main(String args[]){
        new Index();
    }
    
}
