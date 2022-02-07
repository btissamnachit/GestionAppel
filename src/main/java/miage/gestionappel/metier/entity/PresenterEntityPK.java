package miage.gestionappel.metier.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class PresenterEntityPK implements Serializable {
    @Column(name = "idOc")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOc;
    @Column(name = "idJustif")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJustif;
    @Column(name = "idEtudiant")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PresenterEntityPK that = (PresenterEntityPK) o;

        if (idOc != that.idOc) return false;
        if (idJustif != that.idJustif) return false;
        if (idEtudiant != that.idEtudiant) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOc;
        result = 31 * result + idJustif;
        result = 31 * result + idEtudiant;
        return result;
    }
}
