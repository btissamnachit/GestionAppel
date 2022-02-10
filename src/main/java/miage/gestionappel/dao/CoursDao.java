package miage.gestionappel.dao;

import miage.gestionappel.metier.Cours;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Occurence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CoursDao implements Dao<Cours>{

    @Override
    public Cours get(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Cours cours = session.get(Cours.class, id);
            return cours;
        }
    }

    @Override
    public List<Cours> getAll() {
        List<Cours> coursList;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            coursList = (List<Cours>) session.createQuery("FROM Cours").list();
        }
        return coursList;
    }

    @Override
    public void save(Cours cours) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.save(cours);
            t.commit();
        }
    }

    @Override
    public void update(Cours cours, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.update(cours);
            t.commit();
        }
    }

    @Override
    public void delete(Cours cours) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.remove(cours);
            t.commit();
        }
    }

    public int nbAbsence(Cours cours) {
        int nbAbsences = 0;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            nbAbsences = (int) session.createQuery("select count(*) FROM " +
                            "Occurence as Oc,Presenter as P WHERE Oc.cours.idC= :cours " +
                            "and Oc.idOc = P.occurence.idOc and P.statut = 'Absent'")
                    .setParameter("cours", cours.getIdC()).uniqueResult();

        }
        return nbAbsences;
    }

    public int nbOccurence(Cours cours) {
        return cours.getOccurences().size();
    }

    public float moyenneAbscence(Cours cours) {
        if (nbAbsence(cours) != 0) {
            return (float) (nbAbsence(cours) / nbOccurence(cours) * 100);
        } else {
            return 0F;
        }
    }

    public List<Etudiant> getEtudiantsAbsentistes(Cours cours) {
        List<Etudiant> etudiantsAbsenteistes = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            EtudiantDao etudiantDao = new EtudiantDao();
            List<Etudiant> etudiants = etudiantDao.getAll();
            for (Etudiant etudiant : etudiants) {
                List<Occurence> absences = etudiantDao.getAbsencesCours(etudiant, cours);
                if (absences.size() >= 3) {
                    etudiantsAbsenteistes.add(etudiant);
                }
            }
        }
        return etudiantsAbsenteistes;
    }

}
