<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/column_left_releases.jsp" />

<td width="500" valign="top">
    <h1>Upcoming Releases</h1>

    <p>
     2025 Winter:<br>
     <a href="../games/halo10/product.jsp?login=<%=request.getParameter("login")%>">Halo 10</a><br><br>
     2026 Spring:<br>
     <a href="../games/dbz2/product.jsp?login=<%=request.getParameter("login")%>">Dragonball Xenoverse 2</a>
  	</p>
</td>

<!-- end the middle column -->

<jsp:include page="/include/column_right_news.jsp" flush="true" />
<jsp:include page="/include/footer.jsp" />