package miage.gestionappel.dao;

import miage.gestionappel.metier.Justificatif;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class JustificatifDao implements Dao<Justificatif> {
    @Override
    public Justificatif get(int id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            return session.get(Justificatif.class, id);
        }
    }

    @Override
    public List<Justificatif> getAll() {
        List<Justificatif> listeJustificatis = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            /*----- Ouverture d'une transaction -----*/
            session.beginTransaction();

            listeJustificatis = (List<Justificatif>)session.createQuery("from Justificatif").list();
        }
        return listeJustificatis;
    }

    @Override
    public void save(Justificatif justificatif) {

    }

    @Override
    public void update(Justificatif justificatif, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            justificatif.setStatutJustif(Boolean.parseBoolean(params[0]));
            t.commit();
        }

    }

    @Override
    public void delete(Justificatif justificatif) {

    }
}
