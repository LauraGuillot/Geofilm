//Carte
var mymap;

/**
 * Chargement de la carte avec tous les marqueurs
 */
function loadMap() {

    //Affichage de la carte, centrée sur Paris
    mymap = L.map('mapid').setView([48.862725, 2.287592000000018], 14);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox.streets',
        accessToken: 'pk.eyJ1IjoiZ2VvZmlsbSIsImEiOiJjaXlqd2d1NGUwMDA5MnFrMXUyaHdtYmt5In0.zaWf5uM65g8RiAj9LACvHw'
    }).addTo(mymap);

    //Affichage des marqueurs pour les multimédias
    displayMarkers();

    //Obtention (si possible) de la position de l'utilisateur
    getLocation();

    // Affichage de la position de l'utilisateur
    displayPosition();

    //Début du tracking de la position de l'utilisateur
    startTracker();
}

/**
 * Affichage des marqueurs pour les multimédias
 */
function displayMarkers() {
    var cpt = document.getElementById("nbMarkers").value;

    for (var i = 0; i < cpt; i++) {
        var point = document.getElementById("p" + i).value;

        point = point.substring(6, point.length - 1);
        var pt = point.split(",");
        var x = pt[0];
        var y = pt[1];
        var marker = L.marker([x, y], {icon: redIcon}).addTo(mymap);

        preparePopUp(marker, i);
    }
}

/**
 * Pour chaque marqueur préparation de la pop-up
 * @param {type} marker
 * @param {type} i
 * @returns {undefined}
 */
function preparePopUp(marker, i) {

    //Mise en place du header
    var html = header(i);

    //Pour chaque multimédia, on ajoute un lien
    html += "<div id=\"multis_" + i + "\">"
    var cpt = document.getElementById("nbMulti" + i).value;
    for (var j = 0; j < cpt; j++) {
        var li = getLinkMulti(i, j);
        html = html + li;
    }
    html += "</div>";
    marker.bindPopup(html);
}

/**
 * Préparation d'un lien pour chaque multimédia
 * @param {type} i
 * @param {type} j
 * @returns {String}
 */
function getLinkMulti(i, j) {
    var html = "";

    var title = document.getElementById("pos" + i + "_multi" + j + "_title").value;
    var id = document.getElementById("pos" + i + "_multi" + j + "_id").value;
    var publisher = document.getElementById("pos" + i + "_multi" + j + "_publisher").value;
    var date = document.getElementById("pos" + i + "_multi" + j + "_uploaddate").value;
    var type = document.getElementById("pos" + i + "_multi" + j + "_type").value;

    html += "<a class=\"link_marker\"  onclick=\"openMult("+id+","+i+","+j+")\">";
    html += "<div class=\"p_group\"><p class=\"link_title\">";
    html += title;
    html += "</p>";
    html += "<p class=\"link_info\">";
    html += by_fr + publisher + the_fr + date;
    html += "</p></div>";
    html += "</a>";

    return html;
}

/**
 * Création du header pour les pop-up
 * @returns {String}
 */
function header(i) {
    var html = "";

    html += "<p class=\"text\">" + sort_by_fr + "</p>";

    html += "<div class=\"checkbox_pop\">";
    html += "<label><input id=\"title_" + i + "\" class=\"checkbox_marker\" type=\"checkbox\" name=\"title\" value=\"title\" onclick=\"sort("+i+")\">";
    html += title_fr + "</label>";
    html += "</div>";

    html += "<div class=\"checkbox_pop\">";
    html += "<label><input id=\"date_" + i + "\" class=\"checkbox_marker\" type=\"checkbox\" name=\"date\" value=\"date\" onclick=\"sort("+i+")\">";
    html += date_fr + "</label>";
    html += "</div>";

    html += "<div class=\"checkbox_pop\">";
    html += "<label><input id=\"likes_" + i + "\" class=\"checkbox_marker\" type=\"checkbox\" name=\"likes\" value=\"likes\" onclick=\"sort("+i+")\">";
    html += likes_fr + "</label>";
    html += "</div>";

    html += "<br><p class=\"text\">" + source_type_fr + "</p>";

    html += "<div class=\"checkbox_pop\">";
    html += "<label><input  id=\"video_" + i + "\" class=\"checkbox_marker\" type=\"checkbox\" name=\"video\" value=\"video\" onclick=\"sort("+i+")\" checked>";
    html += video_fr + "</label>";
    html += "</div>";

    html += "<div class=\"checkbox_pop\">";
    html += "<label><input id=\"image_" + i + "\" class=\"checkbox_marker\" type=\"checkbox\" name=\"image\" value=\"image\" onclick=\"sort("+i+")\" checked>";
    html += image_fr + "</label>";
    html += "</div>";

    html += "<div class=\"checkbox_pop\">";
    html += "<label><input id=\"sound_" + i + "\" class=\"checkbox_marker\" type=\"checkbox\" name=\"sound\" value=\"sound\" onclick=\"sort("+i+")\"checked>";
    html += sound_fr + "</label>";
    html += "</div>";
    
    html += "<br><div class=\"checkbox_pop\">";
    html += "<label><input id=\"badloc_" + i + "\" class=\"checkbox_marker\" type=\"checkbox\" name=\"badloc\" value=\"badloc\" onclick=\"sort("+i+")\">";
    html += remove_bad_location_fr + "</label>";
    html += "</div>";

    html += "<HR align=center size=5 width=\"90%\">";

    return html;
}


