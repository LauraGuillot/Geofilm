var mymap;

function loadMap() {
    mymap = L.map('mapid').setView([48.862725, 2.287592000000018], 12);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox.streets',
        accessToken: 'pk.eyJ1IjoiZ2VvZmlsbSIsImEiOiJjaXlqd2d1NGUwMDA5MnFrMXUyaHdtYmt5In0.zaWf5uM65g8RiAj9LACvHw'
    }).addTo(mymap);

    displayMarkers();

    getLocation();
    displayPosition();
    startTracker();
}

function displayMarkers() {

    var cpt = document.getElementById("nbMarkers").value;

    for (var i = 0; i < cpt; i++) {
        var point = document.getElementById("p" + i).value;

        point = point.substring(6, point.length - 1);
        var pt = point.split(",");
        var x = pt[0];
        var y = pt[1];
        
        L.marker([x, y]).addTo(mymap);
    }
}
