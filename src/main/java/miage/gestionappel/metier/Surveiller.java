package miage.gestionappel.metier;

import javax.persistence.*;

@Entity
@IdClass(SurveillerPK.class)
public class Surveiller {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idS")
    private int idS;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idC")
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

        Surveiller that = (Surveiller) o;

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
