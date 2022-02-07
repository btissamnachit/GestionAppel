package miage.gestionappel.metier;

import javax.persistence.*;

@Entity
@IdClass(InscrirePK.class)
public class Inscrire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idC")
    private int idC;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idG")
    private int idG;

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
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

        Inscrire inscrire = (Inscrire) o;

        if (idC != inscrire.idC) return false;
        if (idG != inscrire.idG) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idC;
        result = 31 * result + idG;
        return result;
    }
}
