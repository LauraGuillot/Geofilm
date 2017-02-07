/**
 * Tri des multimédias pour la pop-up i suivant les préférences de l'utilisateur
 * @param {type} i Indice de la pop-up
 */
function sort(i) {

    var multis = [];

    //On récupère tous les multimédias de la position i
    var cpt = document.getElementById("nbMulti" + i).value;
    for (var j = 0; j < cpt; j++) {
        var title = document.getElementById("pos" + i + "_multi" + j + "_title").value;
        var id = document.getElementById("pos" + i + "_multi" + j + "_id").value;
        var publisher = document.getElementById("pos" + i + "_multi" + j + "_publisher").value;
        var date = document.getElementById("pos" + i + "_multi" + j + "_uploaddate").value;
        var type = document.getElementById("pos" + i + "_multi" + j + "_type").value;
        var likes = document.getElementById("pos" + i + "_multi" + j + "_like").value;
        var badloc = document.getElementById("pos" + i + "_multi" + j + "_badloc").value;

        var m = new Object();
        m.title = title;
        m.id = id;
        m.publisher = publisher;
        m.date = date;
        m.type = type;
        m.likes = likes;
        m.badloc = badloc;

        multis.push(m);
    }

    // Tri par type de multimédia
    var video = document.getElementById("video_" + i).checked;
    var image = document.getElementById("image_" + i).checked;
    var sound = document.getElementById("sound_" + i).checked;

    var todelete = [];

    for (var j = 0; j < multis.length; j++) {

        if (multis[j].type === "VIDEO" && !video) {
            todelete.push(j);
        }
        if (multis[j].type === "IMAGE" && !image) {
            todelete.push(j);
        }
        if (multis[j].type === "SOUND" && !sound) {
            todelete.push(j);
        }
    }

    for (var k = 0; k < todelete.length; k++) {
        multis.splice(todelete[k], 1);

        for (var l = 0; l < todelete.length; l++) {
            todelete[l] = todelete[l] - 1;
        }
    }

    //Tri selon les titres
    var title_sort = document.getElementById("title_" + i).checked;
    if (title_sort) {
        multis.sort(function (a, b) {
            return a.title > b.title;
        });
    }


    //Tri selon la date
    var date_sort = document.getElementById("date_" + i).checked;
    if (date_sort) {
        // dateSort(multis);
        multis.sort(function (a, b) {
            var aa = a.date.split("/");
            var bb = b.date.split("/");

            var annee1 = aa[0];
            var mois1 = aa[1];
            var jour1 = aa[2];
            var annee2 = bb[0];
            var mois2 = bb[1];
            var jour2 = bb[2];

            var dateA = new Date(annee1, mois1, jour1);
            var dateB = new Date(annee2, mois2, jour2)
            return dateA < dateB;
        });
    }

    //Tri selon les likes
    var likes_sort = document.getElementById("likes_" + i).checked;
    if (likes_sort) {
        multis.sort(function (a, b) {
            return a.likes > b.likes;
        });
    }

    //Suppression des mauvaises géolocalisations
    var badloc_sort = document.getElementById("badloc_" + i).checked;

    if (badloc_sort) {
        var todelete1 = [];
        for (var j = 0; j < multis.length; j++) {
            if (multis[j].badloc > 0) {
                todelete1.push(j);
            }
        }

        for (var k = 0; k < todelete1.length; k++) {
            multis.splice(todelete1[k], 1);
            for (var l = 0; l < todelete1.length; l++) {
                todelete1[l] = todelete1[l] - 1;
            }
        }
    }

    //Affichage de la liste triée
    displayMultis(i, multis);

}


/**
 * Affichage de la liste des multimédias dans la pop-up
 * @param {type} i Indice de la pop-up (marqueur)
 * @param {type} multis Liste des multimédia
 */
function displayMultis(i, multis) {

    //On supprime la liste actuelle
    var div = document.getElementById("multis_" + i);
    div.innerHTML = "";

    //On affiche la nouvelle liste
    for (var j = 0; j < multis.length; j++) {

        var a = document.createElement('a');
        a.className = "link_marker";
        a.addEventListener("click", openMult(multis[j].id, i, j), false);

        var p_group = document.createElement("div");
        p_group.className = "p_group";

        var p1 = document.createElement("p");
        p1.className = "link_title";
        p1.innerHTML = multis[j].title;

        var p2 = document.createElement("p");
        p2.className = "link_info";
        p2.innerHTML = by_fr + multis[j].publisher + the_fr + multis[j].date;

        p_group.appendChild(p1);
        p_group.appendChild(p2);
        a.appendChild(p_group);
        div.appendChild(a);
    }
}

/**
 * Comparaison de deux multimedias selon la date d'upload
 * @param {type} a Multimédia 1
 * @param {type} b Multimédia 2
 * @returns {Boolean} Vrais si a est plus récent que b
 */
function compareDate(a, b) {
    var aa = a.date.split("/");
    var bb = b.date.split("/");

    var annee1 = aa[0];
    var mois1 = aa[1];
    var jour1 = aa[2];
    var annee2 = bb[0];
    var mois2 = bb[1];
    var jour2 = bb[2];

    return (annee1 > annee2) || (annee1 == annee2 && mois1 > mois2) || (annee1 == annee2 && mois1 == mois2 && jour1 > jour2);
}

/**
 * Tri des multimédias par date d'upload
 * @param {type} multis tableau de mutimédias
 */
function dateSort(multis) {

}

