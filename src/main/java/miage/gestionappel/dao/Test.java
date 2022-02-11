package miage.gestionappel.dao;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import miage.gestionappel.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


    public static final String DEST ="results/pdf/hello_world.pdf";

    public void createPdf (String destination) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream(DEST);
        PdfWriter writer = new PdfWriter(fos);

        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);

        document.add(new Paragraph("Hello World!"));


        document.add(new Paragraph("Hello World!"));

        document.close();

    }
    public static void main(String[] args) throws ParseException, FileNotFoundException {

//        private LocalDate dateNow;
//        private DateTime startOfTheWeek;
//        private DateTime endOfTheWeek;
//        private final SimpleDateFormat dateNameFormat = new SimpleDateFormat("EEEE");
//        private final DateTimeFormatter localDateFormat = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zzz yyyy");
        EtudiantDao ed = new EtudiantDao();
        Etudiant etu;

        OccurenceDao od = new OccurenceDao();
        etu=ed.getByEmail("anis.mana@ut-capitole.fr");
//
        List<Occurence> absences = ed.getAllAbsence(etu);

        String mois = od.getMoisOccurence(absences.get(0));


        System.out.println(absences.get(0).getDateOc());
        System.out.println(mois);

        List<Occurence> absencesnov = new ArrayList<>();
        if (mois.equals("11")){

            absencesnov.add(absences.get(0));
        }
        System.out.println(absencesnov);
//
//        for (Occurence absence : absences){
//
//
//
//        };

        }
//        File file = new File(DEST);
//        file.getParentFile().mkdirs();
//        new Test().createPdf(DEST);
//




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




    }