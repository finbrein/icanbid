<!--This is the Login form -->
<%@ page language="java" %>
<html>
	<head>
		<title>iCANBID, Inc</title> 
		<link rel="stylesheet" type="text/css" href="styles.css">
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
	</head>
	<body>
		<!-- DIV Implementation -->
		<!-- Login Container -->
		<div id="lcontainer">
			<!-- Login Header -->
			<div id="lheader">
				<h1><a href="http://app.cc.puv.fi/icanbid/index.jsp">iCANBID</a></h1>
				<table>
					<tr>				
						<td><a href="http://app.cc.puv.fi/icanbid/LoginForm.jsp">Log In</a><span class="link-delimiter"> | </span></td>
						<td><a href="#">Account</a><span class="link-delimiter"> | </span></td>
						<td><a href="http://app.cc.puv.fi/icanbid/RegistrationForm.jsp">Register</a><span class="link-delimiter"> | </span></td>
						<td><a href="#">About iCANBID</a></td>
					</tr>
				</table>
			</div> <!-- End Login Header -->
			<!-- Top Navigation -->
			<div id="topnav">top navigation</div>
			<!-- Top Blank -->
			<div id="ltblank"><h2>Log In</h2></div>

		<div id="euser">		
		 <form method="post" action="LoginProcess.jsp"> 
			<table>	
			 <tr><td><h3>Existing User</h3> </td></tr>
			 <tr><td><label for="userInput" >User Name:</label></td></tr>
			 <tr><td><input type="text" name="userId" id="userInput" class="inptxt" size="33" maxlength="50"></td></tr> 
			 <tr><td><label for="passwordInput" id="password" >Password:</label></td></tr>
			 <tr><td><input type="password" name="password" class="inptxt" id="passwordInput" size="33" maxlength="50"></td> 
			 <td><a><input type="submit" id="login-button" name="login-button" alt="Login Button"  value="Log In"></a> </td></tr>
					<tr><td><p><a href="#">Forgot your user ID and/or password?</a></p></td></tr>
				
			</table>
		 </form>
		</div> 
		
		<div id="lblankuser">
		</div>
		
<div id="nuser"> 
 
	<table>
		<tr><td><h3>New User</h3></td></tr>
		<tr><td><p>There are various levels of access depending on your relationship with iCANBID. Review the
		<a href="#">benefits of registration</a> 
		and find the level that is most appropriate for you.</p></td></tr> 
		
		
		<tr><td align="right"><p><a href="http://app.cc.puv.fi/icanbid/RegistrationForm.jsp"><b><b>Register Now</b></b></a></p></td></tr>
	</table>
</div> 
 
		<div id="ltbblank"></div>	
			
    <div id="framework-footer"> 
        <div><div><a rel="exit" name="&amp;lpos=ft" title="Contacts" href="#" accesskey="9">Contacts</a> | <a rel="exit" name="&amp;lpos=ft" title="Feedback" href="#" accesskey="9">Feedback</a> | <a href="#" accesskey="0">Help</a> | <a href="#">Site Map</a></div></div> 
 
     <div>&copy; 2010 iCANBID Inc. All rights reserved.<a href="#">Terms &amp; Conditions</a> | <a href="#" >Privacy Statement</a> | <a href="#">Cookie Policy</a> | <a href="#" >iCANBID Inc.</a></div> 
    </div> 
		
		</div> <!-- End Login Container -->

	</body>
</html>