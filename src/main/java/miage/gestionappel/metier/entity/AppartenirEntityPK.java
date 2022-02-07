package miage.gestionappel.metier.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class AppartenirEntityPK implements Serializable {
    @Column(name = "idEtudiant")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    @Column(name = "idG")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idG;

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public int getIdG() {
        return idG;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppartenirEntityPK that = (AppartenirEntityPK) o;

        if (idEtudiant != that.idEtudiant) return false;
        if (idG != that.idG) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEtudiant;
        result = 31 * result + idG;
        return result;
    }
}
