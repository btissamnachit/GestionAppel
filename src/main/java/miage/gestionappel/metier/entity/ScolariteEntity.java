package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "SCOLARITE", schema = "db_22107723_2")
public class ScolariteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idS")
    private int idS;
    @Basic
    @Column(name = "LibelleS")
    private String libelleS;

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getLibelleS() {
        return libelleS;
    }

    public void setLibelleS(String libelleS) {
        this.libelleS = libelleS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScolariteEntity that = (ScolariteEntity) o;

        if (idS != that.idS) return false;
        if (libelleS != null ? !libelleS.equals(that.libelleS) : that.libelleS != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idS;
        result = 31 * result + (libelleS != null ? libelleS.hashCode() : 0);
        return result;
    }
}
