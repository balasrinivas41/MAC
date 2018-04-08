package DataObjects;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.JOptionPane;
public class RoleReg {
	
	
	public static void main(String[] args)
	{
	ColorsFrame1 frame=new ColorsFrame1();
	//System.out.println("Hello world");

	}
	
}
    class ColorsFrame1 extends Frame implements ActionListener
	{
	Button b1;
	Label name;
	Checkbox checkbox1,checkbox2,checkbox3;
	
	TextField t1;
	Panel controlpanel;
	Choice type,seclevel,cat;
	ColorsFrame1()
	{
	this.setVisible(true);
	this.setSize(700,700);
	this.setTitle("Button Example");
	controlpanel=new Panel();
	controlpanel.setLayout(new FlowLayout());
	name=new Label("name");
	
	
	t1=new TextField(10);
	//t1.setText("def");
	checkbox1 = new Checkbox("nato"); 
	checkbox2 = new Checkbox("navy");
	checkbox3 = new Checkbox("nuclear"); 
	
	
	
	t1.setBounds(50,100, 200,30); 
	type=new Choice();
	seclevel=new Choice();
	cat=new Choice();
	seclevel.add("unclassified");
	seclevel.add("classified");
	seclevel.add("secret");
	seclevel.add("topsecret");
	type.add("subject");
	type.add("object");
	//cat.add("nato");
	//cat.add("nuclear");
	//cat.add("navy");
	



	b1=new Button("Login");
	


	

	b1.addActionListener(this);
	

	this.add(controlpanel);
	//controlpanel.add(name1);
	controlpanel.add(type);
	controlpanel.add(name);
	controlpanel.add(t1);
	controlpanel.add(seclevel);
	//controlpanel.add(cat);
	controlpanel.add(checkbox1);
	controlpanel.add(checkbox2);
	controlpanel.add(checkbox3);
	
	
	

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
		
		try{
			
			 String tpe=type.getSelectedItem(); 
			 String sl=seclevel.getSelectedItem();
			 String ct=cat.getSelectedItem();
			 String nme=t1.getText();
			 //String check[]=getSelectedObjects();
			 
			 
			 System.out.println("selected index");
			 String c1="o",c2="o",c3="o";
			 if(checkbox1.getState()) 
			  c1=checkbox1.getLabel();
			 
			 if(checkbox2.getState()) 
			 c2=checkbox2.getLabel();
			 
			 if(checkbox3.getState()) 
			 c3=checkbox3.getLabel();
			 
			 
			 
			 System.out.println("checkbox label is "+c1);
			 System.out.println("checkbox label is "+c2);
			 System.out.println("checkbox label is "+c3);
			 
			 
			 
			 
			 System.out.println("type is "+tpe);
			 System.out.println("sec level is "+sl);
			 System.out.println("category is  "+ct);
			 System.out.println("name is  "+nme);
			 
			 
			 Connection Con= DbConnection.GetDbConnection();
			 JOptionPane.showMessageDialog(this," established");
			 
			 Statement stmt = null;	 stmt = Con.createStatement();
			 
			 String sql = "SELECT username FROM userpasswd";
		     ResultSet rs,rs1=null,rs2=null; 
		     rs= stmt.executeQuery(sql);
		     int set=99;
		     String ud=null;
		     while(rs.next()){
		         //Retrieve by column name
		     	  ud= rs.getString("username");
		     	  
		     	  if(ud.trim().equals(nme))
		     	  {
		     		  set=100;
		     		  System.out.println("i set 100");
		     	  }
		     	  
		     	 System.out.println("userid: " + ud);
		   
		         }
		     
		     
		     
		      // rs.beforeFirst();
		     //rs.close();
		       
		      if(set==100)
		    	  JOptionPane.showMessageDialog(this,"user name already exists bitch! ");
		       
		   if(set!=100 && !(nme.equals("")))
		     {
			   
		    	 
		    	 String sql1 = "INSERT INTO userpasswd(username)VALUES (?)";
		    	 
		    	 PreparedStatement statement = Con.prepareStatement(sql1);
		    	 
		    	 
		    	 statement.setString(1,nme);
		    	 
		    	  
		    	 int rowsInserted = statement.executeUpdate();
		    	 if (rowsInserted > 0) {
		    	     System.out.println("A new user was inserted successfully!");
		    	     JOptionPane.showMessageDialog(this,"Thank u bitch! ");
		    	 }
		    	 
		    	 
		    	 JOptionPane.showMessageDialog(this,"enter in to second resultset! ");
		    	 
		    	 
		    	 String sql2 = "SELECT username,securitylevel,type1 FROM seclevel";
			     rs1 = stmt.executeQuery(sql2);
			     int set1=99;
			     String ud1=null,ud2=null,ud3=null;
			     
			     while(rs1.next()){
			         //Retrieve by column name
			     	  ud1= rs1.getString("username");
			     	  ud2=rs1.getString("securitylevel");
			     	  ud3=rs1.getString("type1");
			     	  
			     	  
			     	  if(ud1.trim().equals(nme) && ud2.trim().equals(sl) && ud3.trim().equals(tpe))
			     	  {
			     		  set1=100;
			     		  System.out.println("i set 100 in sec level");
			     	  }
			     	  
			     	 System.out.println("userid: " + ud1);
			     	System.out.println("userid: " + ud2);
			     	System.out.println("userid: " + ud3);
			   
			         }
		    	 
		    	 //rs1.close();
			     
			     JOptionPane.showMessageDialog(this,"exit the second resultset! ");
			     
			     if(set1!=100)
			     {
			    	 
			    	 JOptionPane.showMessageDialog(this,"enter in to the second table! ");
			    	 
			    	 String sql3 = "INSERT INTO seclevel(username,securitylevel,type1)VALUES (?,?,?)";
			    	 
			    	 PreparedStatement statement1 = Con.prepareStatement(sql3);
			    	 
			    	 
			    	 statement1.setString(1,nme);
			    	 statement1.setString(2,sl);
			    	 statement1.setString(3,tpe);
			    	 
			    	  
			    	 int rowsInserted1 = statement1.executeUpdate();
			    	 if (rowsInserted1 > 0) {
			    	     System.out.println("A new user was inserted successfully in security level!");
			    	     JOptionPane.showMessageDialog(this,"Thank u bitch! ");
			    	 }
			    	 JOptionPane.showMessageDialog(this,"exit the second insert! ");
			     
			     }
			     
			     
			     
			     
			     String[] catalina={"o","o","o"};
			     int i=0;
			     
			     JOptionPane.showMessageDialog(this,"enter the third resultset! ");
			     String sql4 = "SELECT username,cat,type1 FROM seccat";
			     rs2 = stmt.executeQuery(sql4);
			     int set2=99;
			     String ud4=null,ud5=null,ud6=null;
			     
			     while(rs2.next()){
			         //Retrieve by column name
			     	  ud4= rs2.getString("username");
			     	  ud5=rs2.getString("cat");
			     	  ud6=rs2.getString("type1");
			     	  
			    if(ud4.trim().equals(nme)&& (ud5.trim().equals(c1)|| ud5.trim().equals(c2) || ud5.trim().equals(c3) )&& ud6.trim().equals(tpe))
			     	  {
			     		  set2=100;
			     		  System.out.println("i set 100 in category level");
			     		  catalina[i]=ud5;
			     		  i++;
			     		  
			     	  }
			     	  
			     	 System.out.println("userid: " + ud1);
			     	System.out.println("userid: " + ud2);
			     	System.out.println("userid: " + ud3);
			   
			         }
			     JOptionPane.showMessageDialog(this,"exit the third resultset! ");
			     
			     
			     
			     
			     
			     
			     if(set2!=100)
			     {
			    	 
			    	 JOptionPane.showMessageDialog(this,"enter in to the third table! ");
			    	 
			    	 
			    	 if((c1.equals("nato")) && !( (c1.equals(catalina[0])) ||  (c1.equals(catalina[1])) || (c1.equals(catalina[2])) ) )
			    	 {
			    		 
			    		 JOptionPane.showMessageDialog(this,"enter in to the first category! ");
			    	 
			    	 String sql5 = "INSERT INTO seccat(username,cat,type1)VALUES (?,?,?)";
			    	 
			    	 
			    	 PreparedStatement statement2 = Con.prepareStatement(sql5);
			    	 
			    	 
			    	 statement2.setString(1,nme);
			    	 statement2.setString(2,c1);
			    	 statement2.setString(3,tpe);
			    	 
			    	  
			    	 int rowsInserted2 = statement2.executeUpdate();
			    	 if (rowsInserted2 > 0) {
			    	     System.out.println("A new user was inserted successfully in  first category!");
			    	     JOptionPane.showMessageDialog(this,"inserted in to first category! ");
			    	 }
			    	 JOptionPane.showMessageDialog(this,"exit the first category insert! ");
			    	 
			    	 
			    	 } 
			    	 
			    	 
			    	 
			    	 if((c2.equals("navy")) && !( (c2.equals(catalina[0])) ||  (c2.equals(catalina[1])) || (c2.equals(catalina[2])) ) )
			    	 {
			    		 
			    		 JOptionPane.showMessageDialog(this,"enter in to the second category! ");
			    	 
			    	 String sql6 = "INSERT INTO seccat(username,cat,type1)VALUES (?,?,?)";
			    	 
			    	 
			    	 PreparedStatement statement3 = Con.prepareStatement(sql6);
			    	 
			    	 
			    	 statement3.setString(1,nme);
			    	 statement3.setString(2,c2);
			    	 statement3.setString(3,tpe);
			    	 
			    	  
			    	 int rowsInserted3 = statement3.executeUpdate();
			    	 if (rowsInserted3 > 0) {
			    	     System.out.println("A new user was inserted successfully in  first category!");
			    	     JOptionPane.showMessageDialog(this,"inserted in to second category! ");
			    	 }
			    	 JOptionPane.showMessageDialog(this,"exit the second category insert! ");
			    	 
			    	 
			    	 } 
			    	 
			    	 
			    	 JOptionPane.showMessageDialog(this,"enter in to the third category! ");
			    	 
			    	 if((c3.equals("nuclear")) && !( (c3.equals(catalina[0])) ||  (c3.equals(catalina[1])) || (c3.equals(catalina[2])) ) )
			    	 {
			    		 
			    		 JOptionPane.showMessageDialog(this,"enter in to the third category! ");
			    	 
			    	 String sql7 = "INSERT INTO seccat(username,cat,type1)VALUES (?,?,?)";
			    	 
			    	 
			    	 PreparedStatement statement4 = Con.prepareStatement(sql7);
			    	 
			    	 
			    	 statement4.setString(1,nme);
			    	 statement4.setString(2,c3);
			    	 statement4.setString(3,tpe);
			    	 
			    	  
			    	 int rowsInserted4 = statement4.executeUpdate();
			    	 if (rowsInserted4 > 0) {
			    	     System.out.println("A new user was inserted successfully in  third category!");
			    	     JOptionPane.showMessageDialog(this,"inserted in to third category! ");
			    	 }
			    	 JOptionPane.showMessageDialog(this,"exit the third category insert! ");
			    	 
			    	 
			    	 } 
			    	 
			    	 
			    	 
			    	 
			     
			     }
			     
			     
			     
		    	 
		    	 
		    	 
		    	 
		    	 }
		   System.out.println("empty string given"+t1.getText());
			
		     
			if(nme.equals(""))
			{
				JOptionPane.showMessageDialog(this,"give some name bitch! ");
				System.out.println("empty string given");
				
			}
			
			
			
			 
			
			 
		rs.close();
		rs1.close();
		rs2.close();
		
			 
			 
			 
			 
			 
			 
		Con.close();
		
		}catch(Exception e){
			
			
		}
		
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
	//end class

	//done by bala








	
	
	
	
	
	


