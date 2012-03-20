package bl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String downloadedImageRepository;

	String separator = "";

	public void init() {

		/*
		 * 
		 * Below we set the path for the directory where uploaded files are
		 * 
		 * saved getServletContext().getRealPath(separator) returns the path to
		 * the
		 * 
		 * root directory of the servlet. Variable separator indicates the
		 * 
		 * directory separator on the system.
		 */

		separator = System.getProperty("file.separator");

		downloadedImageRepository = getServletContext().getRealPath(separator) + "downloaded_images" + separator;

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, java.io.IOException {
		
		String table = "product";
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
	
		out.println("<!--This is the Customer Page HTML form -->");
		out.println("<head>");
		out.println("<title>iCANBID, Inc</title>");
		out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
		out.println("<META HTTP-EQUIV='Content-Type' CONTENT='text/html; charset=ISO-8859-1'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<!-- DIV Implementation -->");
		out.println("<!-- Container -->");
		out.println("<div id='container'>");
		out.println("<!-- Header -->");
		out.println("<div id='header'>");
		out.println("<h1><a href='http://app.cc.puv.fi/icanbid/index.jsp'>iCANBID</a></h1>");
		out.println("<table>");
		out.println("<tr>");				
		out.println("<td><a href='#'>Log Out</a><span class='link-delimiter'> | </span></td>");
		out.println("<td><a href='#'>Account</a><span class='link-delimiter'> | </span></td>");
		out.println("<td><p class='parablue'><strong><a href='#'>Bid</a><span class='link-delimiter'> | </span></strong></p></td>");
		out.println("<td><p class='parablue'><strong><a href='http://app.cc.puv.fi/icanbid/ProductUploadForm.jsp'>Update Product Information</a></strong></p>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("<div id='topnav'>top navigation</div>");
		out.println("<div id='tblank'></div>");
		out.println("<!-- START leftnav Content -->");
		out.println("<div id='navigation'>");
		out.println("Left Content");
		out.println("<!--p><strong>2) Navigation here.</strong> long long fill filler column silly filler very filler fill fill</p> -->");
		out.println("<h5 align='left'>Computers</h5>");
		out.println("<ul>");
		out.println("<li>Components</li>");
		out.println("<li>Desktop Computers</li>");
		out.println("<li>Laptop Computers</li>");
		out.println("<li>Monitors</li>");
		out.println("<li>Networking</li>");
		out.println("<li>Printers & Scanners</li>");
		out.println("<li>Software</li>");
		out.println("</ul>");
		out.println("<h5 align='left'>Electronics</h5>");
		out.println("<ul>");
		out.println("<li>Cell Phones</li>");
		out.println("<li>Digital Cameras</li>");
		out.println("<li>DVD Players & DVRs</li>");
		out.println("<li>GPS Systems</li>");
		out.println("<li>Home Audio</li>");
		out.println("<li>PDAs</li>");
		out.println("<li>iPod & MP3 Players</li>");
		out.println("<li>Portable DVD Players</li>");
		out.println("<li>Digital Picture Frames</li>");
		out.println("<li>Headphones</li>");
		out.println("<li>Home Security</li>");
		out.println("<li>Telephones</li>");
		out.println("<li>Video Accessories</li>");
		out.println("</ul>");
		out.println("<h5 align='left'>Watches</h5>");
		out.println("<ul>");
		out.println("<li>Mens Watches</li>");
		out.println("<li>Ladies Watches</li>");
		out.println("</ul>");			
		out.println("</div>");
		out.println("<!-- Main Content -->");
		out.println("<div id='content'>");
		out.println("<table><tr align='center'><td bgcolor='#3B5998'><font color='white'>TODAY'S<strong> MOST EXCITING </strong> AUCTIONS</font></td></tr></table>");
		
		Connection conn = null;

		Statement stmt = null;
		
		String name = null;

		float unitParice = 0;

		int amount = 0;
		
		String imageName = null;
		
		try {
			// Here we load the database driver
			Class.forName("com.mysql.jdbc.Driver");

			// Here we set the JDBC URL for the MYSQL database
			String url = "jdbc:mysql://mysql.cc.puv.fi:3306/e0700180_mjcsp";

			// Here we create a connection to the database
			conn = DriverManager.getConnection(url, "e0700180", "KfwYyr2XF5qC");

			// Here we create the statement object for executing SQL commands

			stmt = conn.createStatement();

			String imageQuery = "select name, unitPrice, amount, image from " + table + " ORDER BY RAND() LIMIT 0,4";

			ResultSet resultSet = stmt.executeQuery(imageQuery);

			File destinationFile = null;

			FileOutputStream fos = null;

			imageName = "readImage";
			
			out.println("<table>");
			out.println("<tr style='border: solid;'>");
			out.println("<th align='left' width='40%'>Product</th>");
			out.println("<th align='left' width='20%'>Price</th>");
			out.println("<th align='left' width='10%'>Amount</th>");
			out.println("<th align='center' width='30%'>Image</th>");
			out.println("</tr>");

			int i = 0;

			while (resultSet.next()) {

				name = resultSet.getString(1);

				unitParice = resultSet.getInt(2);

				amount = resultSet.getInt(3);

				// Here we update the name of the image

				imageName += i + ".jpg";

				destinationFile = new File(downloadedImageRepository + imageName);

				fos = new FileOutputStream(destinationFile);

				byte[] buffer = new byte[1];

				InputStream is = resultSet.getBinaryStream(4);

				while (is.read(buffer) > 0) {

					fos.write(buffer);

				}

				fos.close();
				

				out.println("<tr style='border: solid;'>");
				out.println("<td>" + name + "</td>");
				out.println("<td>" + unitParice + "</td>");
				out.println("<td>" + amount + "</td>");
				out.println("<td><img src='" + "downloaded_images" + separator + imageName + "' alt='Angry face' /></td>");
				out.println("</tr>");
				

				//out.println("<p>" + name + " " + unitParice + " " + amount);
				//out.println("<img src='" + "downloaded_images" + separator + imageName + "' alt='Angry face' />");
				//out.println("<hr>");
				//TD.prod{ border: solid black }

				i++;

			}
			
			out.println("</table>");

			//out.println("<p><center><a href='admin_index.jsp'>Back</a></center>");


		} catch (Exception e) {

			out.println(e.getMessage());

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
		
		out.println("</div>");
		out.println("<!-- Right Content -->");
		out.println("<div id='extras'>Right Content</div>");
		out.println("<!-- Footer -->");
		out.println("<div id='footer'><p>The footer. You can go to the <a href='#'>index page</a>.</p></div>");
		out.println("</div>");
		out.println("<!-- http://www.c-sharpcorner.com/UploadFile/satisharveti/DIVPageLayout01192009015313AM/DIVPageLayout.aspx -->");
		out.println("<!-- http://www.barelyfitz.com/screencast/html-training/css/positioning/ -->");
		out.println("<!-- http://blog.html.it/layoutgala/ -->");
		out.println("</body>");
		out.println("</html>");

	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, java.io.IOException {

		// Here we redirect HHTP GET requests to the doPost() method

		doPost(request, response);

	}

}
