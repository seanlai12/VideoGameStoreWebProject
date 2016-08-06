<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_catalog.jsp" />
<%@ page import="Mgmt.helper.*" %>

<td width="500" valign="top">

<script language="JavaScript">
function validate(form)
{
    if (form.quantity.value <= 0) 
    {
        alert("You must buy atleast 1!");
        form.quantity.focus();
    }
    else if (form.quantity.value=="") 
    {
        alert("Please fill in quantity");
        form.quantity.focus();
    }
    else 
    {
        form.submit();
    }
}
</script>

<p>Confirm your purchase?</p>

<p><i>${message}</i></p>

<form  method="post" action="../buyHelper?login=<%=request.getParameter("login")%>&productCode=<%=request.getParameter("productCode") %>">
<table cellpadding="5" border="0">
	<tr>
        <td align="right"><p>Quantity:</td>
        <td><input type="text" name="quantity" value="${user.quantity}" required>
        </td>
    </tr>
    <tr>
        
        <td><input type="button" value="Confirm" onClick="validate(this.form)"></td>
    </tr>

    
</table>
</form>
<form  method="post" action="/Final/home.jsp?login=<%=request.getParameter("login")%>">
<table cellpadding="5" border="0">
        
        
        <td><input type="Submit" value="Go Back"></td>
        
</table>
</form>
    
</td>

<jsp:include page="/include/column_right_news.jsp" />
<jsp:include page="/include/footer.jsp" />