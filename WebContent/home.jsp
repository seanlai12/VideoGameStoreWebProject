<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="Mgmt.gameDB.*" %>
<%@ page import="Mgmt.games.*" %>
<%@ page import="Mgmt.accountDB.*" %>
<%
if(request.getParameter("login") == null)
{
	out.println("<script type=\"text/javascript\">");
	  out.println("location='/Final/home.jsp?login=null'");
	  out.println("</script>");
}
else
{
%>


<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_home.jsp" />

<!-- start the middle column -->

    <td width="500" valign="top">
      <h1>Welcome!</h1>
      <p>
      This is the best online game store with the newest and hottest selections.
      You can browse through our collection to find what is the most anticipated game of the season.
      We offer the most accurate ratings and pricing in the gaming industry.
      </p>
      <table border="0" cellpadding="6">
 <sql:setDataSource
  var="myDS"
  driver="com.mysql.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/CSS490D"
  user="root" password="test12"
/>
<br><br>
<caption><h2>Top 5 Most popular games.</h2></caption>
   <tr>
    <th>Title</th>
    <th>Rating</th>
    <th>Price</th>
    <th>Genre</th>
   </tr>
<sql:query var="listUsers" dataSource="${myDS}">
  SELECT * FROM Games
  ORDER BY rating DESC
  LIMIT 5;
 </sql:query>
      <c:forEach var="user" items="${listUsers.rows}">
    <tr>
     <td>  <a href="/Final/games/product.jsp?login=<%=request.getParameter("login")%>&productCode=${user.id}"><c:out value="${user.name}" /></a></td>
     <td><img src="/Final/images/star.png" width="12" height="12"><c:out value="${user.rating}" /></td>
     <td>$<c:out value="${user.price}"/></td>
     <td><c:out value="${user.genre}"/></td>
    </tr>
   </c:forEach>
    </td>
</table>
<jsp:include page="/include/column_right_news.jsp" flush="true" />
<jsp:include page="/include/footer.jsp" />
<%
}
%>