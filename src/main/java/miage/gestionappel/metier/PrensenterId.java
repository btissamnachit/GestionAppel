package miage.gestionappel.metier;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrensenterId implements Serializable {
    private int idOc;
    private int idE;

    public PrensenterId() {
    }

    public PrensenterId(int idOc, int idE) {
        this.idOc = idOc;
        this.idE = idE;
    }

    public int getIdOc() {
        return idOc;
    }

    public void setIdOc(int idOc) {
        this.idOc = idOc;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrensenterId that = (PrensenterId) o;
        return Objects.equals(idOc, that.idOc) && Objects.equals(idE, that.idE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOc, idE);
    }
}