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

    @Column(name = "MailS")
    private String mailS;

    @OneToMany(mappedBy = "scolarite", fetch = FetchType.LAZY)
    private Set<Cours> cours = new HashSet(0);

    public Scolarite() {
    }

    public Scolarite(int idS, String libelleS, String mailS, Set<Cours> cours) {
        this.idS = idS;
        this.libelleS = libelleS;
        this.mailS = mailS;
        this.cours = cours;
    }

    public Scolarite(String libelleS, String mailS, Set<Cours> cours) {
        this.libelleS = libelleS;
        this.mailS = mailS;
        this.cours = cours;
    }

    public Scolarite(String libelleS) {
        this.libelleS = libelleS;
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

    public String getMailS() {
        return mailS;
    }

    public void setMailS(String mailS) {
        this.mailS = mailS;
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
