package miage.gestionappel.dao;

import miage.gestionappel.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.ParseException;
import java.util.*;

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

    private static void sendMail() {
        System.out.println("hi mail");
        String to = "btissam.nachit@ut-capitole.fr";
        System.out.println("to : "+ to);
        String from = "absence.utcapitole@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.auth.plain.disable", "true");

        // Get the Session object.// and pass username and password
        javax.mail.Session session = javax.mail.Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("absence.utcapitole@gmail.com", "ut1-cap1234");

            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("[Capitole UT1] Notification d'absence");

            // Now set the actual message
            message.setText("Bonjour, Vous etes notifié absent dans la séance de date :  entre : et ");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
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

        sendMail();
    }}