<%-- 
    Document   : registration-form
    Created on : Feb 1, 2017, 9:21:29 PM
    Author     : Daniel
--%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${pageContext.request.contextPath}/registration" method="post">
    <c:if test="${error != null}">
        <p class="error">${error}</p>
    </c:if>
    <input type="text" name="login" placeholder="Login" required>
    <input type="text" name="name" placeholder="Name" required>
    <input type="text" name="lastname" placeholder="Last name" required>
    <input type="text" name="email" placeholder="E-mail" required>
    <input type="password" name="password" placeholder="Password" required>
    <input type="password" name="confirm" placeholder="Confirm password" required>
    <button class="centered">Submit</button>
</form>