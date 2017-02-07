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

        <!--MAP BOX -->
        <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.32.1/mapbox-gl.js'></script>
        <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.32.1/mapbox-gl.css' rel='stylesheet' />
        <script src='https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-geocoder/v2.0.1/mapbox-gl-geocoder.js'></script>
        <link rel='stylesheet' href='https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-geocoder/v2.0.1/mapbox-gl-geocoder.css' type='text/css' />

        <!-- CHAINES DE CARACTERES -->
        <script src="Scripts/language.js"></script>
        <script src="Scripts/strings.js"></script>

        <!-- STYLES -->
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/navigation.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/global_map.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/button.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/modal_error.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/modal_form.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/font.css">
        <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/pop_up_marker.css">
         <link rel="stylesheet" type="text/css" media="screen" href="Stylesheets/marker.css">

        <!-- MAP -->
        <script src="Scripts/mapbox_tracker.js"></script>
        <script src="Scripts/load_map_2.js"></script>

        <!-- SCRIPTS -->
        <script src="Scripts/update_connexion.js"></script>
        <script src="Scripts/global_map.js"></script>
        <script src="Scripts/deconnect.js"></script>
        <script src="Scripts/modif_infos_perso.js"></script>
        <script src="Scripts/sort.js"></script>
        <script src="Scripts/play_multimedia.js"></script>

    </head>
    <body onload="load();">

        <!-- CHARGEMENT DES DONNEES -->

        <!-- Données personnelles-->
        <input type="hidden" id="name" value="<c:out value="${nom}"/>"/> 
        <input type="hidden" id="firstname" value="<c:out value="${prenom}"/>"/> 
        <input type="hidden" id="email" value="<c:out value="${email}"/>"/> 
        <input type="hidden" id="idco" value="<c:out value="${idco}"/>"/> 

        <!-- Markers (positions) -->
        <input type="hidden" id="nbMarkers" value="<c:out value="${fn:length(markers)}"/>"/> 
        <c:forEach var="p" items="${markers}" varStatus="status">
            <input type="hidden" id="p<c:out value="${status.index}"/>" value="<c:out value="${p['locationThegeom']}"/>"/>
        </c:forEach>

        <!--Multimedias-->
        <c:forEach var="mu" items="${multis}" varStatus="status">
            <input type="hidden" id="nbMulti<c:out value="${status.index}"/>" value="<c:out value="${fn:length(mu)}"/>"/> 
            <c:forEach var="m" items="${mu}" varStatus="status1">
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_id"/>" value="<c:out value="${m['multimediaId']}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_title"/>" value="<c:out value="${m['multimediaTitle']}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_publisher"/>" value="<c:out value="${m['publisher']['personFirstname']}"/> <c:out value="${m['publisher']['personName']}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_descr"/>" value="<c:out value="${m['multimediaDescription']}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_path"/>" value="<c:out value="${m['multimediaPath']}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_uploaddate"/>" value="<c:out value="${m['multimediaUploadDate']}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_format"/>" value="<c:out value="${m['multimediaFormat']}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_type"/>" value="<c:out value="${m['multimediaType']}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_like"/>" value="<c:out value="${likes[status.index][status1.index]}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_dislike"/>" value="<c:out value="${dislikes[status.index][status1.index]}"/>"/>
                <input type="hidden" id="pos<c:out value="${status.index}"/>_multi<c:out value="${status1.index}_badloc"/>" value="<c:out value="${badloc[status.index][status1.index]}"/>"/>
            </c:forEach>
        </c:forEach>

        <!-- NAVIGATION -->
        <nav class="navbar-default navbar " role="navigation">
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="navbar-left" ><a href="#" id="logo"><img src="Ressources/logo1.png" width="100px" ></a></li> <!-- LOGO-->
                    <li class="navbar-left onglet" ><a href="#" class=" onglet onglet_actif" id="global_map"></a></li>
                    <li class="navbar-left onglet" ><a href="#" class="onglet" id="route_map"></a></li>
                    <li class="navbar-right"><a href="#"><img id="connection" src="Ressources/connection.png" onMouseOver="this.src = 'Ressources/connection_over.png'" onMouseOut="this.src = 'Ressources/connection.png'" width="25px" onclick="deconnect();"></a></li><!-- Connexion-->
                    <li class="navbar-right" style="margin-right:20px; border-left: solid white 1px; padding-left:6px;">
                        <p class="info_perso" id="info_name" style="margin-top:10px;font-weight:bold;"><c:out value="${prenom}"/> <c:out value="${nom}"/></p>
                        <p class="info_perso"id="info_email" ><c:out value="${email}"/></p>
                        <a id="modification_link" href="#" onclick="pop_info();"></a>
                    </li>
                    <li class="navbar-right">
                        <a href="#" onclick="" onmouseover="favoriteOver();" onmouseout="favoriteOut();" style="padding-right:6px;padding-top:9px;">
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

        <!--POPUP : modification des informations personnelles-->
        <div class="modal fade" id="modification_form" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content modal_form">

                    <button class="close" data-dismiss="modal">&times;</button>

                    <center><p id="modification_title" class= "title"  style="margin-top: 40px"</p> </center>
                    <p id="modification_error" class="error_message"></p>

                    <div class="modal-body">         
                        <p class="label_form" id="name_label"></p>
                        <input type="text" name ="name" id="name_input">               
                        <p  class="label_form" id="firstname_label"></p>
                        <input  type="text" name="firstname" id="firstname_input">
                        <p  class="label_form" id="email_label"></p>
                        <input  type="text" name="email" id="email_input">
                        <center><button id ="valid_modif" type="button" class="button small_button" onclick="modif();"></button></center>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
