function getTimeTable() {

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "calendarServlet");
    const semaine = ["Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"]

    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onload = function () {
        // Si la requête http s'est bien passée.

        if (xhr.status === 200) {
            var noeudJours = xhr.responseXML.getElementsByTagName("Calendar>")
            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("cd-schedule__events")
            var timeTable = "<ul>"
            for (let i = 0; i < noeudJours.length; i++) {
                timeTable += "<li id='cd-schedule__group' className='cd-schedule__group'> " +
                    "<div className='cd-schedule__top-info'><span> " + semaine[i] + "</span></div> <ul>"
                for (let j = 0; j < noeudJours[i].childNodes.length; i++) {
                    var cours = noeudJours[i].childNodes[j].nodeValue;
                }

                selectedList += "<li>" + citation + "</li>";
            }
            selectedList += "</ul>"
            elt.innerHTML = selectedList;

        }
    };

    // Envoie de la requête.
    xhr.send();
}

