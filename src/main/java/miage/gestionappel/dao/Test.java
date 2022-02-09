package miage.gestionappel.dao;

import miage.gestionappel.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void createUser() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            User user1 = new User("btissam.nachit@ut1-capitole.fr", "NACHIT", "Btissam", "Etudiant");
            session.save(user1);
            User user2 = new User("Eric.Andonoff@ut-capitole.fr", "NACHIT", "Btissam", "Etudiant");
            session.save(user1);
            t.commit();
        }
    }

    public static void createEtudiant() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            //ouverture d'une transaction
            Transaction t = session.beginTransaction();

            Etudiant etudiant1 = new Etudiant("NACHIT", "Btissam", "btissam.nachit@ut1-capitole.fr");
            session.save(etudiant1);
            Etudiant etudiant2 = new Etudiant("MANA", "Anis", "anis.mana@ut1-capitole.fr");
            session.save(etudiant2);
            Etudiant etudiant3 = new Etudiant("MARIE-SAINT", "Miguel", "miguel.marie-saint@ut1-capitole.fr");
            session.save(etudiant3);
            t.commit();
        }
    }


    public static void createOccurence() {
        OccurenceDao occurenceDao = new OccurenceDao();

        Occurence occurence = occurenceDao.getOc(3451);
        for (Presenter p : occurence.getPresences()) {
            System.out.println("hhhhhh : " + p.getEtudiant().getNomE());
        }
    }

    public static void main(String[] args) throws ParseException {
//
//        ProfesseurDao pf = new ProfesseurDao();
//        Professeur p ;
//        p = pf.getByEmail("nathalie.valles-parlangeau@ut-capitole.fr");
//        Set<Cours> lc =  p.getCours();
//        System.out.println("résultat1 : " + lc);
//        ArrayList<Cours> liste = new ArrayList<Cours>(lc);
//        System.out.println("résultat2 : " + liste);
//        ArrayList<String> lnomcours = new ArrayList<>();
//        System.out.println("résultat3 : " + lnomcours);
//        for (int i = 0; i < liste.size(); i++) {
//            String nomC = liste.get(i).getNomC();
//            System.out.println("résultat4 : " + nomC);
//            lnomcours.add(nomC);
//            System.out.println("résultat5 : " + lnomcours);
//
//            for(int j=0; j < lnomcours.size();j++) {
//                System.out.println("résultat6 : " + lnomcours.get(j));
//            }
//        }

   Test.createUser();
    }
}