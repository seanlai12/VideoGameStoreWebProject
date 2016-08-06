<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_login.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="Mgmt.gameDB.*" %>
<%@ page import="Mgmt.games.*" %>
<%@ page import="Mgmt.accountDB.*" %>

<form  method="post" action="loginHelper">
 
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
    else 
    {
        form.submit();
    }
}
</script>


 
<td width="500" valign="top">
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
        <td></td>
        <td><input type="button" value="Submit" 
                   onClick="validate(this.form)"></td>
    </tr>
</table>
</form>

</td>


<jsp:include page="/include/column_right_news.jsp" flush="true" />
<jsp:include page="/include/footer.jsp" />