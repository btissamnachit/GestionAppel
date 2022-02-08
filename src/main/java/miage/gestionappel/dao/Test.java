package miage.gestionappel.dao;

import com.google.gson.Gson;
import miage.gestionappel.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

public class Test {
    public static void createEtudiant(){
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            //ouverture d'une transaction
            Transaction t = session.beginTransaction();

            Etudiant etudiant = new Etudiant("NACHIT", "Btissam", "btissam.nachir@ut1-capitole.fr");
            Scolarite s1 = new Scolarite("informatique");
            Cours c1 = new Cours("Programmation", s1);
            Professeur p1 = new Professeur("Ravat", "Frank", "xxx@xxx.fr");
            Date date = new Date();
            Time debut1 = Time.valueOf("12:10:15");
            Time fin1 = Time.valueOf("12:30:15");
            Time debut2 = Time.valueOf("14:10:15");
            Time fin2 = Time.valueOf("14:30:15");
            Occurence o1 = new Occurence(date, debut1, fin1, p1, c1);
            Occurence o2 = new Occurence(date, debut2, fin2, p1, c1);
            session.save(s1);
            session.save(etudiant);
            session.save(c1);
            session.save(p1);
            session.save(o1);
            session.save(o2);
            t.commit();
            Gson gson = new Gson();
            System.out.println(gson.toJson(p1.getOccurences()));
        }
    }
    public static void createUser(){
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            //ouverture d'une transaction
            Transaction t = session.beginTransaction();

            User user = new User("btissam.nachir@ut1-capitole.fr", "btissama");

            session.save(user);
            t.commit();
        }
    }

    public static void main(String[] args) throws ParseException {
        Gson gson = new Gson();
        OccurenceDao dao = new OccurenceDao();
        gson.toJson(dao.get(3459));


    }
}
