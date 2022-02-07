package miage.gestionappel.dao;

import miage.gestionappel.metier.Etudiant;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class EtudiantDao implements Dao {

    @Override
    public Optional<Etudiant> get(int id) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Etudiant etudiant = session.get(Etudiant.class, id);
            return Optional.ofNullable(etudiant);
        }
    }

    @Override
    public List<Etudiant> getAll() {


        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Etudiant> list1 = session.createSQLQuery("select * from Etudiant ").list();

            return list1;
        }
    }

    @Override
    public void save(Object etudiant) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.save((Etudiant) etudiant);
            t.commit();

        }
    }

    @Override
    public void update(Object e, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Etudiant etudiant = (Etudiant) e;

            etudiant.setNomE(params[0]);
            etudiant.setPrenomE(params[1]);
            etudiant.setMailE(params[2]);
            session.update(etudiant);
            t.commit();


        }
    }

    @Override
    public void delete(Object o) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Etudiant etudiant = (Etudiant) o;

            session.remove(etudiant);
            t.commit();

        }
    }


}
