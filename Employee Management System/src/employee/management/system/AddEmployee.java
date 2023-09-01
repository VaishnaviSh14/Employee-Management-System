package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random rn = new Random();
    int number = rn.nextInt(999999);
    
    JTextField tfname ,tffname ,tfsalary,tfaddress,tfphone,tfemail,tfDesignation,tfadhar;
    JDateChooser dcDOB;
    JComboBox cbEducation;
    JLabel lbempId;
    JButton add,back;
    
    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(190,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,110,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200,110,150,30);
        add(tfname);
        
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
        
        dcDOB = new JDateChooser();
        dcDOB.setBounds(200,170,150,30);
        add(dcDOB);
        
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
        
        String courses[] ={"BBA" ,"BCA","BSC" ,"BA" ,"B.COM" ,"Btech","MBA","MCA","MA","MTech","MSC","PHD","Others"};
        cbEducation = new JComboBox(courses);
        cbEducation.setBounds(580,290,150,30);
        cbEducation.setBackground(Color.WHITE);
        add(cbEducation);
        
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
        
        tfadhar = new JTextField();
        tfadhar.setBounds(580,350,150,30);
        add(tfadhar);
        
        JLabel labelempID = new JLabel("Employee ID");
        labelempID.setBounds(50,400,150,30);
        labelempID.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempID);
        
        lbempId = new JLabel("" + number);
        lbempId.setBounds(200,400,150,30);
        lbempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lbempId);

        add = new JButton("Add Details ");
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcDOB.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address= tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbEducation.getSelectedItem();
            String designation = tfDesignation.getText();
            String adhar = tfadhar.getText();
            String empId = lbempId.getText();

            
            try{
                JDBC jdbc = new JDBC();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+adhar+"','"+empId+"')";
                
                jdbc.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added sucessfully");
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
        new AddEmployee();
    }
    
}
