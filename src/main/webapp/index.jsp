<%--
  Created by IntelliJ IDEA.
  User: jjensen
  Date: 4/21/14
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericPage>
    <jsp:body>
        <h1>Welcome to Nubay</h1>
        <hr>
        <form method="post" action="/search">
            Search: <input type="text" name="searchBar"/>
            <input type="submit" />
        </form>
        <br/>
        Results:
        <div id="results">
            <c:out value="${message}"/>
            <ol>
            <c:forEach var="item" items="${model}">
                <li>
                <span><img src="${item.imgUrl}" width="100" height="100"/></span><span class="boldText"><a href="/item/${item.id}">${item.title}</a></span>
                    <span>Number of Bids: ${item.numberOfBids}</span>
                    <span>${item.formattedExpiration}</span><br/>
                </li>
            </c:forEach>
            </ol>
        </div>
        <c:if test="${currentPage != 1 && numberOfPages != null}">
            <a href="/search?page=${currentPage - 1}">Previous</a>
        </c:if>
        <ol>
            <c:forEach begin="1" end="${numberOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        ${i}
                    </c:when>
                    <c:otherwise>
                        <a href="/search?page=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ol>
        <c:if test="${currentPage lt numberOfPages}">
            <a href="/search?page=${currentPage +1}">Next</a>
        </c:if>

    </jsp:body>
</t:genericPage>