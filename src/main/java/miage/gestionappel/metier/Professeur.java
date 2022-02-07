package miage.gestionappel.metier;

import javax.persistence.*;

@Entity
public class Professeur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idP")
    private int idP;
    @Basic
    @Column(name = "NomP")
    private String nomP;
    @Basic
    @Column(name = "PrenomP")
    private String prenomP;
    @Basic
    @Column(name = "MailP")
    private String mailP;

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public String getMailP() {
        return mailP;
    }

    public void setMailP(String mailP) {
        this.mailP = mailP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professeur that = (Professeur) o;

        if (idP != that.idP) return false;
        if (nomP != null ? !nomP.equals(that.nomP) : that.nomP != null) return false;
        if (prenomP != null ? !prenomP.equals(that.prenomP) : that.prenomP != null) return false;
        if (mailP != null ? !mailP.equals(that.mailP) : that.mailP != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idP;
        result = 31 * result + (nomP != null ? nomP.hashCode() : 0);
        result = 31 * result + (prenomP != null ? prenomP.hashCode() : 0);
        result = 31 * result + (mailP != null ? mailP.hashCode() : 0);
        return result;
    }
}
