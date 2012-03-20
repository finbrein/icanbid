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

public class DisplayProductsServlet extends HttpServlet {

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

		/*
		 * 
		 * Here we initialize tools for making the database connection
		 * 
		 * and reading from the database
		 */

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head><title>List of Available Products</title></head><body>");

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

			String imageQuery = "select * from " + table;

			ResultSet resultSet = stmt.executeQuery(imageQuery);

			File destinationFile = null;

			FileOutputStream fos = null;

			imageName = "readImage";

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

				out.println("<p>" + name + " " + unitParice + " " + amount);
				out.println("<img src='" + "downloaded_images" + separator + imageName + "' alt='Angry face' />");
				out.println("<hr>");

				i++;

			}

			out.println("<p><center><a href='admin_index.jsp'>Back</a></center>");
			out.println("</body>");
			out.println("</html>");

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

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, java.io.IOException {

		// Here we redirect HHTP GET requests to the doPost() method

		doPost(request, response);

	}

}