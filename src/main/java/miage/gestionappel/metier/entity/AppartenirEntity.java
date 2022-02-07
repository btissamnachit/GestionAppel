package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "APPARTENIR", schema = "db_22107723_2")
@IdClass(AppartenirEntityPK.class)
public class AppartenirEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEtudiant")
    private int idEtudiant;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idG")
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

        AppartenirEntity that = (AppartenirEntity) o;

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
