package miage.gestionappel.metier;

import javax.persistence.*;

@Entity
public class Cours {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idC")
    private int idC;
    @Basic
    @Column(name = "NomC")
    private String nomC;

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cours cours = (Cours) o;

        if (idC != cours.idC) return false;
        if (nomC != null ? !nomC.equals(cours.nomC) : cours.nomC != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idC;
        result = 31 * result + (nomC != null ? nomC.hashCode() : 0);
        return result;
    }
}
