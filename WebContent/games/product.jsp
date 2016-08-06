<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_all.jsp" />
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
  SELECT raterinfo, date, rating, comment from ratings where gameid = <%=request.getParameter("productCode") %>;
 </sql:query>
 <sql:query var="avg" dataSource="${myDS}">
  SELECT name, rating, stock, info, price, image from games where id = <%=request.getParameter("productCode") %>;
 </sql:query>
 
<!-- start the middle column -->

<td width="500" valign="top">
    
    
    <p>
    <c:forEach var="rating" items="${avg.rows}">
    <img src="/Final/images/${rating.image }" width="80" height="100"><br>
    <h1><c:out value="${rating.name}" /></h1>
	Price: $<c:out value="${rating.price}" /><br>
	<c:out value="${rating.stock}" /> copies in stock.<br><br> 
     Rating: <img src="/Final/images/star.png" width="20" height="20"><c:out value="${rating.rating}" /><br><br>
 	<c:out value="${rating.info}" /><br><br>
   </c:forEach>
    </p>

<a href="/Final/store/rating.jsp?login=<%=request.getParameter("login")%>&productCode=<%=request.getParameter("productCode") %>">
Click here to rate this product</a>
<table border="0" cellpadding="6">
   <caption><h2>Reviews:</h2></caption>
   <tr>
    <th>Date</th>
    <th>Rater</th>
    <th>Rating</th>
    <th>Comment</th>
   </tr>
   <c:forEach var="user" items="${listUsers.rows}">
    <tr>
     <td><c:out value="${user.date}" /></td>
     <td><c:out value="${user.raterinfo}" /></a></td>
     <td><c:out value="${user.rating}" /></td>
     <td><c:out value="${user.comment}"/></td>
    </tr>
   </c:forEach>
  </table>
</td>
<jsp:include page="/include/column_right_buttons.jsp" />
<jsp:include page="/include/footer.jsp" />
