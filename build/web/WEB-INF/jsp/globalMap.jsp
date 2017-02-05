<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Geofilm</title>
        <link rel="shortcut icon" href="Ressources/logo2.png" >

        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!-- LEAFLET LIBRARY -->
        <script src="leaflet/leaflet-src.js"></script>
        <script src="leaflet/leaflet.js"></script>
        <link rel="stylesheet" type="text/css" media="screen" href="leaflet/leaflet.css">

        <!-- CHAINES DE CARACTERES -->
        <script src="Scripts/language.js"></script>
        <script src="Scripts/strings.js"></script>

        <!-- STYLES -->
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/navigation.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/global_map.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/button.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/modal_error.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/modal_form.css">

        <!-- MAP -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
        <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
        <script src="Scripts/position_tracker.js"></script>
        <script src="Scripts/load_map.js"></script>

        <!-- SCRIPTS -->
        <script src="Scripts/update_connexion.js"></script>
        <script src="Scripts/global_map.js"></script>
         <script src="Scripts/deconnect.js"></script>

    </head>
    <body onload="load();">

        <!-- CHARGEMENT DES DONNEES -->
        <input type="hidden" id="name" value="<c:out value="${nom}"/>"/> 
        <input type="hidden" id="firstname" value="<c:out value="${prenom}"/>"/> 
        <input type="hidden" id="email" value="<c:out value="${email}"/>"/> 
        <input type="hidden" id="idco" value="<c:out value="${idco}"/>"/> 

        <!-- NAVIGATION -->
        <nav class="navbar-default navbar " role="navigation">
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="navbar-left" ><a href="#" id="logo"><img src="Ressources/logo1.png" width="100px" ></a></li> <!-- LOGO-->
                    <li class="navbar-left onglet" ><a href="#" class=" onglet onglet_actif" id="global_map"></a></li>
                    <li class="navbar-left onglet" ><a href="#" class="onglet" id="route_map"></a></li>
                    <li class="navbar-right"><a href="#"><img id="connection" src="Ressources/connection.png" onMouseOver="this.src = 'Ressources/connection_over.png'" onMouseOut="this.src = 'Ressources/connection.png'" width="25px" onclick=""></a></li><!-- Connexion-->
                    <li class="navbar-right" style="margin-right:20px; border-left: solid white 1px; padding-left:6px;">
                        <p class="info_perso" style="margin-top:10px;font-weight:bold;"><c:out value="${nom}"/> <c:out value="${prenom}"/></p>
                        <p class="info_perso"><c:out value="${email}"/></p>
                        <a id="modification_link" href="#" onclick=""></a>
                    </li>
                    <li class="navbar-right">
                        <a href="#" onclick="deconnect();" onmouseover="favoriteOver();" onmouseout="favoriteOut();" style="padding-right:6px;padding-top:9px;">
                             <img id="star" style="padding-bottom:4px;" src="Ressources/star.png" width="30px" >
                             <p id="favorite_link"></p>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>


        <!-- CONTENU PRINCIPAL -->
        <div class="container">    
            <!-- Map -->
            <div id="mapid" class="col-md-8"> </div>
        </div>
    </div>
</body>
</html>
