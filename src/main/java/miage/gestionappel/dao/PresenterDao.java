package miage.gestionappel.dao;

import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Presenter;
import miage.gestionappel.metier.Scolarite;
import miage.gestionappel.metier.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PresenterDao  implements Dao<Presenter>{
    @Override
    public Presenter get(int id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            session.beginTransaction();
            Presenter presence = session.get(Presenter.class, id);
            return presence;
        }
    }

    @Override
    public List<Presenter> getAll() {
        List<Presenter> listePresences = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            /*----- Ouverture d'une transaction -----*/
            session.beginTransaction();

            listePresences = (List<Presenter>)session.createQuery("from Presenter ").list();
        }
        return listePresences;
    }

    @Override
    public void save(Presenter presence) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.save(presence);
            t.commit();
        }
    }

    @Override
    public void update(Presenter presence, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            if(params != null) {
                presence.setStatut(params[0]);
            }
            t.commit();
        }
    }

    public void saveOrUpdate(Presenter presence) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            System.out.println(presence.getStatut());
            session.saveOrUpdate(presence);
            t.commit();
        }
    }

    @Override
    public void delete(Presenter presence) {

    }
}
