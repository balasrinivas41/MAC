package DataObjects;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;



public class ButtonEx
{


public static void mains(String[] args)
{
ColorsFrame frame=new ColorsFrame();
//System.out.println("Hello world");

}
}



class ColorsFrame extends Frame implements ActionListener
{
Button b1,b2,b3;
Label name;
Label passwd;
TextField t1,t2;
Panel controlpanel;


ColorsFrame()
{
this.setVisible(true);
this.setSize(700,700);
this.setTitle("Button Example");
controlpanel=new Panel();
controlpanel.setLayout(new FlowLayout());
name=new Label("User ID:");
passwd=new Label("password: ");
t1=new TextField(10);
t2=new TextField(10);
t2.setEchoChar('*');
t1.setBounds(50,100, 200,30);  



b1=new Button("Login");
b2=new Button("GREEN");
b3=new Button("BLUE");


b1.setBackground(Color.red);
b2.setBackground(Color.green);
b3.setBackground(Color.blue);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);


this.add(controlpanel);
controlpanel.add(name);
controlpanel.add(t1);
controlpanel.add(passwd);
controlpanel.add(t2);

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

if(button_label.equals("Login"))
{
	
String user=t1.getText();
String pd1=t2.getText();
if(user.equals("bala")){
JOptionPane.showMessageDialog(this," correct password");
}


try{
	 Connection Con= DbConnection.GetDbConnection();
	 JOptionPane.showMessageDialog(this," established");
	 
	 Statement stmt = null;	 stmt = Con.createStatement();

      String s=user;

	 String sql = "SELECT username,passwd FROM userpasswd where username='" +s+"'";
     ResultSet rs = stmt.executeQuery(sql);
     //STEP 5: Extract data from result set
     String ud;
     String pd2="i";
     while(rs.next()){
        //Retrieve by column name
    	  ud  = rs.getString("username");
          pd2 = rs.getString("passwd");
        

        //Display values
        System.out.println("userid: " + ud);
        System.out.println("passwd: " + pd2);
        
        
     }//endwhile
     System.out.println("passwd: " + pd2);
     System.out.println("passwd: " + pd1);
     
     
    /* if(pd1.equals(pd2))
     {
    	 System.out.println("not printing password 1");
    	 JOptionPane.showMessageDialog(this,"password matches bala");
    	 }*/
     
     
   if(pd2.trim().equals(pd1))
     {
    	 System.out.println("not printing password2 ");
    	 JOptionPane.showMessageDialog(this,"password matches bala");
    	 }
  
     
     
     
     else
     {
    	 System.out.println("not mached ");
    	 JOptionPane.showMessageDialog(this,"notmached");
    	
    	 
     }
    	 
     
     rs.close();

	 
	 
	 
	 

	
	 Con.close(); 
	  }//end try
catch(SQLException se){
    //Handle errors for JDBC
        se.printStackTrace();
     }
	 catch(Exception ex)
	 {
	 }
     


}//end if button

/*else{
JOptionPane.showMessageDialog(this,"wrong password","Error Message Box",JOptionPane.ERROR_MESSAGE);
}
this.setBackground(Color.red);
}

if(button_label.equals("GREEN"))
{
this.setBackground(Color.green);
}

if(button_label.equals("BLUE"))
{
this.setBackground(Color.blue);
}*/


}//end method


//}
}//end class









