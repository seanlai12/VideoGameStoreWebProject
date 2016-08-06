<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_catalog.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="Mgmt.gameDB.*" %>
<%@ page import="Mgmt.games.*" %>
<%@ page import="Mgmt.accountDB.*" %>

<script>
function dothis(){
 var e = document.getElementById("category");
 var value = e.options[e.selectedIndex].value;
</script>
<sql:setDataSource
  var="myDS"
  driver="com.mysql.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/CSS490D"
  user="root" password="test12"
/>
<sql:query var="listUsers" dataSource="${myDS}">
  SELECT * FROM Games
  ORDER BY price;
 </sql:query>
<td width="700" valign="top">
    <h1>SGS Catalog</h1>
<form  method="post" action="../browseHelper?login=<%=request.getParameter("login")%>">    
 <select name = "category" onchange="dothis()">
  <option value="newest">newest</option>
  <option value="oldest">oldest</option>
  <option value="rating1">rating high to low</option>
  <option value="rating2">rating low to high</option>
  <option value="pricing1">pricing high to low</option>
  <option value="pricing2">pricing low to high</option>
  </select>
  <input type="submit" value="Browse" id = "submit">
  </form>
  <form method="post" action = "../browseHelper1?login=<%=request.getParameter("login")%>">
	<input type="text" name="gamename" value="${user.name}" required>
        <input type="Submit" value="Search by Name">
  </form>
    <form method="post" action = "../browseHelper2?login=<%=request.getParameter("login")%>">
	<input type="text" name="genre" value="${user.genre}" required>
        <input type="Submit" value="Search by Genre">
  </form>
  <table border="0" cellpadding="6">
  <br>
   <caption><h2>List of games</h2></caption>
   <tr>
    <th>Title</th>
    <th>Rating</th>
    <th>Price</th>
    <th>Genre</th>
   </tr>
   <c:forEach var="user" items="${listUsers.rows}">
    <tr>
     <td>  <a href="../games/product.jsp?login=<%=request.getParameter("login")%>&productCode=${user.id}"><c:out value="${user.name}" /></a></td>
     <td><img src="/Final/images/star.png" width="12" height="12"><c:out value="${user.rating}" /></td>
     <td>$<c:out value="${user.price}"/></td>
     <td><c:out value="${user.genre}"/></td>
    </tr>
   </c:forEach>
  </table>
</td>

<jsp:include page="/include/column_right_news.jsp" flush="true" />
<jsp:include page="/include/footer.jsp" />