package miage.gestionappel.dao;

import miage.gestionappel.metier.Scolarite;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ScolariteDao implements Dao<Scolarite>{
    @Override
    public Scolarite get(int id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            session.beginTransaction();
            Scolarite scolarite = session.get(Scolarite.class, id);
            return scolarite;
        }
    }

    @Override
    public List<Scolarite> getAll() {
        List<Scolarite> list_scolarites = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            /*----- Ouverture d'une transaction -----*/
            session.beginTransaction();

            list_scolarites = (List<Scolarite>)session.createQuery("from Scolarite ").list();
        }
        return list_scolarites;
    }

    @Override
    public void save(Scolarite scolarite) {

    }

    @Override
    public void update(Scolarite scolarite, String[] params) {

    }

    @Override
    public void delete(Scolarite scolarite) {

    }
}
