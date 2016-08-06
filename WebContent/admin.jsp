<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="Mgmt.gameDB.*" %>
<%@ page import="Mgmt.games.*" %>
<%@ page import="Mgmt.accountDB.*" %>

<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_all.jsp" />
    <td width="500" valign="top">
	<body>
		<form action="admin2.jsp?login=<%=request.getParameter("login")%>" method="post" enctype="multipart/form-data">
		<table cellpadding="0" border="0">
				<h4>Admin</h4>
				<p>Add a game:</p>
				<tr>
				<td align="right"><p>Name:</td>
				<td> <input type="text" name="name" id="name" required="required"/></td>
				</tr>
				<tr>
				<td align="right"><p>Stock:</td>
				<td> <input type="text" name="stock" id="stock" required="required"/></td>
				</tr>
				<tr>
				<td align="right"><p>Price:</td>
				<td> <input type="text" name="price" id="price" required="required"/></td>
				</tr>
				<tr>
				<td align="right"><p>Info:</td>
				<td> <input type="text" name="info" id="info" required="required"/></td>
				</tr>
				<tr>
				<td align="right"><p>Genre:</td>
				<td> <input type="text" name="genre" id="genre" required="required"/></td>
				</tr>
				</tr>
				<tr>
				<td align="right"><p>Picture:</td>
				<td><input type="file" name="pic" id="pic"/></td>
				</tr>
				<tr>
				<td align="right"><p></td>
				<td><input type="submit" value="Submit" id="submit"/></td>
				</tr>
				
			
		</form>
		<form action="deleteGameHelper?login=<%=request.getParameter("login")%>" method="post">
		<tr>
				<td align="right"><p>Delete a game: </td>
				<td> <input type="text" name="delete" id="delete" required="required"/></td>
				</tr>
				
				<tr>
				<td align="right"><p></td>
				<td><input type="submit" value="Submit" id="submit"/></td>
				</tr>
		</form>
		</table>
		<script>
   		
	</script>
	</body>
	</td>
<jsp:include page="/include/column_right_news.jsp" flush="true" />
<jsp:include page="/include/footer.jsp" />