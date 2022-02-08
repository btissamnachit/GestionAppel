package miage.gestionappel.dao;

import miage.gestionappel.metier.Occurence;
import miage.gestionappel.metier.User;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDao  implements Dao<User>  {

    public UserDao() {
    }

    @Override
    public Optional<User> get(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            return Optional.ofNullable(user);
        }
    }

    public User getConnexion(String email, String motdepasse) throws ExceptionDao{
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            List<User> userList = session.createQuery("FROM User WHERE mailU = :mail and motdepasseU = :motdepasse")
                    .setParameter("mail", email)
                    .setParameter("motdepasse", motdepasse)
                    .list();
            return userList.get(0);
        }catch (Exception e) {
            throw new ExceptionDao("Email et/ ou mot de passe est incorrecte!");
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
