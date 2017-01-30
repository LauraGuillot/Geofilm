function load(){
    loadMap();
    loadText();
}

function loadText(){
    if(language=="fr"){
        document.getElementById("welcome").innerHTML=welcome_fr;
        document.getElementById("description").innerHTML=welcome_description_fr;
        document.getElementById("description2").innerHTML=welcome_description_fr2;
        document.getElementById("connexion").innerHTML=connexion_fr;
    }
}
