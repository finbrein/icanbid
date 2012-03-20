package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserTableServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// SimpleDateFormat fmt = new SimpleDateFormat( "ss_MM_dd_mm_yy");
		String table1 = "User";
		//String table2 = "Product";

		//String createCustomer, createProduct;
		
		String createUser;

		createUser = "Create table " + table1 + " (USERNAME VARCHAR(20), PASSWORD VARCHAR(20))";


		/*
		 * Here we initialize tools for making the database connection and
		 * reading from the database
		 */

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Create Tables Servlet</title></head><body>");

		Connection conn = null;
		Statement stmt = null;

		try {
			// Here we load the database driver
			// For mySQL database the above code would look like this:
			Class.forName("com.mysql.jdbc.Driver");

			// For mySQL database the above code would look like
			// something this.
			// Notice that here we are accessing mg_db database
			String url = "jdbc:mysql://mysql.cc.puv.fi:3306/e0700180_AuctionDB";

			// For e0700180_AuctionDB mySQL database the above code would look like
			// the following:
			conn = DriverManager.getConnection(url, "e0700180", "KfwYyr2XF5qC");

			// Here we create the statement object for executing SQL commands
			stmt = conn.createStatement();

			stmt.executeUpdate(createUser);
			
			out.println("<p>Today: " + new Date() + " " + table1 + " was created successfully! ");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {

			out.println("<p>" + e.getMessage());

		} finally {

			if (conn != null)
				try {
					conn.close();

					if (stmt != null)
						stmt.close();

				} catch (SQLException e) {
					out.println("<p>" + e.getMessage());
				}

		}

	}

}
