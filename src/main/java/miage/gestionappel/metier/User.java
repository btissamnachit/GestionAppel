package miage.gestionappel.metier;


import javax.persistence.*;
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
}


