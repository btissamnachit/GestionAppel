package miage.gestionappel.dao;

import miage.gestionappel.metier.Occurence;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class OccurenceDao implements Dao<Occurence> {
    @Override
    public Optional<Occurence> get(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Occurence o = session.get(Occurence.class, id);
        }
        return Optional.empty();
    }

    @Override
    public List<Occurence> getAll() {
        return null;
    }

    @Override
    public void save(Occurence occurence) {

    }

    @Override
    public void update(Occurence occurence, String[] params) {

    }

    @Override
    public void delete(Occurence occurence) {

    }
}
