<%-- 
    Document   : registration
    Created on : Feb 1, 2017, 9:27:51 PM
    Author     : Daniel
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Registration"/>

<t:page-layout title="${title}">
    
    <div class="one half centered padded">
        
        <h2>${title}</h2>
        
        <t:registration-form/>
        
    </div>
    
</t:page-layout>