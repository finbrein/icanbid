package bl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet{ 

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	                                   throws ServletException,IOException{
		
		  String url = "jdbc:mysql://mysql.cc.puv.fi:3306/";
	      String dbName = "e0700180_AuctionDB";
	      String driver = "com.mysql.jdbc.Driver";
	      String userName = "e0700180"; 
	      String mpassword = "KfwYyr2XF5qC";
	      
	      String emailAddress = "";
	      String repeatEmailAddress = "";
	      String userId = "";
	      String password = "";
	      String repeatPassword = "";
	      String firstName = "";
	      String lastName = "";
	      String phoneNumber = "";
	      
	      String strQuery= ""; 
	      String table = "user";
	      String searchQuery = "";
	      
	      Connection conn = null;
	      Statement stmt = null;
	      Statement st = null;
	      //ResultSet rs = null;
	      PreparedStatement ps=null;
	      ResultSet rs=null;
	      //HttpSession session = request.getSession(true);
	      	
		
		try {			
	    	  
	    	  // Here we create a connection to the database
	          Class.forName(driver).newInstance();	          
	          
	          // Here we set the JDBC URL for the MYSQL database
	          conn = DriverManager.getConnection(url+dbName,userName,mpassword);
	          
	          searchQuery = "select userId from " + table + " where userId LIKE " + "'" + request.getParameter("userId").toString() + "'";
	          
	          st = conn.createStatement();
	          
	  		  rs = st.executeQuery(searchQuery);
	  		
	  		String userID = "";
	  		 
	  		 while(rs.next())
	  		{
	  			userID = rs.getString("userId");	
	  			
	  		}
	  		 
		  		if(userID.equals(request.getParameter("userId").toString()))
		  		{
		  			//response.sendRedirect("RegistrationRetry.jsp");
		  			RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationRetry.jsp");
		  			if (dispatcher != null) {
		  				
						// Send the user the Retry's opening page
						dispatcher.forward(request, response);
			
					}
		  			
		  		}
	  		 

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		   
	      response.setContentType("text/html");
	      
	      PrintWriter out = response.getWriter();
	      
	      out.println("<html><head><title>Insert Tables Servlet</title></head><body>");
	      
	      out.println("MySQL Connect...");
	      
	     	      
	      try {

	          if(request.getParameter("emailAddress")!=null &&
	        	  request.getParameter("emailAddress")!=""  && 
	        	  request.getParameter("repeatEmailAddress")!=null &&
	              request.getParameter("repeatEmailAddress")!="" &&
	              request.getParameter("userId")!=null &&
		          request.getParameter("userId")!=""  &&
		          request.getParameter("password")!=null &&
		          request.getParameter("password")!=""  &&
	              request.getParameter("repeatPassword")!=null &&
		          request.getParameter("repeatPassword")!=""  &&
		          request.getParameter("firstName")!=null &&
		          request.getParameter("firstName")!=""  &&
	              request.getParameter("lastName")!=null &&
		          request.getParameter("lastName")!=""  &&
		          request.getParameter("phoneNumber")!=null &&
		          request.getParameter("phoneNumber")!="" )
	          {
	        	  emailAddress = request.getParameter("emailAddress").toString();
	        	  repeatEmailAddress = request.getParameter("repeatEmailAddress").toString();
	        	  userId = request.getParameter("userId").toString();
	        	  password = request.getParameter("password").toString();
	        	  repeatPassword = request.getParameter("repeatPassword").toString();
	        	  firstName = request.getParameter("firstName").toString();
	        	  lastName = request.getParameter("lastName").toString();
	        	  phoneNumber = request.getParameter("phoneNumber").toString();
	        	  
	        	  strQuery = "insert into " + table + "(emailAddress, repeatEmailAddress, userId, password, repeatPassword, firstName, lastName, phoneNumber) " + "values(?,?,?,?,?,?,?,?)";
	              
	        	  out.println(strQuery);
	              
	        	  // Here we create the statement object for executing SQL commands
	        	  stmt = conn.createStatement();
	              
	             // inserting records
	              
	             //Here we initialize the preparedStatement object
	  			 ps = conn.prepareStatement(strQuery);
	  			 
				 ps.setString(1, emailAddress);
				 ps.setString(2, repeatEmailAddress);
				 ps.setString(3, userId);
				 ps.setString(4, password);
				 ps.setString(5, repeatPassword);
				 ps.setString(6, firstName);
				 ps.setString(7, lastName);
				 ps.setString(8, phoneNumber);				 
				 ps.executeUpdate();	
				 
				 out.println("<p>Data was added to " + table + " successfully!");

	             //response.sendRedirect("RegistrationSuccess.jsp");
	             RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationSuccess.jsp");
		  			if (dispatcher != null) {
		  				
						// Send the user the Retry's opening page
						dispatcher.forward(request, response);
			
					}
	            
	          } else {
	             //response.sendRedirect("RegistrationRetry.jsp");
	             RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationRetry.jsp");
	  			if (dispatcher != null) {
	  				
					// Send the user the Retry's opening page
					dispatcher.forward(request, response);
		
				}
	          }      
	          
	             conn.close();
	          
                 out.println("</body>");
	 			 out.println("</html>");
	          
	        } catch (Exception e) {
	        e.printStackTrace();
	        } finally {

				try {

					if (stmt != null)
						stmt.close();

					if (conn != null)
						conn.close();

				} catch (SQLException e) {
					out.print("<p>" + e.getMessage());
			  }
	        }
	   }
}
