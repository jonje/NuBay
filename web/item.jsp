<%@ page import="lab2.Item" %>
<%@ page import="org.joda.time.Period" %>
<%@ page import="java.text.DecimalFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: jjensen
  Date: 4/23/14
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Item item = (Item)request.getAttribute("item");
    DecimalFormat formatter = new DecimalFormat("#.00");

 %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <title>Item <%item.getId(); %></title>
</head>
<body>
<div id="wrapper">
    <div id="header">

        <div id="logo"><h1>NUBAY</h1></div>
        <div id="headerend"></div>
    </div>

    <div id="contentWrapper">
        <div id="content">
            <h1>Auction Item <% out.print(item.getId()); %></h1>
            <img width="200" src="http://localhost:8080/lab2/images/img.png" />
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

