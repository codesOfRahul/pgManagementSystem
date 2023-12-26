import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public  class Register extends Operations{
   
    Scanner string=new Scanner(System.in);
    Scanner integer=new Scanner(System.in);
    
    
        private String name;
        private int age;
        private String email;
        private String password;
    
    
    
    
   public void conditions() {
		
	    System.out.println("1. start-of-string");
	    System.out.println("2. A digit must occur at least once.");
	    System.out.println("3. An upper case letter must occur at least once");
	    System.out.println("4. A special character must occur at least once");
	    System.out.println("5. No whitespace allowed in the entire string.");
	    System.out.println("6. Anything, at least eight places though");
			}
	
	public void register() {
		
		
	    System.out.print("Enter the User name: ");
	      name = string.nextLine();
	      while (!name.matches("[a-zA-Z]+")) {
	      System.out.println("Invalid name. name should contain only Letters.");
	      System.out.print("Enter the employee name : ");
	      name = string.nextLine();
	    }
	   
	    System.out.println("User name: " +name);
		
			
		    System.out.print("Enter the User age: ");
		    int age = 0;
		    while (true) {
		      try {
		        age = Integer.parseInt(string.nextLine());
		        if ((age >= 18) && (age<=100)) {
		          break;
		        } else {
		          System.out.println("Age must be at least 18 and less than 100.");
		        }
		      } catch (NumberFormatException e) {
		        System.out.println("Invalid age. Age must be a number.");
		      }
		      System.out.print("Enter the employee age: ");
		    }
		    System.out.println("user age: " +age);
		
		
					
		    System.out.print("Enter the User email: ");
		     email = string.nextLine();
		    while (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
		      System.out.println("Invalid email. email should contain  necessary digits.");
		      System.out.print("Enter the User email: ");
		      email = string.nextLine();
		    }
		   
		    System.out.println("User email: "+email);
		
		
		
			
			conditions();
		    System.out.print("Enter the Password : ");
		     password = string.nextLine();	
		   
		    while (!password.matches("[a-zA-Z0-9@]+")) {
		    	 System.out.print("Please Satisfy necessary Condition above mentioned\n ");
		            conditions();
		            System.out.print("------------------------------------------------------\n");
		            System.out.print("Enter the Password : ");
	  		        password = string.nextLine();
			    }
		  
		   
		    String str = Integer.toString(age);
		   
		   
		   
		    try{
		    	Class.forName("com.mysql.jdbc.Driver");
		    	 
		    	Connection con=DriverManager.getConnection(
		    			"jdbc:mysql://localhost:3306/pg","root","root");
		    	 
		    	PreparedStatement stmt=con.prepareStatement("insert into register values(?,?,?,?)");
		    	
		    	stmt.setString(1,name);
		    	stmt.setInt(2,age);
		    	stmt.setString(3,email);//1 specifies the first parameter in the query
		    	stmt.setString(4,password);
		    	 
		    	int i=stmt.executeUpdate();
		    	System.out.print("YOU ARE REGISTERED ");
		    	loginuser();
		    	 
		    	con.close();
		    	
		    	 
		    	}catch(Exception e){ System.out.println(e);}
		    Userchoice();
		    	}
	
	
	public void Login() {
		
		
		System.out.println("Enter the username");
		
		String name=string.nextLine();
		
		
		System.out.println("Enter the password");
		
		String pass=string.nextLine();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
    			"jdbc:mysql://localhost:3306/pg","root","root");
		PreparedStatement pt = con.prepareStatement("select name,password from register where name=? and password=?");
		pt.setString(1,name);
    	pt.setString(2,pass);
		ResultSet rs = pt.executeQuery();
		
        if (rs.next()) {
           System.out.println("Login successful");
           uchoice();
        } else {
           System.out.println("Invalid username or password");
           System.out.println("-----------------------------------------------------");
           loginuser();
        }
        rs.close();
        pt.close();
        con.close();
    }
    catch (Exception e) {
    	
    	e.printStackTrace();
    }
		
		
	}
	
	
	public void Userchoice() {
		System.out.println("---------------------------------------------------\n");
		System.out.println("1. ADMIN");
		System.out.println("2. USER");
		System.out.println("3. Exit");
		System.out.println("---------------------------------------------------\n");
		System.out.println("Enter the choice");
		
		
		int choice = integer.nextInt();
		
		switch (choice) {
		  case 1:
		    loginadmin();
		    break;
		  case 2:
		    loginuser();
		    break;
		  case 3:
			    System.out.println("Thank you");
			    break;
		  default:
			  System.out.println("Invalid user choice");
		
		}
	
	
	}
	
	
	public void loginadmin() {
		String user="admin";
		String pass="admin";
		
		
		System.out.println("Enter the username");
		String loginadmin = string.nextLine();
		
		System.out.println("Enter the password");
		String loginpass = string.nextLine();
		
		if((user.equals(loginadmin)) && (pass.equals(loginpass))) {
                    System.out.print("------------------------------------------------\n");
			System.out.print("Welcome admin\n");
			choiceoption();
		}else {
			System.out.print("-------------------------------------------------\n");
			System.out.print("Please enter valid credentials\n");
			loginadmin();
		}
			
	}
	
	public void loginuser(){
		System.out.println("---------------------------------------------------------\n");
		System.out.println("1. Login");
		System.out.println("2. REGISTER");
		System.out.println("3. Exit");
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Enter the choice");
		
		
		
		int choice = integer.nextInt();
		switch (choice) {
		  case 1:
		   Login();
		    System.out.println("The login module is in testing......");
		    break;
		  case 2:
		    register();
		    break;
		  case 3:
			  System.out.println("Thank you");
			  break;
		  default:
			  System.out.println("the input null please enter valid input\n");
		    
		}
	} 
    
    
    
}
