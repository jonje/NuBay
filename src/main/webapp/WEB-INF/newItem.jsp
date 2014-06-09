<%--
  Created by IntelliJ IDEA.
  User: jjensen
  Date: 5/30/14
  Time: 3:37 PM
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
        <h1>Add/Update Auction Item</h1>
        <form method="post" action="/item/create">
            <input type="hidden" name="itemId" value="${model.id}"/>
            Title: <input type="text" name="title" value="${model.title}"/><br/>
            Expiration Date: <input type="text" name="expiration" value="${model.formattedExpiration}"/>(mm/dd/yyyy)<br/>
            Img: <input type="text" name="imgUrl" value="${model.imgUrl}"/><br/>
            <input type="submit" value="Add/Update"/>

        </form>

    </jsp:body>
</t:genericPage>

