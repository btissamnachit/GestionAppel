function enregistrerStatut() {
    let statut = this.value;
    let idEtudiant = this.previousElementSibling.value;
    alert(statut + idEtudiant);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/appelServlet", true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
    xhr.send("action=EnregistrerEtudiant&statutEtudiant="+statut+"&idEtudiant="+idEtudiant);

    xhr.onload = function () {

        if (xhr.status === 200){
            //this.insertAdjacentHTML('afterend', 'chergé!');
        }

    };

}


/**
 * Lancement après le chargement du DOM.
 */
document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll('.statutEtudiant').forEach(item => {

        item.addEventListener("change", enregistrerStatut);
    })
})
