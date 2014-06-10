<%--
  Created by IntelliJ IDEA.
  User: jjensen
  Date: 4/21/14
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericPage>
    <jsp:body>
        <h1>Welcome to Nubay</h1>
        <hr>
        <form method="post" action="/search">
            Search: <input type="text" name="searchBar"/>
            <input type="submit" />
        </form>
    </jsp:body>
</t:genericPage>
