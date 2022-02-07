package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "SURVEILLER", schema = "db_22107723_2")
@IdClass(SurveillerEntityPK.class)
public class SurveillerEntity {
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

        SurveillerEntity that = (SurveillerEntity) o;

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
