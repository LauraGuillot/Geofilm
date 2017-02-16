//Variable globale : tableau de favoris
var favorites = [];

/**
 * Initialisation des favoris
 * @returns {void}
 */
function initFavorite() {
//Initialisation du tableau
    var cpt = document.getElementById('nbFavorite').value;
    for (var i = 0; i < cpt; i++) {
        var title = document.getElementById("f" + i + "_title").value;
        var id = document.getElementById("f" + i + "_id").value;
        var descr = document.getElementById("f" + i + "_descr").value;
        var publisher = document.getElementById("f" + i + "_publisher").value;
        var date = document.getElementById("f" + i + "_uploaddate").value;
        var type = document.getElementById("f" + i + "_type").value;
        var path = document.getElementById("f" + i + "_path").value;
        var format = document.getElementById("f" + i + "_format").value;

        var m = new Object();
        m.title = title;
        m.id = id;
        m.publisher = publisher;
        m.date = date;
        m.type = type;
        m.descr = descr;
        m.format = format;
        m.path = path;
        m.rank = i;
        favorites.push(m);
    }

    //Affichage 
    displayFavorite();
}

/**
 * Affichage de la liste des favoris
 * @returns {void}
 */
function displayFavorite() {
    var div = document.getElementById("favorite");

    for (var i = 0; i < favorites.length; i++) {

        var a = document.createElement('a');
        a.className = "link_marker";
        var multi = favorites[i];
        a.addEventListener("click", delegate(multi.rank), false);

        var p_group = document.createElement("div");
        p_group.className = "p_group";

        var p1 = document.createElement("p");
        p1.className = "link_title";
        p1.innerHTML = favorites[i].title;

        var p2 = document.createElement("p");
        p2.className = "link_info";
        p2.innerHTML = by_fr + favorites[i].publisher + the_fr + favorites[i].date;

        p_group.appendChild(p1);
        p_group.appendChild(p2);
        a.appendChild(p_group);

        div.appendChild(a);
    }
}

/**
 * Fonction de délégation pour ouvrir un multimédia
 * @param {type} i Index de la position du multimédia
 * @returns {Function}
 */
function delegate(i) {
    return function () {
        openMult(i);
    }
}

/**
 * Ouverture du multimedia i
 * @param {int} i - Index du multimédia
 * @returns {void}
 */
function openMult(i){
    
}