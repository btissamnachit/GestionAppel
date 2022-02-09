package miage.gestionappel.dao;

import miage.gestionappel.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void createUser(){
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            Transaction t = session.beginTransaction();
            User user1 = new User("btissam.nachit@ut1-capitole.fr","NACHIT","Btissam","Etudiant");
            session.save(user1);
            User user2 = new User("Eric.Andonoff@ut-capitole.fr","NACHIT","Btissam","Etudiant");
            session.save(user1);
            t.commit();
        }
    }
    public static void createEtudiant(){
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            //ouverture d'une transaction
            Transaction t = session.beginTransaction();

            Etudiant etudiant1 = new Etudiant("NACHIT","Btissam","btissam.nachit@ut1-capitole.fr");
            session.save(etudiant1);
            Etudiant etudiant2 = new Etudiant("MANA","Anis","anis.mana@ut1-capitole.fr");
            session.save(etudiant2);
            Etudiant etudiant3 = new Etudiant("MARIE-SAINT","Miguel","miguel.marie-saint@ut1-capitole.fr");
            session.save(etudiant3);
            t.commit();
        }
    }


    public static void createOccurence(){
        OccurenceDao occurenceDao = new OccurenceDao();

        Occurence occurence = occurenceDao.getOc(3451);
        for (Presenter p: occurence.getPresences() ){
            System.out.println("hhhhhh : "+p.getEtudiant().getNomE());
        }
    }

    public static void createPresenter(){
        OccurenceDao occurenceDao = new OccurenceDao();
        PresenterDao presenterDao = new PresenterDao();
        EtudiantDao etudiantDao = new EtudiantDao();
        Occurence occurence = occurenceDao.get(3452);
        Etudiant etudiant = etudiantDao.get(1);
        System.out.println(etudiant.toString());
        Presenter presenter = new Presenter(occurence,etudiant,"absent");
        presenterDao.saveOrUpdate(presenter);
    }

    public static void main (String[] args) throws ParseException
    {
        Test.createPresenter();
    }
}
