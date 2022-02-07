package miage.gestionappel.metier;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class SurveillerPK implements Serializable {
    @Column(name = "idS")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idS;
    @Column(name = "idC")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
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

        SurveillerPK that = (SurveillerPK) o;

        if (idS != that.idS) return false;
        if (idC != that.idC) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idS;
        result = 31 * result + idC;
        return result;
    }
}
