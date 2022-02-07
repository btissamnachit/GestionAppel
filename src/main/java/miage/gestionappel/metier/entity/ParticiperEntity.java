package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "PARTICIPER", schema = "db_22107723_2")
@IdClass(ParticiperEntityPK.class)
public class ParticiperEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idOc")
    private int idOc;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idG")
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

        ParticiperEntity that = (ParticiperEntity) o;

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
