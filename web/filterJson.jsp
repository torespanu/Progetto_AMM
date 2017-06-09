<%-- 
    Document   : filterJson
    Created on : 8-giu-2017, 23.11.47
    Author     : Salvatore Spanu
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="nerd" items="${listaNerds}">
        <json:object>
            <json:property name="nerd_id" value="${nerd.nerd_id}"/>
            <json:property name="username" value="${nerd.username}"/>
            <json:property name="nome" value="${nerd.nome}"/>
            <json:property name="cognome" value="${nerd.cognome}"/>
            <json:property name="urlFotoProfilo" value="${nerd.urlFotoProfilo}"/>
            <json:property name="frasePresentazione" value="${nerd.frasePresentazione}"/>
            <json:property name="dataNascita" value="${nerd.dataNascita}"/>
            <json:property name="password" value="${nerd.password}"/>
            <json:property name="email" value="${nerd.email}"/>
        </json:object>
    </c:forEach>
</json:array>
