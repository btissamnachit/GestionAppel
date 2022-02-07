package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "GROUPE", schema = "db_22107723_2")
public class GroupeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idG")
    private int idG;

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

        GroupeEntity that = (GroupeEntity) o;

        if (idG != that.idG) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idG;
    }
}
