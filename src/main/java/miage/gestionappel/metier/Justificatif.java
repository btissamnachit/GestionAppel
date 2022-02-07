package miage.gestionappel.metier;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name="Justificatif")
public class Justificatif {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idJ")
    private int idJ;

    @Column(name = "StatutJustif")
    private boolean statutJustif;

    @Column(name = "URLJ")
    private String urlj;

    @OneToMany(mappedBy = "justificatif")
    Set<Presenter> presences = new HashSet<>();

    public Justificatif() {
    }

    public Justificatif(int idJ, boolean statutJustif, String urlj, Set<Presenter> presences) {
        this.idJ = idJ;
        this.statutJustif = statutJustif;
        this.urlj = urlj;
        this.presences = presences;
    }

    public Justificatif(boolean statutJustif, String urlj, Set<Presenter> presences) {
        this.statutJustif = statutJustif;
        this.urlj = urlj;
        this.presences = presences;
    }

    public int getIdJ() {
        return idJ;
    }

    public void setIdJ(int idJ) {
        this.idJ = idJ;
    }

    public boolean isStatutJustif() {
        return statutJustif;
    }

    public void setStatutJustif(boolean statutJustif) {
        this.statutJustif = statutJustif;
    }

    public String getUrlj() {
        return urlj;
    }

    public void setUrlj(String urlj) {
        this.urlj = urlj;
    }

    public Set<Presenter> getPresences() {
        return presences;
    }

    public void setPresences(Set<Presenter> presences) {
        this.presences = presences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Justificatif that = (Justificatif) o;
        return idJ == that.idJ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJ);
    }

    @Override
    public String toString() {
        return "Justificatif{" +
                "idJ=" + idJ +
                ", statutJustif=" + statutJustif +
                ", urlj='" + urlj + '\'' +
                '}';
    }
}
