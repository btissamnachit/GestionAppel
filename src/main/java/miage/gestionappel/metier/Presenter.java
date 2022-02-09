package miage.gestionappel.metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name="Presenter")
public class Presenter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private PrensenterId idPresence;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idOc")
    private Occurence occurence;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idE")
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.EAGER)
    private Justificatif justificatif;

    private String statut;

    public Presenter() {
    }

    public Presenter(PrensenterId idPresence, Occurence occurence, Etudiant etudiant, String statut) {
        this.idPresence = idPresence;
        this.occurence = occurence;
        this.etudiant = etudiant;
        this.statut = statut;
    }

    public Presenter(Occurence occurence, Etudiant etudiant, String statut) {
        this.occurence = occurence;
        this.etudiant = etudiant;
        this.statut = statut;
    }

    public PrensenterId getIdPresence() {
        return idPresence;
    }

    public void setIdPresence(PrensenterId idPresence) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Presenter presenter = (Presenter) o;
        return Objects.equals(idPresence, presenter.idPresence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPresence);
    }
}

