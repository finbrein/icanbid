package bl;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

public class UploadProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String uploadedImageRepository;

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

		uploadedImageRepository = getServletContext().getRealPath(separator) + "uploaded_images" + separator;

	}
	
	BufferedImage createResizedCopy(Image originalImage,int scaledWidth, int scaledHeight,boolean preserveAlpha)
	{
	    System.out.println("resizing...");
	    int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
	    BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
	    Graphics2D g = scaledBI.createGraphics();
	    if (preserveAlpha) {
	            g.setComposite(AlphaComposite.Src);
	    }
	    g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
	    g.dispose();
	    return scaledBI;
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

		out.println("<html><head><title>Upload Product Info Servlet</title></head><body>");

		Connection conn = null;

		Statement stmt = null;

		PreparedStatement ps = null;

		String name = null;

		float unitParice = 0;

		int amount = 0;

		String imageName = null;

		// Here we set the file limit size to 2 MB 

		MultipartParser parser = new MultipartParser(request, 2 * 1024 * 1024);

		Part part = null;

		while ((part = parser.readNextPart()) != null) {

			if (part.isParam()) {

				// Here we define parameter, which is a ParamPart

				// by type casting part object.

				ParamPart parameter = (ParamPart) part;

				// In the following we read the values for name, unitPrice and
				// amount parameters.

				// To do this we first make sure that we are reading the right
				// parameter.

				if (parameter.getName().equals("name"))

					name = parameter.getStringValue();

				else if (parameter.getName().equals("unitPrice"))

					unitParice = Float.parseFloat(parameter.getStringValue());

				else if (parameter.getName().equals("amount"))

					amount = Integer.parseInt(parameter.getStringValue());

			}

			else if (part.isFile()) {

				// Here we get some info about the file

				FilePart filePart = (FilePart) part;

				imageName = filePart.getFileName();

				if (imageName != null) {

					// filePart.setRenamePolicy(customFileRenamePolicy);

					filePart.setRenamePolicy(new DefaultFileRenamePolicy());

					// Here we write the file to uploadedImageRepository
					// directory.

					filePart.writeTo(new File(uploadedImageRepository));

				} else {

					out.println("No file was uploaded for this part!<br><br>");

				}

			} // end of while

			/*
			 * else if(part.isParam()){
			 * 
			 * out.println( part.toString() + " is not a file!");
			 * 
			 * }
			 */

		}// end of while

		try {
			// Here we load the database driver
			Class.forName("com.mysql.jdbc.Driver");

			// Here we set the JDBC URL for the MYSQL database
			String url = "jdbc:mysql://mysql.cc.puv.fi:3306/e0700180_mjcsp";

			// Here we create a connection to the database
			conn = DriverManager.getConnection(url, "e0700180", "KfwYyr2XF5qC");

			// Here we create the statement object for executing SQL commands
			stmt = conn.createStatement();

			File image = null;
			
			String userID = new LoginFormBean().getUserId();

			FileInputStream fis = null;

			// Here we initialize the preparedStatement object

			ps = conn.prepareStatement("insert into " + table + "(name, unitPrice, amount, image) " + "values(?,?,?,?)");

			ps.setString(1, name);
			ps.setFloat(2, unitParice);
			ps.setInt(3, amount);

			image = new File(uploadedImageRepository + imageName);
			
			BufferedImage originalImage = ImageIO.read(image);
			
			BufferedImage aBufferedImage = createResizedCopy(originalImage, 120, 120, true);
			
			String fileExt = "";
			
			int i;

			if ((i = imageName.indexOf(".")) != -1) {

				/*
				 * 
				 * Here we read s substring of filename starting from ".", which
				 * 
				 * will be the file extension
				 */

				fileExt = ".jpg";

				// Here we read the filename without its extension

				imageName = imageName.substring(0, i);

			}
			
			// Here we get the date
			Date date = new Date();
			
			// Here we choose the date presentation format
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
			
			// Here we add the date time stamp to the file name
			imageName = imageName + ("" + sdf.format(date));
			
			// Here we put the file name parts together and create a new filename with the
			// directory path and the extension

						
			ImageIO.write( aBufferedImage, "jpeg" /* "png" "jpeg" ... format desired */,
		               new File ( uploadedImageRepository + imageName + fileExt) /* target */ );
			
			File newImage = new File(uploadedImageRepository + imageName + fileExt);


			fis = new FileInputStream(newImage);

			ps.setBinaryStream(4, (InputStream) fis, (int) (newImage.length()));

			// Here we insert data to the table and read the returned value

			int counter = ps.executeUpdate();

			if (counter > 0) {

				out.println("<p>" + name + " data uploaded successfully !");

			} else {

				out.println("<p>" + name + " data was not uploaded sucessfully!");

			}

			out.println("<p><center><a href='http://app.cc.puv.fi/icanbid/ProductUploadForm.jsp'>Back</a></center></p>");
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