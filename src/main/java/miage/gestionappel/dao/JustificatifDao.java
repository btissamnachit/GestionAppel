package miage.gestionappel.dao;

import miage.gestionappel.metier.Justificatif;
import miage.gestionappel.metier.Presenter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class JustificatifDao implements Dao<Justificatif> {
    @Override
    public Justificatif get(int id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            session.beginTransaction();
            Justificatif justificatif = session.get(Justificatif.class, id);
            return justificatif;
        }
    }

    @Override
    public List<Justificatif> getAll() {
        List<Justificatif> listeJustificatis ;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            session.beginTransaction();
            listeJustificatis = (List<Justificatif>)session.createQuery("from Justificatif").list();
        }
        return listeJustificatis;
    }

    @Override
    public void save(Justificatif justificatif) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.save(justificatif);
            t.commit();
        }
    }

    @Override
    public void update(Justificatif justificatif, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            if(params != null){
                justificatif.setStatutJustif(params[0]);
            }
            t.commit();
        }

    }

    @Override
    public void delete(Justificatif justificatif) {

    }
}
