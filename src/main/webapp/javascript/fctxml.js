function enregistrerStatut() {
    let statut = this.value;
    let idEtudiant = this.previousElementSibling.value;
    let divAlert = document.getElementById('alert');
    divAlert.innerHTML = "<div class=\"d-flex justify-content-center\"><img width='50' src=\"/image/load.svg\"></div>";

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/appelServlet", true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send("action=EnregistrerEtudiant&statut="+statut+"&idEtudiant="+idEtudiant);

    xhr.onload = function () {
        if (xhr.status === 200){
            divAlert.innerHTML = "";
        }
    };

}

function enregistrerStatutJust() {
    let statut = this.value;
    let idJustificatif = this.previousElementSibling.value;
    let divAlert = document.getElementById('alert');
    divAlert.innerHTML = "<div class=\"d-flex justify-content-center\"><img width='50' src=\"/image/load.svg\"></div>";

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/depotJustServlet", true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send("action=EnregistrerStatutJustificatif&statut="+statut+"&idJustificatif="+idJustificatif);

    xhr.onload = function () {
        if (xhr.status === 200){
            divAlert.innerHTML = "";
        }
    };

}

function listEtudiantCours() {
    let occurence = this.value;
    let tbody = document.getElementById("listEtudiant");
    tbody.innerHTML = " <td colspan=\"4\"><div class=\"text-sm-center\"><img width='100' src=\"/image/load.svg\"></div></td>"
    let tbodyInsert = "";
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/listeCoursServlet?action=listParCours&idOccurence="+occurence, true);
    xhr.overrideMimeType('application/xml');
    xhr.onload = function () {
        if (xhr.status === 200){
            let sug = xhr.responseXML.getElementsByTagName("etudiant");
            for (let i=0; i<sug.length;i++){
                let id = sug[i].getElementsByTagName ("id")[0].firstChild.nodeValue;
                let nom = sug[i].getElementsByTagName ("nom")[0].firstChild.nodeValue;
                let prenom = sug[i].getElementsByTagName ("prenom")[0].firstChild.nodeValue;
                let mail = sug[i].getElementsByTagName ("mail")[0].firstChild.nodeValue;
                let statut = sug[i].getElementsByTagName ("statut")[0].firstChild.nodeValue;

                let tr = "<tr><td>"+id+"</td><td>"+nom+"</td><td>"+prenom+"</td><td>"+mail+"</td><td>"+statut+"</td></tr>";

                tbodyInsert+=tr;
            }
            tbody.innerHTML =tbodyInsert;
        }
    };
    xhr.send();
}

function listOccurencesCours() {
    let cours = this.value;
    let selectOcc = document.getElementById("selectOccurences");
    let selectInsert = "<option>----</option>";
    let xhr = new XMLHttpRequest();
    xhr.overrideMimeType('application/xml');
    xhr.open("GET", "/listeCoursServlet?action=listOccurences&idCours="+cours, true);
    xhr.onload = function () {
        if (xhr.status === 200){
            console.log(xhr.responseText)
            let sug = xhr.responseXML.getElementsByTagName("occurrence");
            for (let i=0; i<sug.length;i++){
                let id = sug[i].getElementsByTagName ("id")[0].firstChild.nodeValue;
                let date = sug[i].getElementsByTagName ("date")[0].firstChild.nodeValue;
                let debut = sug[i].getElementsByTagName ("debut")[0].firstChild.nodeValue;
                let fin = sug[i].getElementsByTagName ("fin")[0].firstChild.nodeValue;
                let option = "<option value='"+id+"'>"+date+" [ de "+debut+" à "+fin+"</option>";

                selectInsert+=option;
            }
            selectOcc.innerHTML =selectInsert;
        }
    };
    xhr.send();
}


/**
 * Lancement après le chargement du DOM.
 */
document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll('.statutEtudiant').forEach(item => {

        item.addEventListener("change", enregistrerStatut);
    });

    document.querySelectorAll('.statutJustificatif').forEach(item => {

        item.addEventListener("change", enregistrerStatutJust);
    });

    document.getElementById("selectCours").addEventListener("change",listOccurencesCours);
    document.getElementById("selectOccurences").addEventListener("change",listEtudiantCours);
})
