package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "User", schema = "db_22107723_2")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CodeU")
    private long codeU;
    @Basic
    @Column(name = "NomU")
    private String nomU;

    public long getCodeU() {
        return codeU;
    }

    public void setCodeU(long codeU) {
        this.codeU = codeU;
    }

    public String getNomU() {
        return nomU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (codeU != that.codeU) return false;
        if (nomU != null ? !nomU.equals(that.nomU) : that.nomU != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeU ^ (codeU >>> 32));
        result = 31 * result + (nomU != null ? nomU.hashCode() : 0);
        return result;
    }
}
