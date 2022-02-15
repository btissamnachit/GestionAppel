package miage.gestionappel.metier;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Professeur")
public class Professeur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdP")
    private int idP;

    @Column(name = "NomP")
    private String nomP;

    @Column(name = "PrenomP")
    private String prenomP;

    @Column(name = "MailP")
    private String mailP;

    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Occurence> occurences = new HashSet<>();

    @ManyToMany(mappedBy = "professeurs", fetch = FetchType.LAZY)
    private Set<Cours> cours = new HashSet<>();

    public Professeur() {
    }

    public Professeur(int idP, String nomP, String prenomP, String mailP, Set<Occurence> occurences, Set<Cours> cours) {
        this.idP = idP;
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.mailP = mailP;
        this.occurences = occurences;
        this.cours = cours;
    }

    public Professeur(String nomP, String prenomP, String mailP) {
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.mailP = mailP;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public String getMailP() {
        return mailP;
    }

    public void setMailP(String mailP) {
        this.mailP = mailP;
    }

    public Set<Occurence> getOccurences() {
        return occurences;
    }

    public void setOccurences(Set<Occurence> occurences) {
        this.occurences = occurences;
    }

    public Set<Cours> getCours() {
        return cours;
    }

    public void setCours(Set<Cours> cours) {
        this.cours = cours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professeur that = (Professeur) o;
        return idP == that.idP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idP);
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "idP=" + idP +
                ", nomP='" + nomP + '\'' +
                ", prenomP='" + prenomP + '\'' +
                ", mailP='" + mailP + '\'' +
                '}';
    }
}
