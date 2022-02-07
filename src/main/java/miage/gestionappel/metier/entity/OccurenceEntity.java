package miage.gestionappel.metier.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "OCCURENCE", schema = "db_22107723_2")
public class OccurenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idOc")
    private int idOc;
    @Basic
    @Column(name = "DateOc")
    private Date dateOc;
    @Basic
    @Column(name = "HeureDebutOc")
    private Time heureDebutOc;
    @Basic
    @Column(name = "HeureFinOc")
    private Time heureFinOc;
    @Basic
    @Column(name = "AppelValide")
    private byte appelValide;
    @Basic
    @Column(name = "idC")
    private Integer idC;
    @Basic
    @Column(name = "idP")
    private Integer idP;

    public int getIdOc() {
        return idOc;
    }

    public void setIdOc(int idOc) {
        this.idOc = idOc;
    }

    public Date getDateOc() {
        return dateOc;
    }

    public void setDateOc(Date dateOc) {
        this.dateOc = dateOc;
    }

    public Time getHeureDebutOc() {
        return heureDebutOc;
    }

    public void setHeureDebutOc(Time heureDebutOc) {
        this.heureDebutOc = heureDebutOc;
    }

    public Time getHeureFinOc() {
        return heureFinOc;
    }

    public void setHeureFinOc(Time heureFinOc) {
        this.heureFinOc = heureFinOc;
    }

    public byte getAppelValide() {
        return appelValide;
    }

    public void setAppelValide(byte appelValide) {
        this.appelValide = appelValide;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OccurenceEntity that = (OccurenceEntity) o;

        if (idOc != that.idOc) return false;
        if (appelValide != that.appelValide) return false;
        if (dateOc != null ? !dateOc.equals(that.dateOc) : that.dateOc != null) return false;
        if (heureDebutOc != null ? !heureDebutOc.equals(that.heureDebutOc) : that.heureDebutOc != null) return false;
        if (heureFinOc != null ? !heureFinOc.equals(that.heureFinOc) : that.heureFinOc != null) return false;
        if (idC != null ? !idC.equals(that.idC) : that.idC != null) return false;
        if (idP != null ? !idP.equals(that.idP) : that.idP != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOc;
        result = 31 * result + (dateOc != null ? dateOc.hashCode() : 0);
        result = 31 * result + (heureDebutOc != null ? heureDebutOc.hashCode() : 0);
        result = 31 * result + (heureFinOc != null ? heureFinOc.hashCode() : 0);
        result = 31 * result + (int) appelValide;
        result = 31 * result + (idC != null ? idC.hashCode() : 0);
        result = 31 * result + (idP != null ? idP.hashCode() : 0);
        return result;
    }
}
