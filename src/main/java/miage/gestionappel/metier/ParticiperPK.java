package miage.gestionappel.metier;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class ParticiperPK implements Serializable {
    @Column(name = "idOc")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOc;
    @Column(name = "idG")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idG;

    public int getIdOc() {
        return idOc;
    }

    public void setIdOc(int idOc) {
        this.idOc = idOc;
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

        ParticiperPK that = (ParticiperPK) o;

        if (idOc != that.idOc) return false;
        if (idG != that.idG) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOc;
        result = 31 * result + idG;
        return result;
    }
}
