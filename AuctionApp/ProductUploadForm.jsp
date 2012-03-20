<!--This is the Main Public Page HTML form -->
<!--This is index.html file -->
<!DOCTYPE HTML PUBLIC "-//W3C/DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>iCANBID Registration - ICANBID Inc</title> 
		<link rel="stylesheet" type="text/css" href="styles.css">
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
	</head>
	<body>
		<!-- DIV Implementation -->
		<!-- Login Container -->
		<div id="container">
			<!-- Login Header -->
			<div id="header">
				<h1><a href="http://app.cc.puv.fi/icanbid/index.jsp">iCANBID</a></h1>
				 <table>
					<tr>				
						<td><a href="#">Log Out</a><span class="link-delimiter"> | </span></td>
						<td><a href="#">Account</a><span class="link-delimiter"> | </span></td>
						<td><p class="parablue"><strong><a href="#">Bid</a><span class="link-delimiter"> | </span></strong></p></td>
						<td><a href="#">About iCANBID</a></td>						
					</tr>
				</table>
			</div> <!-- End Login Header -->
			<!-- Top Navigation -->
			<div id="topnav">top navigation</div>
			<div id="tblank"></div>
		
	  <div id="pnav"></div>	
	  <div id="newbid">
		<h2>New Bid Item</h2>
		<form name="profile" method="post" action="uploadProduct" enctype="multipart/form-data">
			<table width="500" border="0">
				<tr> 
					  <td width="150" bgcolor="#3B5998"><strong><font color="white">Product Name</font></strong></td> 
					  <td><input type="text" name="name" size="20" maxlength="50"></td> 
				</tr>
			    <tr> 
					  <td width="150" bgcolor="#3B5998"><strong><font color="white">Unit Price</font></strong></td> 
					  <td><input type="text" name="unitPrice" size="20" maxlength="50"></td> 
				</tr>				
				<tr>				
					<td bgcolor="#3B5998"><strong><font color="white">Amount:</font></strong></td>
					<td>
						<select name="amount">
							<option value="1">1
							<option value="2">2
							<option value="3">3
							<option value="4">4
							<option value="5">5
							<option value="10">10
							<option value="50">50
							<option value="100">100
						</select>
					</td>
				</tr>
				<tr> 
					  <td width="180" bgcolor="#3B5998" ><strong><font color="white">Upload product image (JPEG PREFERRED): </font></strong></td> 
					  <td><input type="file" name="fileName" size="20" maxlength="20"></td> 
				</tr>

			</table>
				<p>
					<input type="submit" value="Add Item">
					<input type="reset" value="Reset">
				</p>

		</form>
		<p><center><a href='http://app.cc.puv.fi/icanbid/customer'>Back to Customer's Page</a></center></p>
		 </div>
		 <div id="pext"></div>	
	  </div>
	</body>
</html>