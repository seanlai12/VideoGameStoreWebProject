<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_all.jsp" />
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
 var value = e.options[e.selectedIndex].value;; 

</script>
<sql:setDataSource
  var="myDS"
  driver="com.mysql.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/CSS490D"
  user="root" password="test12"
/>


<td width="700" valign="top">
    <h1>Transactions:</h1>
<%if(!(request.getParameter("login").equals("Sean")))
{
%>
<sql:query var="listUsers" dataSource="${myDS}">
  SELECT * FROM Transactions where name = '<%=request.getParameter("login") %>'
  ORDER BY id DESC;
 </sql:query>
<%
}

else{
%>
	<sql:query var="listUsers" dataSource="${myDS}">
  SELECT * FROM Transactions
  ORDER BY id DESC;
 </sql:query>
  <form method="post" action = "/Final/transactionSearch.jsp?login=<%=request.getParameter("login")%>">
<br>Search for user who bought this game more than twice a month.<input type="text" name="name" required>
        <input type="Submit" value="Search">
  </form>
<%	
}
%>


  <table border="0" cellpadding="8">
  <br>
   <caption><h2>Your Purchase History:</h2></caption>
   <tr>
    <th>Name</th>
    <th>Game Purchased</th>
    <th>Quantity</th>
    <th>Time</th>
   </tr>
   <c:forEach var="user" items="${listUsers.rows}">
    <tr>
     <td><c:out value="${user.name}" /></a></td>
     <td><a href="/Final/games/product.jsp?login=<%=request.getParameter("login")%>&productCode=${user.gameid}">
     <sql:query var="listGames" dataSource="${myDS}">
  		SELECT * FROM Games where id = ${user.gameid};
 	 </sql:query>
     <c:forEach var="game" items="${listGames.rows}">
     <c:out value="${game.name}" /></td></a>
     </c:forEach>
     <td><c:out value="${user.quantity}"/></td>
     <td><c:out value="${user.date}"/></td>
     
    </tr>
   </c:forEach>
   
   
  </table>

<form method="post" action = "/Final/revenueHelper?login=<%=request.getParameter("login")%>">
        Check total revenue from purchases: <input type="Submit" value="Submit"></input>
  </form>
  
</td>


<jsp:include page="/include/column_right_news.jsp" flush="true" />
<jsp:include page="/include/footer.jsp" />