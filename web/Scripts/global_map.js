function load() {
    loadText();

}


function loadText() {
    if (language == "fr") {
        //NAVIGATION
        document.getElementById("global_map").innerHTML=global_map_fr;
        document.getElementById("route_map").innerHTML=route_map_fr;
        document.getElementById("modification_link").innerHTML=modification_fr;
        document.getElementById("favorite_link").innerHTML=favorite_fr;
        
    }
}


function favoriteOver(){
    document.getElementById("favorite_link").style.color="#FFFF51";
    document.getElementById("star").src = "Ressources/star_over.png";
}

function favoriteOut(){
    document.getElementById("favorite_link").style.color="#fffe83";
    document.getElementById("star").src = "Ressources/star.png";
}

