function load() {
    loadText();
    loadMap();
}


function loadText() {
    if (language == "fr") {
        document.getElementById("star").innerHTML = star_fr;
       
        //UPLOAD GENERAL INFORMATION
        document.getElementById("upload_multimedia").innerHTML = upload_title_fr;
        document.getElementById("upload_general_information").innerHTML = upload_subtitle1_fr;
        document.getElementById("upload_type_multimedia").innerHTML = upload_type_fr;
        document.getElementById("upload_video").innerHTML = upload_video_fr;
        document.getElementById("upload_sound").innerHTML = upload_sound_fr;
        document.getElementById("upload_image").innerHTML = upload_image_fr;
        document.getElementById("upload_title_multimedia").innerHTML = title_fr;
        document.getElementById("upload_description").innerHTML = upload_description_fr;
        document.getElementById("upload_source").innerHTML = upload_source_fr;
        document.getElementById("upload_source_search").innerHTML = upload_source_search_fr;
        document.getElementById("upload_source_unknown").innerHTML = upload_source_unknown_fr;
        document.getElementById("upload_source_title").innerHTML = upload_source_title_fr;
        document.getElementById("upload_film").innerHTML = upload_source_movie_fr;
        document.getElementById("upload_serie").innerHTML = upload_source_serie_fr;
        document.getElementById("upload_game").innerHTML = upload_source_game_fr;

    }
}


