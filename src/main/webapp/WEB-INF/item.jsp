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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericPage>
    <jsp:body>
        <!--Your content goes here-->
        <h1>${model.title}</h1>
        <img src="${model.imgUrl}" width="200" height="200"/><a href="/item/${model.id}/update">Edit</a><a href="/item/${model.id}/delete">Delete</a>
        <dl>
            <dt>Current Bid:</dt>
            <dd>$ ${model.currentBid}</dd>
            <dt>Time Left</dt>
            <dd><c:out value=" ${model.timeLeft}"/> Days</dd>
            <form method="POST" action="/item/bid">
                <input type="hidden" name="id" value="${model.id}"/>

                <dt>
                    <input type="text" name="bid"/>
                </dt>
                <dd>
                    <input type="submit" value="Place a bid"/>
                </dd>
            </form>
        </dl>
    </jsp:body>
</t:genericPage>

