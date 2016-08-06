<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_email.jsp" />
<%@ page import="Mgmt.helper.*" %>

<td width="500" valign="top">

<script language="JavaScript">

</script>

<p>Please rate this product.</p>

<p><i>${message}</i></p>

<form  method="post" action="../ratingHelper?login=<%=request.getParameter("login")%>&productCode=<%=request.getParameter("productCode") %>">
<table cellpadding="5" border="0">
	
	
	Your Rating:<img src="/Final/images/star.png" width="15" height="15">
	<select name = "rating">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  </select>
    
	<textarea rows="4" cols="50" name="comment" value="${user.comment}">
Enter your comments here...
	</textarea>
    <tr>
        <td></td>
        <td><input type="submit" value="Confirm" id = "submit"></td>
    </tr>
    
    

</form>
<form method = "post" action="../home.jsp?login=<%=request.getParameter("login")%>">

<tr>
        <td></td>
        <td><input type="submit" value="Go Back" id = "submit"></td>
    </tr>
</form>

</td>
</table>
<jsp:include page="/include/column_right_news.jsp" />
<jsp:include page="/include/footer.jsp" />