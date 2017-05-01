<%-- 
    Document   : login
    Created on : 1-mag-2017, 18.13.02
    Author     : salvatore spanu 65219
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Salvatore Spanu">
        <meta name="keywords" content="login, nerdbook, informatica, iscrizione, account, social network, incontri, chat, community">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <div id="page">
            
            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="header.jsp"/>

            <c:set var="page" value="bacheca" scope="request"/>
            <jsp:include page="navbar.jsp"/>
            
            <div id="campi" class="formLogin">   
                <div id="loginForm" >
                    <form action="#" method="post">
                        <div id="campiLogin">
                            
                            <label for="username">Username</label><br />
                            <input name="username" id="username" type="text"/><br />

                            <label for="password">Password</label><br />
                            <input name="password" id="password" type="password"/><br />
                            
                            <button type="submit">Invia</button>
                        </div>
                    </form>
                </div>
            </div>
            
        </div>  
    </body>
    
</html>
