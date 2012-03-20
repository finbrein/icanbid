<%@ page language="java" import="java.sql.*" %>
<%@ page import="java.util.*" %>
<HTML>   
<HEAD><TITLE>DataBase Search</TITLE></HEAD>  
<BODY>
<%! 
%>
<jsp:useBean id="formHandler" class="bl.RegistrationFormBean" scope="request">
	<jsp:setProperty name="formHandler" property="*"/>
</jsp:useBean>
<% 
if (formHandler.validate()) {
%>
<jsp:forward page="RegistrationServlet">
  <jsp:param name="emailAddress" 		value="<%=formHandler.getEmailAddress()%>" />
  <jsp:param name="repeatEmailAddress" 	value="<%=formHandler.getRepeatEmailAddress()%>" />
  <jsp:param name="userId" 				value="<%=formHandler.getUserId() %>" />
  <jsp:param name="password" 			value="<%=formHandler.getPassword() %>" />
  <jsp:param name="repeatPassword" 		value="<%=formHandler.getRepeatPassword()%>" />
  <jsp:param name="firstName" 			value="<%=formHandler.getFirstName()%>" />
  <jsp:param name="lastName" 			value="<%=formHandler.getLastName()%>" />
  <jsp:param name="phoneNumber" 		value="<%=formHandler.getPhoneNumber()%>" />
</jsp:forward> 

<%
} else {
%>
<jsp:forward page="RegistrationRetry.jsp"/>
<%
}
%>
</BODY>
</HTML> 




