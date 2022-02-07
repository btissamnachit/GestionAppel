package miage.gestionappel.metier;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Presenter")
public class Presenter {

    @EmbeddedId
    private prensenterId idPresence;

    @ManyToOne
    @MapsId("idOc")
    private Occurence occurence;

    @ManyToOne
    @MapsId("idE")
    private Etudiant etudiant;

    @ManyToOne
    @MapsId("idJ")
    private Justificatif justificatif;

    private String statut;

    @Embeddable
    public static class prensenterId implements Serializable {
        private Integer idOc;
        private Integer idE;
        private Integer idJ;

    }

    public prensenterId getIdPresence() {
        return idPresence;
    }

    public void setIdPresence(prensenterId idPresence) {
        this.idPresence = idPresence;
    }

    public Occurence getOccurence() {
        return occurence;
    }

    public void setOccurence(Occurence occurence) {
        this.occurence = occurence;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Justificatif getJustificatif() {
        return justificatif;
    }

    public void setJustificatif(Justificatif justificatif) {
        this.justificatif = justificatif;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Presenter(Occurence occurence, Etudiant etudiant, Justificatif justificatif, String statut) {
        this.occurence = occurence;
        this.etudiant = etudiant;
        this.justificatif = justificatif;
        this.statut = statut;
    }
    public Presenter(){

    }
}

