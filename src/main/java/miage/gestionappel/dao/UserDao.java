package miage.gestionappel.dao;

import miage.gestionappel.metier.Occurence;
import miage.gestionappel.metier.User;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User>{
    @Override
    public Optional<User> get(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            return Optional.ofNullable(user);
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {

    }
}
