package DataObjects;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;


class Page4
{


public static void main(String[] args)
{
	ColorsFrame3 frame=new ColorsFrame3();
//System.out.println("Hello world");

}


}





class ColorsFrame3 extends Frame implements ActionListener
{
Button b1,b2,b3;
Label name;
Choice choice;
Label passwd;
Label access;
TextField t1,t2;
Panel controlpanel;


ColorsFrame3()
{
this.setVisible(true);
this.setSize(700,700);
this.setTitle("Page4");
controlpanel=new Panel();
controlpanel.setLayout(new FlowLayout());
name=new Label("Subject:");
passwd=new Label("Object");

t1=new TextField(10);
t2=new TextField(10);
choice = new Choice();
choice.add("read");
choice.add("write");
access = new Label("access");
t2.setEchoChar('*');
t1.setBounds(50,100, 200,30);  



b1=new Button("submit");



b1.setBackground(Color.green);


b1.addActionListener(this);



this.add(controlpanel);
controlpanel.add(name);
controlpanel.add(t1);
controlpanel.add(passwd);
controlpanel.add(t2);
controlpanel.add(access);
controlpanel.add(choice);


controlpanel.add(b1);
//this.add(b2);
//this.add(b3);

 addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        }); 

 

}

 

public void actionPerformed(ActionEvent ae)
{


String button_label=ae.getActionCommand();

if(button_label.equals("submit"))
{
	
JOptionPane.showMessageDialog(this,"u clicked submit button","Error Message Box",JOptionPane.ERROR_MESSAGE);

String subj=t1.getText();
String obj=t2.getText();

System.out.println("subject is"+subj);

System.out.println("object is"+obj);




try{

Connection Con= DbConnection.GetDbConnection();
JOptionPane.showMessageDialog(this," established");

Statement stmt = null;	 stmt = Con.createStatement();
String s="subject";

String sql = "SELECT securitylevel FROM seclevel where username='" +subj+"' and type1='"+s+"' ";
ResultSet rs,rs1,rs2; 
rs= stmt.executeQuery(sql);


String sublev="o";
while(rs.next()){
    //Retrieve by column name
	  sublev= rs.getString("securitylevel");
	  
	 
	  
	 System.out.println("security level of subject is: " + sublev);

    }


String s1="object";

String sql1 = "SELECT securitylevel FROM seclevel where username='" +obj+"' and type1='"+s1+"' ";

rs1= stmt.executeQuery(sql1);
//int set=99;

String objlev="o";
while(rs1.next()){
    //Retrieve by column name
	  objlev= rs1.getString("securitylevel");
	  
	 
	  
	 System.out.println("security level of object is: " + objlev);

    }


if(!(sublev.equals("o")) || !(objlev.equals("o")))
{
	
	JOptionPane.showMessageDialog(this,"every thing is ok! ");
	
	
	
	
	String sql2 = "SELECT cat FROM seccat where username='" +subj+"' and type1='"+s+"' ";

	rs2= stmt.executeQuery(sql2);
	//int set=99;
	int i1=0;
	

	String objcat[]=new String[10];
	while(rs2.next()){
	    //Retrieve by column name
		  objcat[i1]= rs2.getString("cat");
		 
		  
		System.out.println("category of subject is: " + objcat[i1]);
		
		 i1++;

	    }
	
	
	System.out.println("category of subject is: " + i1);
	
	
	
	
	
	
	
	
}



if((sublev.equals("o")) || (objlev.equals("o")))
{
	
	JOptionPane.showMessageDialog(this,"every thing is not ok! ");
	
	
	
	
	
}










Con.close();
}catch(Exception e){
	
	
}


//this.setBackground(Color.red);
}


}


}










