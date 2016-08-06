<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="Mgmt.gameDB.*" %>
<%@ page import="Mgmt.games.*" %>
<%@ page import="Mgmt.accountDB.*" %>

<sql:setDataSource
  var="myDS"
  driver="com.mysql.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/CSS490D"
  user="root" password="test12"
/>
<sql:query var="listUsers" dataSource="${myDS}">
  SELECT id, name, price, info, image from games where id = (
    SELECT max(id) FROM games
    );
 </sql:query>
 
 
<td width="550" valign="top" bgcolor="#FFFFFF">
    <h1>New release:</h1>
    
    
    <c:forEach var="user" items="${listUsers.rows}">
	<img src="/Final/images/${user.image}" width="80" height="100"><br>
     <c:out value="${user.name}" /><br>
     $<c:out value="${user.price}"/><br><br>
     <a href="/Final/games/product.jsp?login=<%=request.getParameter("login")%>&productCode=${user.id}"><c:out value="click to find out more"/>
     </a>
     
   </c:forEach>
</td>