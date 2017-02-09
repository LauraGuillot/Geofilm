//Carte
var map;

/**
 * Chargement de la carte avec tous les marqueurs
 */
function loadMap() {
    mapboxgl.accessToken = 'pk.eyJ1IjoiZ2VvZmlsbSIsImEiOiJjaXlqd2d1NGUwMDA5MnFrMXUyaHdtYmt5In0.zaWf5uM65g8RiAj9LACvHw';
    map = new mapboxgl.Map({
        container: 'mapid',
        style: 'mapbox://styles/mapbox/streets-v9',
        center: [2.287592000000018, 48.862725],
        zoom: 13
    });

    map.addControl(new MapboxGeocoder({
        accessToken: mapboxgl.accessToken
    }));

    // Zoom 
    map.addControl(new mapboxgl.NavigationControl());

    //Obtention (si possible) de la position de l'utilisateur
    getLocation();

    // Affichage de la position de l'utilisateur
    displayPosition();

    //Début du tracking de la position de l'utilisateur
    startTracker();
}





