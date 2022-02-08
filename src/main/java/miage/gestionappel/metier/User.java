package miage.gestionappel.metier;


import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodeU")
    private Long codeU;

    @Column(name = "MailU")
    private String mailU;

    @Column(name = "MotdepasseU")
    private String motdepasseU;

    @Column(name = "NomU")
    private String nomU;

    @Column(name = "PrenomU")
    private String prenomU;

    @Column(name = "RoleU")
    private String roleU;

    public User() {
    }

    public User(String mailU, String nomU, String prenomU, String roleU) {
        this.mailU = mailU;
        this.nomU = nomU;
        this.prenomU = prenomU;
        this.roleU = roleU;
    }

    public User(String mailU, String motdepasseU) {
        this.mailU = mailU;
        this.motdepasseU = motdepasseU;
    }


    public Long getCodeU() {
        return codeU;
    }

    public void setCodeU(Long codeU) {
        this.codeU = codeU;
    }

    public String getMailU() {
        return mailU;
    }

    public void setMailU(String mailU) {
        this.mailU = mailU;
    }

    public String getMotdepasseU() {
        return motdepasseU;
    }

    public void setMotdepasseU(String motdepasseU) {
        this.motdepasseU = motdepasseU;
    }

    public String getNomU() {
        return nomU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public String getPrenomU() {
        return prenomU;
    }

    public void setPrenomU(String prenomU) {
        this.prenomU = prenomU;
    }

    public String getRoleU() {
        return roleU;
    }

    public void setRoleU(String roleU) {
        this.roleU = roleU;
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
                ", mailU='" + mailU + '\'' +
                ", motdepasseU='" + motdepasseU + '\'' +
                ", nomU='" + nomU + '\'' +
                ", prenomU='" + prenomU + '\'' +
                ", roleU='" + roleU + '\'' +
                '}';
    }
}


