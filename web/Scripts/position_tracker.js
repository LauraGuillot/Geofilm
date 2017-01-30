var lat = 48.862725;
var long = 2.287592000000018;
var prec;

//Obtention de la position
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(recordPosition);
    } else {
        //Afficher message d'erreur 
        //TODO
    }
}

function recordPosition(position) {
    lat = position.coords.latitude;
    long = position.coords.longitude;
}

//Suivi de la position
function displayPosition(){
    if(prec!=null){
    mymap.removeLayer(prec);
    }
    mymap.panTo(new L.LatLng(lat, long));
    prec = L.marker([lat, long]).addTo(mymap);
}

function trackPosition(position) {
    recordPosition(position);
    displayPosition();
}

function startTracker(){
    navigator.geolocation.watchPosition(trackPosition);
}

function removeAllMarkers(){
   
}

