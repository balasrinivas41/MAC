package DataObjects;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;


class Page4
{


public static void mains(String[] args)
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
//t2.setEchoChar('*');
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
String ac=choice.getSelectedItem();

System.out.println("subject is"+subj);

System.out.println("object is"+obj);
System.out.println("access right is"+ac);




try{

Connection Con= DbConnection.GetDbConnection();
JOptionPane.showMessageDialog(this," established");

Statement stmt = null;	 stmt = Con.createStatement();
String s="subject";

String sql = "SELECT securitylevel FROM seclevel where username='" +subj+"' and type1='"+s+"' ";
ResultSet rs,rs1,rs2,rs3; 
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
	
	JOptionPane.showMessageDialog(this,"entered in to the subject category! ");
	
	
	
	
	String sql2 = "SELECT cat FROM seccat where username='" +subj+"' and type1='"+s+"' ";

	rs2= stmt.executeQuery(sql2);
	//int set=99;
	int i1=0,i2=0;
	

	String scat[]={"o","o","o","o","o"};
	while(rs2.next()){
	    //Retrieve by column name
		  scat[i1]= rs2.getString("cat");
		 
		  
		System.out.println("category of subject is: " + scat[i1]);
		
		 i1++;

	    }
	
	
	for(int i=0;i<i1;i++)
	{
		System.out.println("category of subject is: " + scat[i]);
		
	
	}
	
	
	if(!(scat[0].equals("o")))
	{
		
		
		JOptionPane.showMessageDialog(this," entered in to the object category");
		
		
		
		String sql3 = "SELECT cat FROM seccat where username='" +obj+"' and type1='"+s1+"' ";

		rs3= stmt.executeQuery(sql3);
		//int set=99;
		
		

		String ocat[]={"o","o","o","o","o"};
		while(rs3.next()){
		    //Retrieve by column name
			  ocat[i2]= rs3.getString("cat");
			 
			  
			System.out.println("category of object is: " + ocat[i1]);
			
			 i2++;

		    }
		
		
		for(int i=0;i<i1;i++)
		{
			System.out.println("category of object is: " + ocat[i]);
			
		
		}
		
		
		
		
		
		
		
		
		
		System.out.println("security level of subject is: " + sublev);
		 System.out.println("security level of object is: " + objlev);
		 for(int i=0;i<i1;i++)
			{
				System.out.println("category of subject is: " + scat[i]);
				
			
			}
		
		 for(int i=0;i<i2;i++)
			{
				System.out.println("category of object is: " + ocat[i]);
				
			
			}
		 
		 System.out.println("length of subj categ is "+i1+" length of obj categ is "+i2);
		 
		 System.out.println("access right is"+ac);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		  

		    int i=0,j=0,count=0,subsecvalue=0,objsecvalue=0;
		    
		    JOptionPane.showMessageDialog(this,"entered tej bhushan code ");

		    if(sublev.trim().equals("topsecret"))

		    {
		        subsecvalue = 4;
		        JOptionPane.showMessageDialog(this,"entered tej bhushan code sub topsecret ");
		    }

		    else if(sublev.trim().equals("secret"))

		    {
		        subsecvalue = 3;
		        JOptionPane.showMessageDialog(this,"entered tej bhushan code sub secret ");
		    }

		    else if(sublev.trim().equals("classified"))

		    {
		        subsecvalue = 2;
		        
		        JOptionPane.showMessageDialog(this,"entered tej bhushan code sub confidential ");
		    }

		    else if(sublev.trim().equals("unclassified"))

		    {
		        subsecvalue = 1;
		        JOptionPane.showMessageDialog(this,"entered tej bhushan code  sub unclassified ");
		    }

		    if(objlev.trim().equals("topsecret"))

		    {
		        objsecvalue = 4;
		        JOptionPane.showMessageDialog(this,"entered tej bhushan code obj topsecret ");
		    }

		    else if(objlev.trim().equals("secret"))

		    {
		        objsecvalue = 3;
		        
		        JOptionPane.showMessageDialog(this,"entered tej bhushan code obj secret ");
		    }

		    else if(objlev.trim().equals("classified"))

		    {
		        objsecvalue = 2;
		        JOptionPane.showMessageDialog(this,"entered tej bhushan code obj confidential ");
		    }

		    else if(objlev.trim().equals("unclassified"))

		    {
		        objsecvalue = 1;
		        JOptionPane.showMessageDialog(this,"entered tej bhushan code obj unclassified ");
		    }

		    if(ac.equals("read"))

		    {
		    	 JOptionPane.showMessageDialog(this,"entered read access tej","Error Message Box",JOptionPane.ERROR_MESSAGE);
		            if(subsecvalue>=objsecvalue)

		            {
		                for(i=0;i<i2;i++)

		                {
		                    for(j=0;j<i1;j++)

		                    {
		                        if(ocat[i].trim().equals(scat[j].trim()))

		                        {
		                            count++;
		 
		                            break;
		            
		             }

		                    }

		                }

		                if(count==i2)

		                {
		                    //read given
		                     JOptionPane.showMessageDialog(this,"read access permitted ");
		                     
		               
		 }
		                else

			            {
			                //error
			                 JOptionPane.showMessageDialog(this,"read access denied","Error Message Box",JOptionPane.ERROR_MESSAGE);
			            }

		            }
		            
		            else

		            {
		                //error
		                 JOptionPane.showMessageDialog(this,"read access denied","Error Message Box",JOptionPane.ERROR_MESSAGE);
		            }

		    }
		    
		    else if(ac.equals("write"))

		    {
		    	 JOptionPane.showMessageDialog(this,"access control","Error Message Box",JOptionPane.ERROR_MESSAGE);
		    	
		        if(subsecvalue<=objsecvalue)

		        {
		            for(i=0;i<i1;i++)

		            {
		                for(j=0;j<i2;j++)

		                {
		                    if(scat[i].trim().equals(ocat[j].trim()))

		                    {
		                        count++;
		 
		                        break;
		            
		        }

		                 }

		            }

		            if(count==i1)

		            {
		                //write given
		                 JOptionPane.showMessageDialog(this,"write access permitted! ");

		            }

		            else

		            {
		                //error
		                 JOptionPane.showMessageDialog(this,"write access denied","Error Message Box",JOptionPane.ERROR_MESSAGE);

		            }

		        }
		        else

	            {
	                //error
	                 JOptionPane.showMessageDialog(this,"write access denied","Error Message Box",JOptionPane.ERROR_MESSAGE);

	            }
		        
		        }
		        
		     
		        
		        
		    JOptionPane.showMessageDialog(this,"exit tej code ");
		        
		        
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	}
	
	
	if((scat[0].equals("o")))
		
	{
		
		JOptionPane.showMessageDialog(this," category of subject is ok but category of object is not present");
		
	}
	
	
	
	System.out.println("category of subject length is: " + i1);
	System.out.println("category of object length is: " + i2);
	
	
	
	
	
	
	
	
	
	
	
	
	
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










