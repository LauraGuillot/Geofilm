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
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/modal_error.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/modal_form.css">

        <!-- MAP -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
        <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
        <script src="Scripts/position_tracker.js"></script>
        <script src="Scripts/load_map.js"></script>

        <!-- SCRIPTS -->
        <script src="Scripts/home.js"></script>
        <script src="Scripts/connect.js"></script>
        

        <!--CONNECTION-->
        <script src="Scripts/connect.js"></script>
        <script src="Scripts/update_connexion.js"></script>

    </head>

    <body onload="load();">

        <!-- Chargement des markers en caché -->
        <input type="hidden" id="nbMarkers" value="<c:out value="${fn:length(markers)}"/>"/> 
        <c:forEach var="p" items="${markers}" varStatus="status">
            <input type="hidden" id="p<c:out value="${status.index}"/>" value="<c:out value="${p['locationThegeom']}"/>"/>
        </c:forEach>

        <!-- NAVIGATION -->
    <nav class="navbar-default navbar " role="navigation">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="navbar-left" ><a href="#" id="logo"><img src="Ressources/logo1.png" width="100px" ></a></li> <!-- LOGO-->
                <li class="navbar-right"><a href="#"><img id="connection" src="Ressources/connection.png" onMouseOver="this.src = 'Ressources/connection_over.png'" onMouseOut="this.src = 'Ressources/connection.png'" width="25px"></a></li><!-- Connexion-->
            </ul>
        </div>
    </nav>

    <!-- CONTENU PRINCIPAL -->
    <div class="container">    
        <div  class="row content">          
            <!-- Volet de gauche -->
            <div id="left_div" class="col-md-4">
                <p id="welcome"> </p>
                <p id="title"> Geofilm </p>
                <br><br><br>
                <p class="description" id="description"> </p>
                <p class="description" id="description2"> </p>
                <br><br><br><br>
                <center> <button href="#" class="button large_button" id="connexion"></button></center>
                 <br><br><br><br>
                 <p id="info_gps" style="font-style:italic;color:#87c2c4;"> </p>
            </div>
            <!-- Map -->
            <div id="mapid" class="col-md-8"> </div>
        </div>
    </div>

    <!--POPUP : boîte de connexion-->
    <div class="modal fade" id="connection_form" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">

                <p id="connexion2" style="color:rgb(131,179,183)"</p> 
                <p id="error_connect"></p>
                <hr>
                <div class="modal-body">         
                    <p id="connection_id"></p>
                    <input style="text-align:left" type="text" name ="id">
                    <br>
                    <p  id="connection_password"></p>
                    <input style="text-align:left" type="text" name="password">
                    <br>
                    <p id="password_forgotten"></p><p id="click_here" a href=""></p>
                </div>
                <div class="modal-footer">
                    <center>  <button id ="valider" type="button" class="button small_button" onclick="connect()"></button></center>
                </div>
                <p id="membership"></p><p id="click_here2" a href=""></p>
            </div>
        </div>
    </div>

    <!-- POPUP : message d'erreur si pas de gps -->
    <div class="modal fade" id="gps_error_modal" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-body">
                    <p id="error_gps"></p>
                </div>
                <div class="modal-footer">
                    <center>  <button id ="close_error_gps" type="button" class="button small_button" data-dismiss="modal"></button></center>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
