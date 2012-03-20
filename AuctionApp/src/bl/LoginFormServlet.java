package bl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("MySQL Connect...");
		
		Connection conn = null;
		
		String url = "jdbc:mysql://mysql.cc.puv.fi:3306/";
		String dbName = "e0700180_AuctionDB";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "e0700180";
		String password = "KfwYyr2XF5qC";

		String table = "user";

		String username = "";
		String userpass = "";
		String strQuery = "";
		Statement st = null;
		ResultSet rs = null;
		HttpSession session = request.getSession(true);

		try {

			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);

			if (request.getParameter("username") != null
					&& request.getParameter("username") != ""
					&& request.getParameter("password") != null
					&& request.getParameter("password") != "") {
				
				username = request.getParameter("username").toString();
				userpass = request.getParameter("password").toString();

				strQuery = "select * from " + table + " where userId='"
											+ username + "' and  password='" + userpass + "'";

				out.println(strQuery);

				st = conn.createStatement();
				rs = st.executeQuery(strQuery);

				int count = 0;

				while (rs.next()) {

					session.setAttribute("username", rs.getString(2));
					count++;
				}

				if (count > 0) {
					response.sendRedirect("customer");
				} else {
					response.sendRedirect("LoginRetry.jsp");
				}

			} else {
				response.sendRedirect("LoginRetry.jsp");
			}

			out.println("Connected to the database");

			conn.close();

			out.println("Disconnected from database");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
