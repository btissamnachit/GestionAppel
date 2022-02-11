package miage.gestionappel.dao;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import miage.gestionappel.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

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

        document.close();

    }
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        CoursDao coursDao = new CoursDao();
        ProfesseurDao professeurDao = new ProfesseurDao();
        Cours cours = coursDao.get(1231);
        EtudiantDao etudiantDao = new EtudiantDao();
        Professeur professeur = professeurDao.get(2322);
        System.out.println(coursDao.getEtudiantsAbsentistes(cours));
        HashMap<Cours, Long> nbAbsence = new HashMap<>();
        HashMap<Cours, Double> moyenneAbsence = new HashMap<>();
        HashMap<Cours, List<Etudiant>> etudiantsAbsenteistes = new HashMap<>();
        HashMap<Etudiant, Integer> absenceEtudiantGlobal = new HashMap<>();
        long absensesCours = coursDao.nbAbsence(cours);
        double moyenneAbsenceCours = coursDao.moyenneAbscence(cours);
        List<Etudiant> etudiantsAbsenteistesCours = coursDao.getEtudiantsAbsentistes(cours);
        nbAbsence.put(cours, absensesCours);
        moyenneAbsence.put(cours, moyenneAbsenceCours);
        etudiantsAbsenteistes.put(cours, etudiantsAbsenteistesCours);
        for (Etudiant etudiantAbsenteiste : etudiantsAbsenteistesCours) {
            if (!absenceEtudiantGlobal.entrySet().contains(etudiantAbsenteiste)) {
                int nbAbsencesEtudiantGlobal = etudiantDao.getAllAbsence(etudiantAbsenteiste).size();
                absenceEtudiantGlobal.put(etudiantAbsenteiste, nbAbsencesEtudiantGlobal);
            }
        }
        System.out.println(etudiantsAbsenteistes.containsKey(cours));
    }

    }
