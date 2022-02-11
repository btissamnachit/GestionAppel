package miage.gestionappel.metier;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name="Justificatif")
public class Justificatif {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idJ")
    private int idJ;

    @Column(name = "StatutJustif")
    private String statutJustif;

    @Column(name = "URLJ")
    private String urlj;

    @Column(name = "DateDebut")
    private Date dateDebut;

    @Column(name = "DateFin")
    private Date dateFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdE")
    private Etudiant etudiant;

    @OneToMany(mappedBy = "justificatif", fetch = FetchType.EAGER)
    Set<Presenter> presences = new HashSet<>();



    public Justificatif() {
    }

    public Justificatif(String statutJustif, String urlj, Date dateDebut, Date dateFin, Etudiant etudiant) {
        this.statutJustif = statutJustif;
        this.urlj = urlj;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etudiant = etudiant;
    }

    public int getIdJ() {
        return idJ;
    }

    public void setIdJ(int idJ) {
        this.idJ = idJ;
    }

    public String getStatutJustif() {
        return statutJustif;
    }

    public void setStatutJustif(String statutJustif) {
        this.statutJustif = statutJustif;
    }

    public String getUrlj() {
        return urlj;
    }

    public void setUrlj(String urlj) {
        this.urlj = urlj;
    }

    public Set<Presenter> getPresences() {
        return presences;
    }

    public void setPresences(Set<Presenter> presences) {
        this.presences = presences;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Justificatif that = (Justificatif) o;
        return idJ == that.idJ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJ);
    }

    @Override
    public String toString() {
        return "Justificatif{" +
                "statutJustif='" + statutJustif + '\'' +
                ", urlj='" + urlj + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", etudiant=" + etudiant +
                '}';
    }
}
