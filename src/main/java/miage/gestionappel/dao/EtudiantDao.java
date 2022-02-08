package miage.gestionappel.dao;

import miage.gestionappel.metier.Etudiant;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class EtudiantDao implements Dao<Etudiant> {
     @Override
    public Etudiant get(int id) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Etudiant etudiant = session.get(Etudiant.class, id);
            return etudiant;
        }
    }

    @Override
    public List<Etudiant> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Etudiant> etudiantList = session.createQuery("From Etudiant ").list();

            return etudiantList;
        }
    }

    @Override
    public void save(Etudiant etudiant) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.save(etudiant);
            t.commit();
        }
    }

    @Override
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
    public void delete(Etudiant o) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Etudiant etudiant = (Etudiant) o;

            session.remove(etudiant);
            t.commit();

        }
    }


}
