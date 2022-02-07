package miage.gestionappel.metier;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name= "Occurence")
public class Occurence {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdOc")
    private int idOc;

    @Column(name = "DateOc")
    private Date dateOc;

    @Column(name = "HeureDebutOc")
    private Time heureDebutOc;

    @Column(name = "HeureFinOc")
    private Time heureFinOc;

    @Column(name = "AppelValide")
    private boolean appelValide;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdP")
    private Professeur professeur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdC")
    private Cours cours;

    @OneToMany(mappedBy = "occurence")
    Set<Presenter> presences = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Participer", joinColumns = @JoinColumn(name = "IdOc"), inverseJoinColumns = @JoinColumn(name = "IdG"))
    private Set<Groupe> groupes = new HashSet<>();

    public Occurence() {
    }

    public Occurence(int idOc, Date dateOc, Time heureDebutOc, Time heureFinOc, boolean appelValide, Professeur professeur, Cours cours, Set<Presenter> presences, Set<Groupe> groupes) {
        this.idOc = idOc;
        this.dateOc = dateOc;
        this.heureDebutOc = heureDebutOc;
        this.heureFinOc = heureFinOc;
        this.appelValide = appelValide;
        this.professeur = professeur;
        this.cours = cours;
        this.presences = presences;
        this.groupes = groupes;
    }

    public Occurence(Date dateOc, Time heureDebutOc, Time heureFinOc, boolean appelValide, Professeur professeur, Cours cours, Set<Presenter> presences, Set<Groupe> groupes) {
        this.dateOc = dateOc;
        this.heureDebutOc = heureDebutOc;
        this.heureFinOc = heureFinOc;
        this.appelValide = appelValide;
        this.professeur = professeur;
        this.cours = cours;
        this.presences = presences;
        this.groupes = groupes;
    }

    public int getIdOc() {
        return idOc;
    }

    public void setIdOc(int idOc) {
        this.idOc = idOc;
    }

    public Date getDateOc() {
        return dateOc;
    }

    public void setDateOc(Date dateOc) {
        this.dateOc = dateOc;
    }

    public Time getHeureDebutOc() {
        return heureDebutOc;
    }

    public void setHeureDebutOc(Time heureDebutOc) {
        this.heureDebutOc = heureDebutOc;
    }

    public Time getHeureFinOc() {
        return heureFinOc;
    }

    public void setHeureFinOc(Time heureFinOc) {
        this.heureFinOc = heureFinOc;
    }

    public boolean getAppelValide() {
        return appelValide;
    }

    public void setAppelValide(boolean appelValide) {
        this.appelValide = appelValide;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Set<Presenter> getPresences() {
        return presences;
    }

    public void setPresences(Set<Presenter> presences) {
        this.presences = presences;
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
        Occurence occurence = (Occurence) o;
        return idOc == occurence.idOc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOc);
    }

    @Override
    public String toString() {
        return "Occurence{" +
                "idOc=" + idOc +
                ", dateOc=" + dateOc +
                ", heureDebutOc=" + heureDebutOc +
                ", heureFinOc=" + heureFinOc +
                ", appelValide=" + appelValide +
                '}';
    }
}
