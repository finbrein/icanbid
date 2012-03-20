<!--This is the registration form -->
<%@ page language="java" %>
<html>
	<head>
		<title>iCANBID Registration - ICANBID Inc</title> 
		<link rel="stylesheet" type="text/css" href="styles.css">
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
	</head>
	<body>
		<!-- DIV Implementation -->
		<!-- Login Container -->
		<div id="lcontainer">
			<!-- Login Header -->
			<div id="lheader">
				<h1><a href="http://app.cc.puv.fi/mlogg/MainPublicPage.html">iCANBID</a></h1>
				<table>
					<tr>				
						<td><a href="http://app.cc.puv.fi/malogg/LoginForm.jsp">Log In</a><span class="link-delimiter"> | </span></td>
						<td><a href="#">Account</a><span class="link-delimiter"> | </span></td>
						<td><a href="http://app.cc.puv.fi/malogg/RegistrationForm.jsp">Register</a><span class="link-delimiter"> | </span></td>
						<td><a href="#">About iCANBID</a></td>
					</tr>
				</table>
			</div> <!-- End Login Header -->
			<!-- Top Navigation -->
			<div id="topnav">top navigation</div>
			<!-- Top Blank -->
			<!-- div id="ltblank"><h2>Log In</h2></div> -->
			
<!-- MAIN CONTENT TABLE --> 
<!-- Minimum width: 900 pixels --> 
		<!-- CDC-DM: Hinav Start --> 
		<div id="hinav" class="title-section">
			<!-- h3>Hierarchical Navigation</h3 -->
			<ul class="a">
			<li class="top"><a href="http://app.cc.puv.fi/mlogg/MainPublicPage.html" class="parent">HOME</a><hr/></li>
			<li class="middle">
			<strong>
				<a class="middle" href="http://app.cc.puv.fi/malogg/RegistrationForm.jsp">iCANBID Registration</a>
			</strong><hr/></li>
			<li class="bottom">
			<a class="inner" href="#" class="child">Overview</a><hr/></li></ul>
			
			
		</div> 
		<!-- CDC-DM: Hinav End --> 
		
		<div id="framework-content">
			<h1 class="title-section">Welcome to iCANBID</h1> 
			<h2 class="title-page">iCANBID Registration</h2> 
			
			<div id="headerfocusbox"> 
			<h3>Create an Account</h3> 
			<p class="big">Complete this form to register for an iCANBID Account. <a href="#">Already have an iCANBID Account?</a><br> 
			Please enter your information in English only.</p> 
			<p class="parablue"><strong>* Required Field</strong></p> 
			</div>	
			
			<!-- zzzzzzzzzzzzzzzzzzzzzzzzzz -->
			<div id="loginInfo"> 
				<form name="RPFForm" method="post" action="RegistrationProcess.jsp"> 
						<table border="0" style="width: 80%" class="tableLoginInfo" cellspacing="8px"> 
							<thead> 
							<tr> 
							<td colspan="3" width="30%" class="logintableHeaderContent"><strong>Login Information<hr/></strong></td> 
							</tr> 
							</thead> 
								<tbody> 
										<tr> 
										<td valign="top" width="30%" class="loginInfoFont">* Email Address</td> 								
										<td valign="top"> 
										 <input type="text" name="emailAddress" value="" size="33" maxlength="50"> 
										</td> 
										<td valign="top" class="smallFont">We will use this e-mail address to verify your registration.</td> 
										</tr> 
										<tr> 
										<td valign="top" width="auto" class="loginInfoFont">* Retype Email Address</td> 
										<td valign="top"> 
										<input type="text" name="repeatEmailAddress" value="<%= request.getParameter("repeatEmailAddress")%>" size="33" maxlength="50"> 
										</td> 
										<td valign="top"></td> 
										</tr> 
										<tr> 
										<td valign="top" width="auto" class="loginInfoFont">* User ID</td> 
										<td valign="top"> 
										<input type="text" name="userId" value="" size="33" maxlength="50"> 
										</td> 
										<td valign="top" class="smallFont">Must be 9-50 characters without spaces, and must include at least one letter.</td> 
										</tr> 
										<tr> 
										<td valign="top" width="auto" class="loginInfoFont">* Password</td> 
										<td valign="top"> 
										<input type="password" name="password" value="" size="33" maxlength="50"> 
										</td> 
										<td valign="top" class="smallFont">Must be 8 or more characters and contain a combination of uppercase and lowercase letters (A-Z or a-z) and at least 1 number (0-9).</td> 
										</tr> 
										<tr> 
										<td valign="top" width="auto" class="loginInfoFont">* Retype Password</td> 
										<td valign="top"> 
										<input type="password" name="repeatPassword" value="" size="33" maxlength="50"> 
										</td> 
										<td valign="top"></td> 
										</tr> 		
										<tr> 
										
										<td colspan="3" class="contacttableHeaderContent"><br></br><strong>Contact Information<hr/></strong></td> 
										</tr> 
										<tr> 
										<td colspan="3" valign="top" width="auto" class="loginInfoFont">* Will you provide contact information?</td> 
										</tr> 
										<tr rowspan="1"> 
										<td valign="top" class="loginInfoFont" width="145">* First Name</td> 
										<td valign="top" colspan="2"> 
										<input type="text" name="firstName" value="" size="33" maxlength="50"> 
										</td> 
										</tr> 
										<tr> 
											<td valign="top" width="auto" class="loginInfoFont">* Last Name</td> 
											<td valign="top" colspan="2"> 
											<input type="text" name="lastName" value="" size="33" maxlength="50"> 
											</td> 
										</tr> 
										<tr rowspan="1"> 
										<td valign="top" class="loginInfoFont">* Phone Number</td> 
											<td valign="top" colspan="2"> 
											<input type="text" name="phoneNumber" value="" size="33" maxlength="50"> 
											</td> 
										</tr> 
								<!-- to be deleted NOW -->
									</tbody> 
								</table> 	
								<br></br>
								<div id="footerfocusbox">
								<table border="0" style="width:100%" class="otherInfo" cellspacing="8px"> 
									<tr> 
										<td valign="top" colspan="3"> 			  
											 			
											<input type="submit" name="Submit" class="style37" value='Submit'/>&nbsp;&nbsp;			
											<a href="http://app.cc.puv.fi/mlogg/MainPublicPage.html" name="Cancel"><strong>Cancel</strong></a> 
											<br/> 
											<p>If you have questions or need further assistance, please email <a href= "http://app.cc.puv.fi/malogg/RegistrationForm.jsp">web-help@icanbid.com</a>.</p> 
											
										</td> 
									</tr> 
								</tbody> 
							</table> 
							</div> 
						</td> 
					</tr> 
				</table>
			</td> 
		</tr> 
	</table> 
</td> 
</tr> 
</table> 
				</form> 
			</div> 
			<!-- zzzzzzzzzzzzzzzzzzzzzzzzz -->
			
			
			
		</div> 
	<!-- END MAIN CONTENT TABLE -->	
	
	<div id="ltbblank"></div>	


			
    <div id="framework-footer"> 
        <div id="footer-nav"><div id="footer-nav"><a rel="exit" name="&amp;lpos=ft" title="Contacts" href="#" accesskey="9">Contacts</a> | <a rel="exit" name="&amp;lpos=ft" title="Feedback" href="#" accesskey="9">Feedback</a> | <a href="#" accesskey="0">Help</a> | <a href="#">Site Map</a></div></div> 
 
     <div>&copy; 2010 iCANBID Inc. All rights reserved.<a href="#">Terms &amp; Conditions</a> | <a href="#" >Privacy Statement</a> | <a href="#">Cookie Policy</a> | <a href="#" >iCANBID Inc.</a></div> 
    </div> 
	
</div>	
	</body>
</html>