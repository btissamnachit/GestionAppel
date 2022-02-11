package miage.gestionappel.metier;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "Cours")
public class Cours {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdC")
    private int idC;

    @Column(name = "NomC")
    private String nomC;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Enseigner", joinColumns = @JoinColumn(name = "IdC"), inverseJoinColumns = @JoinColumn(name = "IdP"))
    private Set<Professeur> professeurs = new HashSet<>();

    @OneToMany(mappedBy = "cours",fetch = FetchType.EAGER)
    private Set<Occurence> occurences = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdS")
    private Scolarite scolarite;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Inscrire", joinColumns = @JoinColumn(name = "IdC"), inverseJoinColumns = @JoinColumn(name = "IdG"))
    private Set<Groupe> groupes = new HashSet<>();

    public Cours() {
    }

    public Cours(String nomC, Set<Professeur> professeurs, Set<Occurence> occurences, Scolarite scolarite, Set<Groupe> groupes) {
        this.nomC = nomC;
        this.professeurs = professeurs;
        this.occurences = occurences;
        this.scolarite = scolarite;
        this.groupes = groupes;
    }

    public Cours(String nomC, Scolarite scolarite) {
        this.idC = idC;
        this.nomC = nomC;
        this.scolarite = scolarite;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public Set<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(Set<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    public Set<Occurence> getOccurences() {
        return occurences;
    }

    public Set<Occurence> getOccurencesValidees() {
        Set<Occurence> occurencesValidees = this.occurences.stream().filter(Occurence::getAppelValide).collect(Collectors.toSet());
        return occurencesValidees;
    }

    public void setOccurences(Set<Occurence> occurences) {
        this.occurences = occurences;
    }

    public Scolarite getScolarite() {
        return scolarite;
    }

    public void setScolarite(Scolarite scolarite) {
        this.scolarite = scolarite;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return idC == cours.idC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idC);
    }

    @Override
    public String toString() {
        return "Cours{" +
                "idC=" + idC +
                ", nomC='" + nomC + '\'' +
                ", groupes=" + groupes +
                '}';
    }
}
