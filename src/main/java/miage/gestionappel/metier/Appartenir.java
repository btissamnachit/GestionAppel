package miage.gestionappel.metier;

import javax.persistence.*;

@Entity
@IdClass(AppartenirPK.class)
public class Appartenir {
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

        Appartenir that = (Appartenir) o;

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
