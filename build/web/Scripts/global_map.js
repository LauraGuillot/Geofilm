/**
 * Fonction de chargement appelée à l'ouverture de la carte principale:
 * chargement du texte et chargement de la carte
 */
function load() {
    loadText();
    loadMap();
}

/**
 * Chargement du texte dans la carte principale
 */
function loadText() {
    if (language == "fr") {

        //NAVIGATION
        document.getElementById("global_map").innerHTML = global_map_fr;
        document.getElementById("route_map").innerHTML = route_map_fr;
        document.getElementById("modification_link").innerHTML = modification_fr;
        document.getElementById("favorite_link").innerHTML = favorite_fr;

        //MODIFICATION DES INFORMATIONS PERSONNELLES
        document.getElementById("name_label").innerHTML = name_fr;
        document.getElementById("firstname_label").innerHTML = firstname_fr;
        document.getElementById("email_label").innerHTML = email_fr;
        document.getElementById("modification_title").innerHTML = modif_infos_fr;
        document.getElementById("valid_modif").innerHTML = validation_fr;

    }
}

/**
 * Fonction d'affichage dynamique
 * Changement du style au passage de la souris sur l'onglet favoris dans la barre de navigation
 */
function favoriteOver() {
    document.getElementById("favorite_link").style.color = "#FFFF51";
    document.getElementById("star").src = "Ressources/star_over.png";
}

/**
 * Fonction d'affichage dynamique
 * Changement du style lorsqu'on retire de la souris de l'onglet favoris dans la barre de navigation
 */
function favoriteOut() {
    document.getElementById("favorite_link").style.color = "#fffe83";
    document.getElementById("star").src = "Ressources/star.png";
}






	