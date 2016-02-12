import java.util.*;

import java.sql.*;


public class home {
	
	public static void main (String[] args)
	{
		
	//taking input and subdividing the code------------------------------------------------ 
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the relational algebra");
    String s = in.nextLine();
    String[] words = s.split(" ");
 String result=null;
    //splitting query into every possibility-------------------------------------------------
    if(words[0].equals("select")){
    	selects select=new selects();
    	 result=select.query(s);
    	
    }
    else if(words[0].equals("project")){
    	projects project=new projects();
    	 result=project.query(s);
    	
    }
    else if(words[0].equals("naturaljoin")){
    	naturaljoins naturaljoin=new naturaljoins();
    	 result=naturaljoin.query(s);
    }
    else if(words[0].equals("cartesianproduct")){
    	cartesianproducts cartesianproduct=new cartesianproducts();
     result=cartesianproduct.query(s);
    }
    
    
    result=result+" ;";
    System.out.println(result);
    
    /* create a successful connection to the database server. */
    Connection c = null;
    try
    {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rating",
                       "postgres", "wwe");
    }
    catch (Exception e)
    {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
    }
    System.out.println("Opened database successfully");
    
    try
    {
        Statement stmt = c.createStatement();
        /* execute a query on the server*/
        ResultSet rs = stmt.executeQuery(result);
        /* obtain information about the resulting relation*/
        ResultSetMetaData rsm = rs.getMetaData();
        /* first, print the names of the attributes*/
        int ncolumns = rsm.getColumnCount();
        for (int i = 1; i <= ncolumns; i++)
        {
            if (i > 1) System.out.print(",  ");
            System.out.print(rsm.getColumnName(i));
        }
        System.out.print("\n");
        /* print the result of the qeury */
        while (rs.next())
        {
            for (int i = 1; i <= ncolumns; i++)
            {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
            }
            System.out.println("");
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
    }
    
    
    
    
    
    
	}
	
}
