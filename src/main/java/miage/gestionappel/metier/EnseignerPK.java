package miage.gestionappel.metier;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class EnseignerPK implements Serializable {
    @Column(name = "idP")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idP;
    @Column(name = "idC")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnseignerPK that = (EnseignerPK) o;

        if (idP != that.idP) return false;
        if (idC != that.idC) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idP;
        result = 31 * result + idC;
        return result;
    }
}
