import java.sql.*;
import java.util.regex.*;
import java.util.Scanner;



/*
Title           : PG Management System
Author          : RAHUL C
Created on      : 
Last Modified   : 26-12-2023
Reviewed By     :
Reviewed On     :
*/



public class PgManagement {
	
	public static void main(String[] args) {
		
		
		Register register= new Register();
		
		register.Userchoice();
		
	}
}
class Operations {
    
    Scanner string=new Scanner(System.in);
    Scanner integer=new Scanner(System.in);
    
    
	public void  crudoper(){
        System.out.println("---------------------------------------------------\n");
		System.out.println("1. Add");
		System.out.println("2. Find");
        System.out.println("3. Delete");
        System.out.println("4. Go Back");
		System.out.println("---------------------------------------------------\n");
		System.out.println("Enter the choice");
		
		
		
		int choice = integer.nextInt();
		switch (choice) {
		  case 1:
			roomdetails();
		    System.out.println("The Details updated......");
		    break;
		  case 2:
		    findroom();
		    break;
          case 3:
		    deleteroom();
		    break;
          case 4:
        	  choiceoption();
        	  break;
		  default:
			  System.out.println("the input null please enter valid input\n");
		    
		}
            
            
        }
	public void  crudoper2(){
        System.out.println("---------------------------------------------------\n");
	System.out.println("1. Add");
	System.out.println("2. Find");
    System.out.println("3. Delete");
    System.out.println("4. Go Back");
	System.out.println("---------------------------------------------------\n");
	System.out.println("Enter the choice");
	
	int choice = integer.nextInt();
	switch (choice) {
	  case 1:
		facilitiesdetails();
	    System.out.println("The Details updated......");
	    break;
	  case 2:
	    findfacility();
	    break;
              case 3:
	    facilitydelete();
	    break;
     case 4:
         choiceoption();
         break;
	  default:
		  System.out.println("the input null please enter valid input\n");
	    
	}
        
        
    }
	
	public void  uchoice(){
        System.out.println("---------------------------------------------------\n");
	System.out.println("1. Add Queries");
	System.out.println("2. Facilities");
	System.out.println("3. Exit");
	System.out.println("---------------------------------------------------\n");
	System.out.println("Enter the choice");
	
	
	
	int choice = integer.nextInt();
	switch (choice) {
	  case 1:
		add_query();
	    System.out.println("The Details updated......");
	    break;
	  case 2:
		  findfacility();
	    break;
	  case 3:
	    break;
	  default:
		  System.out.println("the input null please enter valid input\n");
	    
	}
        
        
    }
	
	
	
	
	
	
	
	
	public void  crudoper3(){
        System.out.println("---------------------------------------------------\n");
	System.out.println("1. Add Query");
    System.out.println("2. View Query");
    System.out.println("3. Update Status");
    System.out.println("4. Go Back");
	System.out.println("---------------------------------------------------\n");
	System.out.println("Enter the choice");
		
	int choice = integer.nextInt();
	switch (choice) {
	  case 1:
		add_query();
	    System.out.println("The Details updated......");
	    break;
	  case 2:
	    findquery();
	    break;
	  case 3:
	         queryupdate();
	         break;
          case 4:
              choiceoption();
	      break;
	  default:
		  System.out.println("the input null please enter valid input\n");
	    
	}
        
        
    }
    
        
        public void  choiceoption(){
        System.out.println("---------------------------------------------------\n");
		System.out.println("1. Room");
		System.out.println("2. Facilities");
        System.out.println("3. Queries");
        System.out.println("4. Exit");
		System.out.println("---------------------------------------------------\n");
		System.out.println("Enter the choice");
				
		int choice = integer.nextInt();
		switch (choice) {
		  case 1:
			crudoper();
			break;
		  case 2:
		    crudoper2();
		    break;
		  case 3:
			    crudoper3();
			    break;
		  case 4:
			  break;
		  default:
			  System.out.println("the input null please enter valid input\n");
		    
		}

        }
        
        
        
	
	public void roomdetails() {
		
     		System.out.println("Enter the Room_no");
		int roomno=integer.nextInt();
                
                
		System.out.println("Enter the Room_type");
                
		String roomtype=string.nextLine();
                
                
		System.out.println("Enter the Room_price");
		int roomprice=integer.nextInt();
                
		System.out.println("Enter the Room_loc");
		String roomloc=string.nextLine();
                
		System.out.println("Enter the Availabilty");
		int avail=integer.nextInt();
		try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 
	    	Connection con=DriverManager.getConnection(
	    			"jdbc:mysql://localhost:3306/pg","root","root");
	    	 
	    	PreparedStatement stmt=con.prepareStatement("insert into roomdetails values(?,?,?,?,?)");
	    	
	    	stmt.setInt(1,roomno);
	    	stmt.setString(2,roomtype);
	    	stmt.setInt(3,roomprice);//1 specifies the first parameter in the query
	    	stmt.setString(4,roomloc);
	    	stmt.setInt(5,avail);
	    	int i=stmt.executeUpdate();
	    	System.out.print("You added Roomdetails ");
	    	System.out.println(i+" Room data inserted");
	    	crudoper();
	    	con.close();
	    	
	    	 
	    	}catch(Exception e){ System.out.println(e);}
	   
	    	
		
		
		
	}
	
	public void findroom(){
         
		
            System.out.println("Enter the Room number");
            
           
		int roomnumber=integer.nextInt();
            
            try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
    			"jdbc:mysql://localhost:3306/pg","root","root");
		PreparedStatement pt = con.prepareStatement("select availability  from roomdetails where roomno=?");
		pt.setInt(1,roomnumber);
    	        
		ResultSet rs = pt.executeQuery();
		
        if (rs.next()) {
           int id = rs.getInt(1);
           if(id==1){
               System.out.println("The room is not available");
           }else{
               System.out.println("The room is available");
           }         
           crudoper();
        } else {
           System.out.println("Invalid pass key");
        }
        rs.close();
        pt.close();
        con.close();
    }
    catch (Exception e) {
    	
    	e.printStackTrace();
    }
        }
	
	public void deleteroom(){
               System.out.println("Enter the Room number");
            
           
		int roomnumber=integer.nextInt();
            
            try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
    			"jdbc:mysql://localhost:3306/pg","root","root");
		PreparedStatement pt = con.prepareStatement("delete from roomdetails   where roomno=?");
		pt.setInt(1,roomnumber);
		int i=pt.executeUpdate();       
		crudoper();
        pt.close();
        con.close();
    }
    catch (Exception e) {
    	
    	e.printStackTrace();
    } 
        }
	
	
	
	
public void facilitiesdetails() {
		
		System.out.println("Enter the facility_id");
		int facility_id=integer.nextInt();
                
                
		System.out.println("Enter the facility_name");
                
		String facility_name=string.nextLine();
                
                
		System.out.println("Enter the facility_type");
		String facility_type=string.nextLine();
		System.out.println("Enter the additional charges");
		int additional_charges=integer.nextInt();
		
		try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 
	    	Connection con=DriverManager.getConnection(
	    			"jdbc:mysql://localhost:3306/pg","root","root");
	    	 
	    	PreparedStatement stmt=con.prepareStatement("insert into facilities values(?,?,?,?)");
	    	
	    	stmt.setInt(1,facility_id);
	    	stmt.setString(2,facility_name);
	    	stmt.setString(3,facility_type);//1 specifies the first parameter in the query
	    	stmt.setInt(4,additional_charges);
	    	
	    	int i=stmt.executeUpdate();
	    	System.out.print("You added facility details ");
	    	System.out.println(i+" facility data inserted");
	    	 crudoper2();
	    	con.close();
	    	
	    	 
	    	}catch(Exception e){ System.out.println(e);}
	   	}


public void facilitydelete(){
    

   System.out.println("Enter the facility number");
   
  
int facility_id=integer.nextInt();
   
   try {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/pg","root","root");
PreparedStatement pt = con.prepareStatement("delete from facilities   where facility_id=?");   
pt.setInt(1,facility_id);

int i=pt.executeUpdate();
      System.out.println("The facility  is deleted");
   crudoper2();        
pt.close();
con.close();
}
catch (Exception e) {

	System.out.println("Invalid facility  id");
} 
}


public void queryupdate(){

               System.out.println("Enter the staus");
                
		String status=string.nextLine();
                
                
                
		System.out.println("Enter the roomid");
		int roomid=integer.nextInt();
                
                
		
                
      
		try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 
	    	Connection con=DriverManager.getConnection(
	    			"jdbc:mysql://localhost:3306/pg","root","root");
	    	 
	    	PreparedStatement stmt=con.prepareStatement("update queries set status=? where roomno=?");
	    	stmt.setString(1,status);
	    	stmt.setInt(2,roomid);
	    	
                int i=stmt.executeUpdate();
	    	System.out.print("You updated details ");
	    	System.out.println(i+" Updated");
	    	crudoper3();
	    	con.close();
	    	
	    	 
	    	}catch(Exception e){ System.out.println(e);}
	   
	    	
    
    
    
    
}











public void findfacility(){
    
    try {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/pg","root","root");
PreparedStatement pt = con.prepareStatement("select  * from facilities");

       
ResultSet rs = pt.executeQuery();

if (rs.next()) {
	   System.out.println("The facility are\n");
	do {
 
	System.out.println(rs.getString(1));
	System.out.println(rs.getString(2));
	System.out.println(rs.getString(3));
	System.out.println(rs.getString(4));
	}while(rs.next());
		
	crudoper2();
	
} else {
  System.out.println("Invalid facility table name");
}

rs.close();
pt.close();
con.close();
}
catch (Exception e) {

e.printStackTrace();
}
}

public void add_query() {
	
System.out.println("Enter the user name");
    
String username=string.nextLine();
System.out.println("Enter the room_no");
int roomno=integer.nextInt();

System.out.println("Enter the description");
String description=string.nextLine();

System.out.println("Enter the status");
String status=string.nextLine();


try{
Class.forName("com.mysql.jdbc.Driver");
 
Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/pg","root","root");
 
PreparedStatement stmt=con.prepareStatement("insert into queries values(?,?,?,?)");

stmt.setString(1,username);
stmt.setInt(2,roomno);
stmt.setString(3,description);//1 specifies the first parameter in the query
stmt.setString(4,status);

int i=stmt.executeUpdate();
System.out.print("You added query details ");
System.out.println(i+" query data inserted");
 uchoice();
con.close();

 
}catch(Exception e){ System.out.println(e);}
	
}	

public void admin_add_query() {
	
System.out.println("Enter the user name");
    
String username=string.nextLine();
System.out.println("Enter the room_no");
int roomno=integer.nextInt();

System.out.println("Enter the description");
String description=string.nextLine();

System.out.println("Enter the status");
String status=string.nextLine();


try{
Class.forName("com.mysql.jdbc.Driver");
 
Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/pg","root","root");
 
PreparedStatement stmt=con.prepareStatement("insert into queries values(?,?,?,?)");

stmt.setString(1,username);
stmt.setInt(2,roomno);
stmt.setString(3,description);//1 specifies the first parameter in the query
stmt.setString(4,status);

int i=stmt.executeUpdate();
System.out.print("You added query details ");
System.out.println(i+" query data inserted");
 crudoper3();
con.close();

 
}catch(Exception e){ System.out.println(e);}
	
}	
public void findquery(){
    
    try {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/pg","root","root");
PreparedStatement pt = con.prepareStatement("select  * from queries");

       
ResultSet rs = pt.executeQuery();

if (rs.next()) {
	 System.out.println("The queries are\n");
	do{
   
   	System.out.println("Username:"+rs.getString(1)+"  ||"+"Room_number"+rs.getString(2)+"   ||"+"Description"+rs.getString(3)+"  ||"+"Status"+rs.getString(4)+"\n");
	}while(rs.next());
        crudoper3();
} else {
  System.out.println("Invalid queries table name");
}

rs.close();
pt.close();
con.close();
}
catch (Exception e) {
e.printStackTrace();
}
}


}
