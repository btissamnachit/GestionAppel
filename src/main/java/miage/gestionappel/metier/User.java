package miage.gestionappel.metier;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodeU")
    private Long codeU;

    @Column(name = "NomU")
    private String nomU;

    public User() {
    }

    public Long getCodeU() {
        return codeU;
    }

    public void setCodeU(Long codeU) {
        this.codeU = codeU;
    }

    public String getNomU() {
        return nomU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public User(Long codeU, String nomU) {
        this.codeU = codeU;
        this.nomU = nomU;
    }

    public User(String nomU) {
        this.nomU = nomU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(codeU, user.codeU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeU);
    }

    @Override
    public String toString() {
        return "User{" +
                "codeU=" + codeU +
                ", nomU='" + nomU + '\'' +
                '}';
    }
}


