var lat = 48.862725;
var long = 2.287592000000018;
var prec; //Précédente position enregistrée

//Définition des marqueurs
var blueIcon = L.icon({
    iconUrl: 'Ressources/marker_blue.png',
    shadowUrl: 'Ressources/marker_shadow.png',
    iconSize: [24, 35], // size of the icon
    shadowSize: [24, 24], // size of the shadow
    iconAnchor: [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62], // the same for the shadow
    popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
});
var redIcon = L.icon({
    iconUrl: 'Ressources/marker_red.png',
    shadowUrl: 'Ressources/marker_shadow.png',
    iconSize: [24, 35], // size of the icon
    shadowSize: [24, 24], // size of the shadow
    iconAnchor: [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [4, 62], // the same for the shadow
    popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
});

//Obtention de la position
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(recordPosition);
    } else {
        //Afficher message d'erreur 
        console.log("error");
        $('#gps_error_modal').modal('show');
    }
}

function recordPosition(position) {
    lat = position.coords.latitude;
    long = position.coords.longitude;
}

//Suivi de la position
function displayPosition() {
    if (prec != null) {
        mymap.removeLayer(prec);
    }

    mymap.panTo(new L.LatLng(lat, long));


    if (!(lat == 48.862725 && long == 2.287592000000018)) {
        prec = L.marker([lat, long], {icon: blueIcon}).addTo(mymap);
    }

}


function trackPosition(position) {
    recordPosition(position);
    displayPosition();
}

function startTracker() {
    navigator.geolocation.watchPosition(trackPosition);
}

function removeAllMarkers() {

}

