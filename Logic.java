class Logic

{
public static void main(String args[])

{
    
String subseclevel="NULL",objseclevel="NULL",aces="NULL";

    String[] subcat= new String[10];
 
   String[] objcat= new String[10];

    int subsecvalue=0,objsecvalue=0,i=0,j=0,count=0;
 
   if(subseclevel.equals("topsecret"))
    {
    
    subsecvalue = 4;
   
 }
    
else if(subseclevel.equals("secret"))
   
 {
        subsecvalue = 3;
   
 }
    else if(subseclevel.equals("confidential"))

    {
        subsecvalue = 2;
 
   }
    else if(subseclevel.equals("unclassified"))
    {
        subsecvalue = 1;
    }
    if(objseclevel.equals("topsecret"))
    {
        objsecvalue = 4;
    }
    else if(objseclevel.equals("secret"))
    {
        objsecvalue = 3;
    }
    else if(objseclevel.equals("confidential"))
    {
        objsecvalue = 2;
    }
    else if(objseclevel.equals("unclassified"))
    {
        objsecvalue = 1;
    }
    if(aces.equals("read"))
    {
            if(subsecvalue>=objsecvalue)
            {
                for(i=0;i<objcat.length;i++)
                {
                    for(j=0;j<subcat.length;j++)
                    {
                        if(objcat[i].equals(subcat[j]))
                        {
                            count++; 
                            break;            
                        }
                    }
                }
                if(count==objcat.length)
                {
                    //read given               
                }
            }
            else
            {
                //error
            }
    }
    else if(aces.equals("write"))
    {
        if(subsecvalue<=objsecvalue)
        {
            for(i=0;i<subcat.length;i++)
            {
                for(j=0;j<objcat.length;j++)
                {
                    if(subcat[i].equals(objcat[j]))
                    {
                        count++; 
                        break;            
                    }
                 }
            }
            if(count==subcat.length)
            {
                //write given                
            }
            else
            {
                //error        
            }
        }       
    }
}
} 
