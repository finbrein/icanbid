<%@ page language="Java" import="java.sql.*" %>  
<%@ page import="java.util.*" %>
<HTML>   
<HEAD><TITLE>DataBase Search</TITLE></HEAD>  
<BODY>
<%! 
%>
<jsp:useBean id="db" scope="request" class="bl.LoginFormBean" >
  <jsp:setProperty name="db" property="userId" value="<%=request.getParameter("userId")%>"/>
  <jsp:setProperty name="db" property="password" value="<%=request.getParameter("password")%>"/>
 </jsp:useBean>
<% 
if (db.validate()) {
%>
<jsp:forward page="LoginFormServlet">
  <jsp:param name="username" value="<%=db.getUserId()%>" />
  <jsp:param name="password" value="<%=db.getPassword()%>" />
</jsp:forward> 
<%
} else {
%>
<jsp:forward page="LoginRetry.jsp"/>
<%
}
%>
</body>
</html>