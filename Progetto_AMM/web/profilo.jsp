<%-- 
    Document   : profilo
    Created on : 1-mag-2017, 18.15.12
    Author     : salvatore spanu 65219
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Salvatore Spanu">
        <meta name="keywords" content="profilo, nerdbook, informatica, social network, incontri, chat, community">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <div id="page">
            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="header.jsp"/>

            <c:set var="page" value="bacheca" scope="request"/>
            <jsp:include page="navbar.jsp"/>
            
            <c:set var="page" value="bacheca" scope="request"/>
            <jsp:include page="sidebar.jsp"/>


            <div id="campi">
                
                <div class="campiForm">
                    <p>Profilo di ${nerd.nome}</p>
                        <img title="Linus" alt="Foto Linus Trovalds" src="${nerd.urlFotoProfilo}"/>
                        <form action="#" method="post">
                        <div>
                            <label for="nome">Nome</label><br />
                            <input type="text" name="nome" id="nome" value="${nerd.nome}"/><br />

                            <label for="cognome">Cognome</label><br />
                            <input type="text" name="cognome" id="cognome" value="${nerd.conome}"/><br />

                            <label for="immagine">Immagine</label><br />
                            <input type="url" name="immagine" id="immagine" value="http://prova.it"/><br />

                            <label for="frasePresentazione">Frase di presentazione</label><br />
                            <textarea name="frasePresentazione" id="frasePresentazione">Prova</textarea><br />

                            <label for="dataNascita">Data di nascita</label><br />
                            <input name="dataNascuta" id="dataNascita" type="date"/><br />

                            <label for="pswd">Password</label><br />
                            <input type="password" name="pswd" id="pswd"/><br />

                            <label for="cpswd">Conferma Password</label><br />
                            <input type="password" name="cpswd" id="cpswd"/><br />

                            <button type="submit">Invia dati</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    
</html>

