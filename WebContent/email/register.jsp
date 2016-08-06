<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_email.jsp" />
<%@ page import="Mgmt.helper.*" %>

<td width="500" valign="top">

<h1>Create a SGS Account</h1>

<p><i>${message}</i></p>

<script>
function validate(form)
{
    if (form.username.value=="") 
    {
        alert("Please fill in your username");
        form.username.focus();
    }
    else if (form.password.value=="") 
    {
        alert("Please fill in your password");
        form.password.focus();
    }
    else if (form.email.value=="") 
    {
        alert("Please fill in your email address");
        form.email.focus();
    }
    else 
    {
        form.submit();
    }
}
</script>
<form  method="post" action="../accHelper?login="<%=request.getParameter("login")%>>
<table cellpadding="0" border="0">
    <tr>
        <td align="right"><p>Username:</td>
        <td><input type="text" name="username" value="${user.username}" required>
        </td>
    </tr>
    <tr>
        <td align="right"><p>Password:</td>
        <td><input type="text" name="password" value="${user.password}" required>
        </td>
    </tr>
    <tr>
        <td align="right"><p>Email Address:</td>
        <td><input type="text" name="email" value="${user.email}" required>
        </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="button" value="Submit" 
                   onClick="validate(this.form)"></td>
    </tr>
</table>
</form>

</td>

<jsp:include page="/include/column_right_news.jsp"  flush="true" />
<jsp:include page="/include/footer.jsp" />