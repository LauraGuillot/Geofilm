/**
 * Accès à la page d'upload
 * @param {type} idco
 * @returns {undefined}
 */
function open_upload(idco) {

    askForUpdate(idco);

    var form = document.createElement('form');
    form.method = "POST";
    form.action = "uploading.htm";

    document.body.appendChild(form);
    form.submit();

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