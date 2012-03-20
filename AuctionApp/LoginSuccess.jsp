<HTML>   
<HEAD><TITLE>Welcome</TITLE></HEAD>  
<BODY>
<br><br><br><br>
<table align="center" style="border:1px solid #000000;">
<%
if(session.getAttribute("userId")!=null && session.getAttribute("userId")!="")
{
String user = session.getAttribute("userId").toString();
%>
<tr><td align="center"><h1>Welcome Michael<b><%= user%></b></h1></td></tr>
<%
}
%>
<p> Welcome, Michael </p>
</table>
</body>
<html>