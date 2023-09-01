
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{
    
    
    JTable table;
    Choice cemployeeid;
    JButton search,print,update,back;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlb = new JLabel("Search by Employee Id");
        searchlb.setBounds(20,20,150,20);
        add(searchlb);
        
        
        cemployeeid = new Choice();
        cemployeeid.setBounds(180,20,150,20);
        add(cemployeeid);
        
        
        try{
            JDBC jdbc  = new JDBC();
            ResultSet rs = jdbc.s.executeQuery("Select * from employee");
            
            while(rs.next()){
                 cemployeeid.add(rs.getString("empId"));
            
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();

                
        try{
            JDBC jdbc  = new JDBC();
            ResultSet rs = jdbc.s.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                 cemployeeid.add(rs.getString("empId"));
            
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setFocusPainted(false); 
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setFocusPainted(false); 
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.setFocusPainted(false); 
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.setFocusPainted(false); 
        back.addActionListener(this);
        add(back);
        
        setSize(910,600);
        setLocation(170,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
            
            String query = "select * from employee where empId = '"+cemployeeid.getSelectedItem()+"'";
            
            try{
                JDBC jc = new JDBC();
            ResultSet rs = jc.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource()== print){
            
            try{
               table.print(); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }
            else if(ae.getSource()== update){
                setVisible(false);
                new UpdateEmployee(cemployeeid.getSelectedItem());
            
        }else{
            setVisible(false);
            new Index();
               }
             
    }
    
        public static void main(String args[]){
        new ViewEmployee();
    }
    
}
