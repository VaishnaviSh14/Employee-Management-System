package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    

    JTextField tfeducation ,tffname ,tfsalary,tfaddress,tfphone,tfemail,tfDesignation,tfadhar;
    JLabel lbempId;
    JButton add,back;
    String empId;
    
    UpdateEmployee(String empId){
        this.empId = empId;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(190,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,110,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,110,150,30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,110,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(580,110,150,30);
        add(tffname);
        
        JLabel labelDOB = new JLabel("Date of Birth");
        labelDOB .setBounds(50,170,150,30);
        labelDOB .setFont(new Font("serif",Font.PLAIN,20));
        add(labelDOB );
        
        JLabel lbdob = new JLabel();
        lbdob.setBounds(200,170,150,30);
        add(lbdob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,170,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(580,170,150,30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,230,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,230,150,30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone No.");
        labelphone.setBounds(400,230,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(580,230,150,30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,290,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,290,150,30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,290,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
        
        tfeducation =new JTextField();
        tfeducation.setBounds(580, 290, 150, 30);
        add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfDesignation = new JTextField();
        tfDesignation.setBounds(200,350,150,30);
        add(tfDesignation);
        
        JLabel labeladhar = new JLabel("Adhar No.");
        labeladhar.setBounds(400,350,150,30);
        labeladhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladhar);
        
        JLabel lbladhar = new JLabel();
        lbladhar.setBounds(580,350,150,30);
        add(lbladhar);
        
        JLabel labelempID = new JLabel("Employee ID");
        labelempID.setBounds(50,400,150,30);
        labelempID.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempID);
        
        lbempId = new JLabel();
        lbempId.setBounds(200,400,150,30);
        lbempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lbempId);
        
        
        
        
        try{
            JDBC c = new JDBC();
            String query = "select * from employee where empId  = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbdob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lbladhar.setText(rs.getString("adhar"));
                tfDesignation.setText(rs.getString("designation"));
                lbempId.setText(rs.getString("empId"));


                                                
                                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        lbempId = new JLabel();
        lbempId.setBounds(200,400,150,30);
        lbempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lbempId);

        add = new JButton("Update Details ");
        add.setBounds(250,500,150,40);
        add.setFocusPainted(false); 
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back ");
        back.setBounds(450,500,150,40);
        back.setFocusPainted(false); 
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setSize(800,600);
        setLocation(250,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address= tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfDesignation.getText();

            
            try{
                JDBC jdbc = new JDBC();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                
                jdbc.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated sucessfully");
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
        new UpdateEmployee("");
    }
    
}
