import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Page4
{


public static void main(String[] args)
{
ColorsFrame frame=new ColorsFrame();
//System.out.println("Hello world");

}


}





class ColorsFrame extends Frame implements ActionListener
{
Button b1,b2,b3;
Label name;
Choice choice;
Label passwd;
Label access;
TextField t1,t2;
Panel controlpanel;


ColorsFrame()
{
this.setVisible(true);
this.setSize(700,700);
this.setTitle("Button Example");
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
String user=t2.getText();
if(user.equals("bala"))
{//JOptionPane.showMessageDialog(this," correct password");
}

else{
//JOptionPane.showMessageDialog(this,"wrong password","Error Message Box",JOptionPane.ERROR_MESSAGE);
}
//this.setBackground(Color.red);
}


}


}










