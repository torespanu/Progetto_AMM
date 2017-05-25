<%-- 
    Document   : bacheca
    Created on : 1-mag-2017, 16.15.10
    Author     : Salvatore Spanu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Salvatore Spanu">
        <meta name="keywords" content="bacheca, nerdbook, informatica, social network, incontri, chat, community">
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

            <div id="bacheca">
                
                <h2>Bacheca di ${nerd.nome}</h2>
                <div id="nuovoPost">
                    <form action="#" method="post">
                        <label for="testo">Testo nuovo post</label>
                        <textarea name="testo" id="testo">Testo nuovo post</textarea><br />

                        <label for="allegato">allegato</label>
                        <input type="url" name="allegato" id="allegato" value="http://prova.it"/><br />
                        <label for="immagine">Immagine</label>
                        <input type="radio" name="allegato" id="immagine" value="immagine">
                        <label for="link">Link</label>
                        <input type="radio" name="allegato" id="link" value="link"><br />
                        <button type="submit">Invia dati</button>

                    </form>
                </div>
                <c:forEach var="post" items="${posts}">
                    <div class="post">
                        <c:if test="${post.postType == 'TEXT'}">
                            <p>${post.content}</p>
                        </c:if>
                        <c:if test="${post.postType == 'IMAGE'}">
                            <p>${post.content}</p>
                            <img alt="Post con foto" src="${post.content}">
                        </c:if>
                        <c:if test="${post.postType == 'URL'}">
                            <p>${post.content}</p>
                            <p>${post.content}</p>
                        </c:if>
                    </div>
                </c:forEach>
                
                <!--<div id="post1">
                    <img title="Bill" alt="Foto Bill Gates" src="img/bill_gates.jpg" width="100"/>
                    <p id="nick1">Bill</p>

                    <div id="messaggio1">
                        <p>Messaggio: Ciao, questo è un primo messaggio lasciato in bacheca</p>
                    </div>
                </div>

                <div id="post2">
                    <img title="Steve" alt="Foto Steve Jobs" src="img/steve_jobs.jpg" width="150"/>
                    <p id="nick2">Steve</p>
                    <div id="messaggio2">
                        <p>Messaggio: Ciao, questo è un secondo messaggio lasciato in bacheca</p>
                    </div>
                    <p id="allegato2"><img title="fotoAllegato1" alt="schermata blu" src="img/blu-screen.jpg" width="200"/></p>
                </div>

                <div id="post3">
                    <img title="Linus" alt="Foto Linus Trovalds" src="img/linus.jpg" width="150"/>
                    <p id="nick3">Linus</p>
                    <div id="messaggio3">
                        <p>Messaggio: Ciao, questo è un terzo messaggio lasciato in bacheca</p>
                    </div>  
                    <p id="allegato3"><a href="http://www.ubuntu.com">Io sono ciò che sono in virtù di ciò che siamo tutti</a></p>
                </div>-->

            </div>  
        </div>
    </body>
</html>

