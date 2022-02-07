package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "ENSEIGNER", schema = "db_22107723_2")
@IdClass(EnseignerEntityPK.class)
public class EnseignerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idP")
    private int idP;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idC")
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

        EnseignerEntity that = (EnseignerEntity) o;

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
