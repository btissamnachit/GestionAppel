package miage.gestionappel.metier;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Scolarite")
public class Scolarite {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdS")
    private int idS;

    @Column(name = "LibelleS")
    private String libelleS;

    @OneToMany(mappedBy = "scolarite", fetch = FetchType.EAGER)
    private Set<Cours> cours = new HashSet(0);

    public Scolarite() {
    }

    public Scolarite(int idS, String libelleS, Set<Cours> cours) {
        this.idS = idS;
        this.libelleS = libelleS;
        this.cours = cours;
    }

    public Scolarite(String libelleS, Set<Cours> cours) {
        this.libelleS = libelleS;
        this.cours = cours;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getLibelleS() {
        return libelleS;
    }

    public void setLibelleS(String libelleS) {
        this.libelleS = libelleS;
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
        Scolarite scolarite = (Scolarite) o;
        return idS == scolarite.idS;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idS);
    }

    @Override
    public String toString() {
        return "Scolarite{" +
                "idS=" + idS +
                ", libelleS='" + libelleS + '\'' +
                '}';
    }
}
