package miage.gestionappel.metier;

import javax.persistence.*;

@Entity
public class Justificatif {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idJustif")
    private int idJustif;
    @Basic
    @Column(name = "StatutJustif")
    private Byte statutJustif;
    @Basic
    @Column(name = "URLJ")
    private String urlj;

    public int getIdJustif() {
        return idJustif;
    }

    public void setIdJustif(int idJustif) {
        this.idJustif = idJustif;
    }

    public Byte getStatutJustif() {
        return statutJustif;
    }

    public void setStatutJustif(Byte statutJustif) {
        this.statutJustif = statutJustif;
    }

    public String getUrlj() {
        return urlj;
    }

    public void setUrlj(String urlj) {
        this.urlj = urlj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Justificatif that = (Justificatif) o;

        if (idJustif != that.idJustif) return false;
        if (statutJustif != null ? !statutJustif.equals(that.statutJustif) : that.statutJustif != null) return false;
        if (urlj != null ? !urlj.equals(that.urlj) : that.urlj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idJustif;
        result = 31 * result + (statutJustif != null ? statutJustif.hashCode() : 0);
        result = 31 * result + (urlj != null ? urlj.hashCode() : 0);
        return result;
    }
}
