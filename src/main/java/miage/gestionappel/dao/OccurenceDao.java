package miage.gestionappel.dao;

import miage.gestionappel.metier.Occurence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class OccurenceDao implements Dao<Occurence> {
    @Override
    public Occurence get(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Occurence occurence = session.get(Occurence.class, id);
            return occurence;
        }
    }

    public Occurence getOc(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Occurence occurence = session.get(Occurence.class, id);
            return occurence;
        }
    }
    public String getMoisOccurence(Occurence occurence) {

        SimpleDateFormat month = new SimpleDateFormat("MM");
        String montht = month.format(occurence.getDateOc());
        return montht;
        }

    @Override
    public List<Occurence> getAll() {
        List<Occurence> occurenceList;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            occurenceList = (List<Occurence>) session.createQuery("FROM Occurence ").list();
        }
        return occurenceList;
    }

    @Override
    public void save(Occurence occurence) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.save(occurence);
            t.commit();
        }
    }

    @Override
    public void update(Occurence occurence, String[] params) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            if(params != null){
                occurence.setAppelValide(Boolean.parseBoolean(params[0]));
            }
            session.update(occurence);
            t.commit();
            System.out.println("finich update");
        }
    }

    @Override
    public void delete(Occurence occurence) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.remove(occurence);
            t.commit();
        }
    }

}
