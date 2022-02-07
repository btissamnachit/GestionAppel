package miage.gestionappel.metier;

import javax.persistence.*;

@Entity
public class Etudiant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEtudiant")
    private int idEtudiant;
    @Basic
    @Column(name = "NomE")
    private String nomE;
    @Basic
    @Column(name = "PrenomE")
    private String prenomE;
    @Basic
    @Column(name = "MailE")
    private String mailE;

    public Etudiant(String nomE, String prenomE, String mailE) {
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.mailE = mailE;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getMailE() {
        return mailE;
    }

    public void setMailE(String mailE) {
        this.mailE = mailE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etudiant etudiant = (Etudiant) o;

        if (idEtudiant != etudiant.idEtudiant) return false;
        if (nomE != null ? !nomE.equals(etudiant.nomE) : etudiant.nomE != null) return false;
        if (prenomE != null ? !prenomE.equals(etudiant.prenomE) : etudiant.prenomE != null) return false;
        if (mailE != null ? !mailE.equals(etudiant.mailE) : etudiant.mailE != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEtudiant;
        result = 31 * result + (nomE != null ? nomE.hashCode() : 0);
        result = 31 * result + (prenomE != null ? prenomE.hashCode() : 0);
        result = 31 * result + (mailE != null ? mailE.hashCode() : 0);
        return result;
    }
}
