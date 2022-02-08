package miage.gestionappel.dao;

import miage.gestionappel.metier.Groupe;
import miage.gestionappel.metier.Occurence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class GroupeDao implements Dao<Groupe>{

    @Override
    public Optional<Groupe> get(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Groupe groupe = session.get(Groupe.class, id);
            return Optional.ofNullable(groupe);
        }
    }

    @Override
    public List<Groupe> getAll() {
        List<Groupe> groupeList;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            groupeList = (List<Groupe>) session.createQuery("FROM Groupe ").list();
        }
        return groupeList;
    }

    @Override
    public void save(Groupe groupe) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.save(groupe);
            t.commit();
        }
    }

    @Override
    public void update(Groupe groupe, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.update(groupe);
            t.commit();
        }
    }

    @Override
    public void delete(Groupe groupe) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.remove(groupe);
            t.commit();
        }
    }
}
