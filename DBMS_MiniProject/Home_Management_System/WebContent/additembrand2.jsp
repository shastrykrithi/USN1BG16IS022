<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.mysql.jdbc.Driver" %>
    <%@page import="java.sql.Connection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD</title>
</head>
<body>
<% 
String category=request.getParameter("count");

%>
<select name="subcategoryid" onchange="showPart(this.value)">
         <option value="none">Select ItemModel</option>
         <%
         
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/homedbms","root","root");
         Statement stmt= con.createStatement();
        ResultSet rs= stmt.executeQuery("select * from itemmodel_table where itemid='"+category+"'");
        while(rs.next()){
         %>
       <option value="<%=rs.getString("itemmodelid") %>"><%=rs.getString("itemmodelname") %></option>
        <% }
         
       %>
</select> 


</body>
</html>