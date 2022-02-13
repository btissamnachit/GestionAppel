package miage.gestionappel.metier;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Etudiant")
public class Etudiant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdE")
    private int idE;
    @Basic
    @Column(name = "NomE")
    private String nomE;
    @Basic
    @Column(name = "PrenomE")
    private String prenomE;
    @Basic
    @Column(name = "MailE")
    private String mailE;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Justificatif> justificatifs = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Appartenir", joinColumns = @JoinColumn(name = "IdE"), inverseJoinColumns = @JoinColumn(name = "IdG"))
    private Set<Groupe> groupes = new HashSet<>();

    @OneToMany(mappedBy = "etudiant", fetch = FetchType.EAGER)
    Set<Presenter> presences = new HashSet<>();
    public Etudiant() {
    }

    public Etudiant(String nomE, String prenomE, String mailE) {
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.mailE = mailE;

    }

    public Etudiant(String nomE, String prenomE, String mailE, Set<Justificatif> justificatifs, Set<Groupe> groupes, Set<Presenter> presences) {
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.mailE = mailE;
        this.justificatifs = justificatifs;
        this.groupes = groupes;
        this.presences = presences;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getMailE() {
        return mailE;
    }

    public void setMailE(String mailE) {
        this.mailE = mailE;
    }

    public Set<Justificatif> getJustificatifs() {
        return justificatifs;
    }

    public void setJustificatifs(Set<Justificatif> justificatifs) {
        this.justificatifs = justificatifs;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }

    public Set<Presenter> getPresences() {
        return presences;
    }

    public void setPresences(Set<Presenter> presences) {
        this.presences = presences;
    }

    /*   public Set<Groupe> getGroupes() {
            return groupes;
        }

        public void setGroupes(Set<Groupe> groupes) {
            this.groupes = groupes;
        }

        public Set<Presenter> getPresences() {
            return presences;
        }

        public void setPresences(Set<Presenter> presences) {
            this.presences = presences;
        }
    */
    public void addPresence(Presenter presence) {
        this.presences.add(presence);
     }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return idE == etudiant.idE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idE);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "idE=" + idE +
                ", nomE='" + nomE + '\'' +
                ", prenomE='" + prenomE + '\'' +
                ", mailE='" + mailE + '\'' +
                '}';
    }
}
