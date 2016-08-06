
<head>
    <title>Super Game Store</title>
</head>

<body>

<table cellpadding="5" cellspacing="0" border="0" width="756">


<tr> 
    <td colspan="3">
        <img src="/Final/images/logo.jpg" alt="Super Game Shop" 
             width="1000" height="200">
             <%
if(request.getParameter("login").equals("null") || request.getParameter("login").equals(""))
{
%>
			Welcome to SGS!<br>
			<a href="/Final/login.jsp?login=null">Login</a> | 
			<a href="/Final/email/register.jsp?login=null">Register</a>
            
<%} 

else{
%>
			Hello <%=request.getParameter("login")%>!<br>
		    <a href="?login=null">Logout</a> |
		    <a href="/Final/transactionHistory.jsp?login=<%=request.getParameter("login")%>">
        	Purchase History</a>
<%if(request.getParameter("login").equals("Sean")) {%>
        	 |
      		<a href="/Final/admin.jsp?login=<%=request.getParameter("login")%>">
        	Admin</a>
<%
}
}
%>

    </td>
    
</tr>


<tr>
