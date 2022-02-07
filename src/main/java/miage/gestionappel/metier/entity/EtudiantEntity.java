package miage.gestionappel.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "ETUDIANT", schema = "db_22107723_2")
public class EtudiantEntity {
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

        EtudiantEntity that = (EtudiantEntity) o;

        if (idEtudiant != that.idEtudiant) return false;
        if (nomE != null ? !nomE.equals(that.nomE) : that.nomE != null) return false;
        if (prenomE != null ? !prenomE.equals(that.prenomE) : that.prenomE != null) return false;
        if (mailE != null ? !mailE.equals(that.mailE) : that.mailE != null) return false;

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
