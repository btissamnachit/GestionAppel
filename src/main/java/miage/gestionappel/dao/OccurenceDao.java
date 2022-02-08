package miage.gestionappel.dao;

import miage.gestionappel.metier.Occurence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OccurenceDao implements Dao<Occurence> {
    @Override
    public Occurence get(int id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            return session.get(Occurence.class, id);
        }
    }

    @Override
    public List<Occurence> getAll() {
        List<Occurence> occurenceList;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            occurenceList = (List<Occurence>) session.createQuery("FROM Occurence ").list();
        }
        return occurenceList;
    }

    @Override
    public void save(Occurence occurence) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.save(occurence);
            t.commit();
        }
    }

    @Override
    public void update(Occurence occurence, String[] params) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            occurence.setAppelValide(Boolean.parseBoolean(params[0]));

            session.update(occurence);
            t.commit();
        }
    }

    @Override
    public void delete(Occurence occurence) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.remove(occurence);
            t.commit();
        }
    }

}
