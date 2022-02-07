package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRESENTER", schema = "db_22107723_2")
@IdClass(PresenterEntityPK.class)
public class PresenterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idOc")
    private int idOc;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idJustif")
    private int idJustif;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEtudiant")
    private int idEtudiant;
    @Basic
    @Column(name = "Statut")
    private String statut;

    public int getIdOc() {
        return idOc;
    }

    public void setIdOc(int idOc) {
        this.idOc = idOc;
    }

    public int getIdJustif() {
        return idJustif;
    }

    public void setIdJustif(int idJustif) {
        this.idJustif = idJustif;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
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

        PresenterEntity that = (PresenterEntity) o;

        if (idOc != that.idOc) return false;
        if (idJustif != that.idJustif) return false;
        if (idEtudiant != that.idEtudiant) return false;
        if (statut != null ? !statut.equals(that.statut) : that.statut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOc;
        result = 31 * result + idJustif;
        result = 31 * result + idEtudiant;
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        return result;
    }
}
