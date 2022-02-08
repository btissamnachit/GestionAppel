package miage.gestionappel.metier;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Groupe")
public class Groupe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdG")
    private int idG;

    @ManyToMany(mappedBy = "groupes", fetch = FetchType.EAGER)
    private Set<Occurence> occurences = new HashSet<>();

    @ManyToMany(mappedBy = "groupes", fetch = FetchType.EAGER)
    private Set<Cours> cours = new HashSet<>();

    @ManyToMany(mappedBy = "groupes", fetch = FetchType.EAGER)
    private Set<Etudiant> etudiants = new HashSet<>();

    public Groupe() {
    }

    public Groupe(int idG, Set<Occurence> occurences, Set<Cours> cours, Set<Etudiant> etudiants) {
        this.idG = idG;
        this.occurences = occurences;
        this.cours = cours;
        this.etudiants = etudiants;
    }

    public Groupe(Set<Occurence> occurences, Set<Cours> cours, Set<Etudiant> etudiants) {
        this.occurences = occurences;
        this.cours = cours;
        this.etudiants = etudiants;
    }

    public int getIdG() {
        return idG;
    }

    public void setIdG(int idG) {
        this.idG = idG;
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

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groupe groupe = (Groupe) o;
        return idG == groupe.idG;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idG);
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "idG=" + idG +
                '}';
    }
}
