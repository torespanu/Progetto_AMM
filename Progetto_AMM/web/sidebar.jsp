<%-- 
    Document   : sidebar
    Created on : 1-mag-2017, 17.44.32
    Author     : salvatore spanu 65219
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="sidebar">
    <h3>Amici</h3>
    <ul id="listaAmici" class="liste">
        <li><img title="Bill" alt="Foto Bill Gates" src="img/bill_gates.jpg"/>Bill</li>
        <li><img title="Steve" alt="Foto Steve Jobs" src="img/steve_jobs.jpg"/>Steve</li>
        <li><img title="Linus" alt="Foto Linus Trovalds" src="img/linus.jpg"/>Linus</li>
    </ul>
    <h3>Gruppi</h3>
    <ul id="listaGruppi" class="liste">
        <li id="mongol">Mongolfieristi</li>
        <li id="ritard">Ritardatari</li>
    </ul>
    <c:if test="${empty param.user}">
        <p id="logOutLink"><a href="Login?logout=1">Logout</a></p>
    </c:if>
</div>
