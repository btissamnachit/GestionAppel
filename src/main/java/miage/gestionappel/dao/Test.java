package miage.gestionappel.dao;

import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;

public class Test {
    public static void createEtudiant(){
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            //ouverture d'une transaction
            Transaction t = session.beginTransaction();

            Etudiant etudiant = new Etudiant("NACHIT","Btissam","btissam.nachir@ut1-capitole.fr");

            session.save(etudiant);
            t.commit();
        }
    }
    public static void main (String[] args) throws ParseException
    {
        Test.createEtudiant();

    }
}
