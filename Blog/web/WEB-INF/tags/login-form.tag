<%-- 
    Document   : login-form
    Created on : Jan 24, 2017, 7:39:40 PM
    Author     : Daniel
--%>
<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="padded centered two fourths">
    <h2>Sign in</h2>
    <form action="${pageContext.request.contextPath}/auth/log-in" method="post">
        <c:if test="${error != null}">
            <p class="error gap-bottom">${error}</p>
        </c:if>
        <input class="gap-bottom" type="text" name="login" placeholder="Login">
        <input class="gap-bottom" type="password" name="password" placeholder="Password">
        <button class="pull-right">Sign in</button>
    </form>
</div>