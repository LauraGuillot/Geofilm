/**
 * Accès à la page d'upload
 */
function open_upload() {

    var form = document.createElement('form');
    form.method = "POST";
    form.action = "upload.htm";

    var c1 = document.createElement('input');
    c1.type = "hidden";
    c1.name = "idco";
    c1.value = document.getElementById("idco").value;
    form.appendChild(c1);


}
//TODO : saisie des données dans la base
//TODO : vérifier que le type de multimédia est entré (case)
//TODO : vérifier que la source est entrée


/**
 * Vérifier que le titre du multimédia n'est pas vide
 * @param {String} name
 * @returns {Boolean}
 */
function valid_titre(name) {
    if (name == "") {
        //Message d'erreur
        document.getElementById("inscription_error").innerHTML = error_name_fr;
        return false;
    } else {
        return true;
    }
}