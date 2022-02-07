package miage.gestionappel.dao;

import miage.gestionappel.metier.Professeur;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ProDao implements Dao {
    @Override
    public Optional<Professeur> get(long id) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Professeur professeur = session.get(Professeur.class, id);
            return Optional.ofNullable(professeur);
        }
    }

    @Override
    public List<Professeur> getAll() {


        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Professeur> list1 = session.createSQLQuery("select * from Professeur ").list();

            return list1;
        }
    }

    @Override
    public void save(Object professeur) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.save((Professeur) professeur);
            t.commit();

        }
    }

    @Override
    public void update(Object p, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Professeur professeur = (Professeur) p;

            professeur.setNomP(params[0]);
            professeur.setPrenomP(params[1]);
            professeur.setMailP(params[2]);
            session.update(professeur);
            t.commit();


        }
    }

    @Override

    public void delete(Object p) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Professeur professeur = (Professeur) p;

            session.remove(professeur);
            t.commit();

        }
    }


}

