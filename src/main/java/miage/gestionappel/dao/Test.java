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
        EtudiantDao etudiantDao = new EtudiantDao();
        PresenterDao presenterDao = new PresenterDao();
        GroupeDao groupeDao = new GroupeDao();
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            //ouverture d'une transaction
            Transaction t = session.beginTransaction();
            Occurence occurence = occurenceDao.get(3451);
            Etudiant etudiant = etudiantDao.get(21901858);
            Groupe groupe = groupeDao.get(1);
            Set<Groupe> groupes = new HashSet<>();
            groupes.add(groupe);
            occurence.setGroupes(groupes);
            session.update(occurence);
            t.commit();
        }
    }

    public static void main (String[] args) throws ParseException
    {
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

        ProfesseurDao professeurDao = new ProfesseurDao();
        Professeur professeur = new Professeur();

        professeur = professeurDao.getByEmail("nathalie.valles-parlangeau@ut-capitole.fr");

        Set<Cours> cours = professeur.getCours();

        for (Cours c : cours) {
            System.out.println("résultat : " + c.getNomC());
        }
    }
}
