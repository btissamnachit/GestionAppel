package miage.gestionappel.dao;

import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Presenter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PresenterDao  implements Dao<Presenter>{
    @Override
    public Presenter get(int id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            return session.get(Presenter.class, id);
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
            Etudiant etudiant = session.get(Etudiant.class,presence.getEtudiant().getIdE());
            etudiant.addPresence(presence);
            t.commit();
        }
    }

    @Override
    public void update(Presenter presence, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            presence.setStatut(params[0]);
            t.commit();
        }
    }

    @Override
    public void delete(Presenter presence) {

    }
}
