
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>

<%--
  Created by IntelliJ IDEA.
  User: jjensen
  Date: 4/23/14
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <title>Item ${model.id}</title>
</head>
<body>

<div id="wrapper">
    <div id="header">

        <div id="logo"><h1>NUBAY</h1></div>
        <div id="headerend"></div>
    </div>
    <div id="navigation">
        <ul id="nav">
            <li><a href="/">Home</a></li>
            <li><a href="/item/new">New Item</a></li>
        </ul>
    </div>

    <div id="contentWrapper">
        <div id="content">
            <jsp:doBody/>

        </div>

    </div>
    <div id="footer"><center>Created by: jjensen</center></div>
</div>

</body>
</html>

