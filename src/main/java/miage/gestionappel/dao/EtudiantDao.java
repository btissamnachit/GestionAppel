package miage.gestionappel.dao;

import miage.gestionappel.metier.Cours;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Occurence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EtudiantDao implements Dao<Etudiant> {

    @Override
    @Transactional
    public Etudiant get(int id) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Etudiant etudiant = session.get(Etudiant.class, id);
            return etudiant;
        }
    }

    @Override
    @Transactional
    public List<Etudiant> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Etudiant> etudiantList = session.createQuery("From Etudiant ").list();

            return etudiantList;
        }
    }


    public Etudiant getByEmail(String email) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            List<Etudiant> etudiantList =  session.createQuery("FROM Etudiant WHERE mailE = :mail")
                    .setParameter("mail", email)
                    .list();
            return  etudiantList.get(0);
        }
    }

    @Override
    @Transactional
    public void save(Etudiant etudiant) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.save(etudiant);
            t.commit();
        }
    }

    @Override
    @Transactional
    public void update(Etudiant etudiant, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            etudiant.setNomE(params[0]);
            etudiant.setPrenomE(params[1]);
            etudiant.setMailE(params[2]);

            session.update(etudiant);
            t.commit();
        }
    }

    @Override
    @Transactional
    public void delete(Etudiant o) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Etudiant etudiant = (Etudiant) o;

            session.remove(etudiant);
            t.commit();

        }
    }

    @Transactional
    public List<Occurence> getAbsencesCours(Etudiant etudiant, Cours cours) {
        List<Occurence> absences = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            absences = session.createQuery(" select Oc FROM Occurence as Oc,Presenter as P" +
                            " WHERE Oc.cours.idC= :cours " +
                            "and Oc.idOc = P.occurence.idOc and  P.etudiant.idE = :etudiant and P.statut = 'Absent'")
                    .setParameter("cours", cours.getIdC())
                    .setParameter("etudiant", etudiant.getIdE()).list();
            t.commit();
        }
        return absences;
    }

    @Transactional
    public List<Occurence> getAllAbsence(Etudiant etudiant) {
        List<Occurence> listAbsences = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            listAbsences = session.createQuery(" SELECT p.occurence from Presenter p where p.etudiant.idE = :etudiant  AND p.statut = 'Absent'").setParameter("etudiant", etudiant.getIdE()).list();


            t.commit();
        }
        return listAbsences;


    }

    @Transactional
    public List<Occurence> getAllAbsenceMois(Etudiant etudiant, Date dateexacte) {

        SimpleDateFormat month = new SimpleDateFormat("mm");
        String mois = month.format(dateexacte);
        List<Occurence> listAbsences = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            listAbsences = session.createQuery(" SELECT p.occurence from Presenter p where p.etudiant.idE = :etudiant  AND p.statut = 'Absent' AND MONTH(p.occurence.dateOc) = :month").setParameter("etudiant", etudiant.getIdE()).setParameter("month", mois).list();


            t.commit();
        }
        return listAbsences;


    }


    }





