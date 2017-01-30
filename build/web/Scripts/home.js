function load(){
    loadMap();
    loadText();
}

function loadText(){
    if(language=="fr"){
        document.getElementById("welcome").innerHTML=welcome_fr;
        document.getElementById("description").innerHTML=welcome_description_fr;
    }
}
