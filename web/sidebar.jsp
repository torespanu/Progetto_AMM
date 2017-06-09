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
    <p id="searchNerd">
                <input id="searchField" type="text" placeholder="Cerca Nerd" value="">
                <button id="searchNerd">Cerca</button>
    </p>
    <ul id="listaAmici" class="liste">
       
        <c:forEach var="nerd" items="${listaNerds}">
            <li class="user"><a href="Bacheca?user=${nerd.nerd_id}"><img src="${nerd.urlFotoProfilo}" alt="Foto Nerd">${nerd.nome} ${nerd.cognome}</a></li>
        </c:forEach> 

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
