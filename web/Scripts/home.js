function load(){
  
    loadText();
      loadMap();
}

function loadText(){
    if(language=="fr"){
        document.getElementById("welcome").innerHTML=welcome_fr;
        document.getElementById("description").innerHTML=welcome_description_fr;
        document.getElementById("description2").innerHTML=welcome_description2_fr;
        document.getElementById("connexion").innerHTML=connection_fr;
        document.getElementById("error_gps").innerHTML=error_gps_fr;
        document.getElementById("close_error_gps").innerHTML=close_fr;
        document.getElementById("info_gps").innerHTML=info_gps_fr;
    }
}
