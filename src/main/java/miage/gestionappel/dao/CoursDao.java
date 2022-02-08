package miage.gestionappel.dao;

import miage.gestionappel.metier.Cours;
import miage.gestionappel.metier.Occurence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CoursDao implements Dao<Cours>{

    @Override
    public Optional<Cours> get(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Cours cours = session.get(Cours.class, id);
            return Optional.ofNullable(cours);
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
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.remove(cours);
            t.commit();
        }
    }
}
