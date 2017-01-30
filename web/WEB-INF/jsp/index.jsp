<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/home.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/button.css">

        <!-- MAP -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
        <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
        <script src="Scripts/position_tracker.js"></script>
        <script src="Scripts/home_map.js"></script>

        <!-- SCRIPTS -->
        <script src="Scripts/home.js"></script>

    </head>

    <body onload="load();">

        <!-- Chargement des markers en caché -->
        <input type="hidden" id="nbMarkers" value="<c:out value="${fn:length(markers)}"/>"/> 
        <c:forEach var="p" items="${markers}" varStatus="status">
            <input type="hidden" id="p<c:out value="${status.index}"/>" value="<c:out value="${p['locationThegeom']}"/>"/>
        </c:forEach>

        <!-- Barre de navigation -->
    <nav class="navbar-default navbar " role="navigation">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="navbar-left" ><a href="#" id="logo"><img src="Ressources/logo1.png" width="100px" ></a></li> <!-- LOGO-->
                <li class="navbar-right"><a href="#"><img id="connection" src="Ressources/connection.png" onMouseOver="this.src = 'Ressources/connection_over.png'" onMouseOut="this.src = 'Ressources/connection.png'" width="25px"></a></li><!-- Connexion-->
            </ul>
        </div>
    </nav>

    <div class="container">    
        <div  class="row content">          
            <!-- Volet de gauche -->
            <div id="left_div" class="col-md-4">
                <p id="welcome" style="color:rgb(148,204,205) ;font-size:30px"> </p>
                <p id="title" style="color:rgb(4,175,182); font-size:30px"> Geofilm </p>
                <br>
                <p id="description" style="font-size:17px"> </p>
                <p id="description2" style="font-size:17px"> </p>
                <br>
                <br>

                <p><a href="https://github.com/" class="button1" style="color:black">Connexion</a></p>

            </div>

            <!-- Map -->
            <div id="mapid" class="col-md-8"> </div>
        </div>

    </div>
</body>
</html>
