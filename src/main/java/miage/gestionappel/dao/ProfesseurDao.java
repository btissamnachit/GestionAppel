package miage.gestionappel.dao;

import miage.gestionappel.metier.Professeur;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ProfesseurDao implements Dao<Professeur> {
    @Override
    public Professeur get(int id) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Professeur professeur = session.get(Professeur.class, id);
            return professeur;
        }
    }

    @Override
    public List<Professeur> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Professeur> professeurs = session.createQuery("From Professeur ").list();

            return professeurs;
        }
    }
    public Professeur getByEmail(String email) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            List<Professeur> professeurList =  session.createQuery("FROM Professeur WHERE mailP = :mail")
                    .setParameter("mail", email)
                    .list();
            return  professeurList.get(0);
        }
    }

    @Override
    public void save(Professeur professeur) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            session.save(professeur);
            t.commit();
        }
    }

    @Override
    public void update(Professeur professeur, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            professeur.setNomP(params[0]);
            professeur.setPrenomP(params[1]);
            professeur.setMailP(params[2]);
            session.update(professeur);
            t.commit();
        }
    }

    @Override

    public void delete(Professeur professeur) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            session.remove(professeur);
            t.commit();
        }
    }
}

