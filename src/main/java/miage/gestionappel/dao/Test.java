package miage.gestionappel.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;

public class Test {
    public static void createUser(){
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            //ouverture d'une transaction
            Transaction t = session.beginTransaction();

            User e1 = new User("Anis");

            session.save(e1);

            t.commit();
        }
    }
    public static void main (String[] args) throws ParseException
    {
        Test.createUser();

    }
}
