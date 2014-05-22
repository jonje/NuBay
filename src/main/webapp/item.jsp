<%@ page import="lab2.model.Item" %>
<%@ page import="java.text.DecimalFormat" %>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Item item = (Item)request.getAttribute("model");
    DecimalFormat formatter = new DecimalFormat("#.00");

 %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <title>Item <%item.getId(); %></title>
</head>
<body>
<c:choose>
    <c:when test="${list.get(0) != null}">
        <h3>Brakes</h3>
        <p>Common brake problems are often caused by not replacing brake pads when needed or having warped rotors. Brake pads are roughly a $30 fix and will keep from warping your rotors.</p>
        <p>Warped rotors can be either shaved down so that they are smooth again or replaced for roughly $80.</p>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>
<div id="wrapper">
    <div id="header">

        <div id="logo"><h1>NUBAY</h1></div>
        <div id="headerend"></div>
    </div>

    <div id="contentWrapper">
        <div id="content">
            <h1>Auction Item <% out.print(item.getId()); %></h1>
            <img src=""
            <dl>
                <dt>Current Bid:</dt>
                <dd><%out.print(formatter.format(item.getCurrentBid())); %></dd>
                <dt>Time Left</dt>
                <dd><% out.print(item.getTimeLeft());%> Days</dd>
                <form method="POST" action="item">
                    <input type="hidden" name="id" value="<% out.print(item.getId());%>"/>

                    <dt>
                        <input name="bid"/>
                    </dt>
                    <dd>
                        <input type="submit" value="Place a bid"/>
                    </dd>
                </form>
            </dl>

        </div>

    </div>
    <div id="footer"><center>Created by: jjensen</center></div>
</div>

</body>
</html>

