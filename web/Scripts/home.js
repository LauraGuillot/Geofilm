function load() {

    loadText();
    loadMap();
}

function loadText() {
    if (language == "fr") {
        document.getElementById("welcome").innerHTML = welcome_fr;
        document.getElementById("description").innerHTML = welcome_description_fr;
        document.getElementById("description2").innerHTML = welcome_description2_fr;
        document.getElementById("connexion").innerHTML = connection_fr;
        document.getElementById("error_gps").innerHTML = error_gps_fr;
        document.getElementById("close_error_gps").innerHTML = close_fr;
        document.getElementById("connection_id").innerHTML = connection_email_fr;
        document.getElementById("connection_password").innerHTML = connection_password_fr;
        document.getElementById("password_forgotten").innerHTML = password_forgotten_fr;
        document.getElementById("membership").innerHTML = membership_fr;
        document.getElementById("connexion2").innerHTML = connection_fr;
        document.getElementById("valider").innerHTML = validation_fr;
        document.getElementById("click_here").innerHTML = click_here_fr;
        document.getElementById("click_here2").innerHTML = click_here_fr;


    }
}
