package miage.gestionappel.metier.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class InscrireEntityPK implements Serializable {
    @Column(name = "idC")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;
    @Column(name = "idG")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idG;

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
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

        InscrireEntityPK that = (InscrireEntityPK) o;

        if (idC != that.idC) return false;
        if (idG != that.idG) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idC;
        result = 31 * result + idG;
        return result;
    }
}
