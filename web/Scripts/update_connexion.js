
/**
 * Fonction pour envoyer une demande de mise à jour d'une connexion
 * @param {type} idco Identifiant de la connexion à mettre à jour
 * @returns {undefined}
 */
function askForUpdate(idco) {
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
        }
    };
    var data = "idco=" + idco;
    xhttp.open("GET", "UpdateConnexionServlet?" + data, true);
    xhttp.setRequestHeader("Content-Type", "text/html; charset=UTF-8");
    xhttp.send();
}

