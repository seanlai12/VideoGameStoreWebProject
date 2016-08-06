<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_catalog.jsp" />

<!-- start the middle column -->

    <td width="500" valign="top">
      <h2>Thank you for your purchase!</h2>

      
<table cellpadding="5" border="0">
<form method = "post" action="../home.jsp?login=<%=request.getParameter("login")%>">

<tr>
        <td></td>
        <td><input type="submit" value="Go Back" id = "submit"></td>
    </tr>
</form>
      </table>
      </p>
    </td>

<!-- end the middle column -->

<jsp:include page="/include/column_right_news.jsp" flush="true" />
<jsp:include page="/include/footer.jsp" />