package miage.gestionappel.metier;

import javax.persistence.*;

@Entity
public class Groupe {
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

        Groupe groupe = (Groupe) o;

        if (idG != groupe.idG) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idG;
    }
}
