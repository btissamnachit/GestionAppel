package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.dao.PresenterDao;
import miage.gestionappel.metier.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Set;

public class AppelServlet extends HttpServlet {
    private final SimpleDateFormat displayFormat = new SimpleDateFormat("EEEE, dd/MM");
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    OccurenceDao occurenceDao = new OccurenceDao();
    PresenterDao presenterDao = new PresenterDao();
    EtudiantDao etudiantDao = new EtudiantDao();;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String cours = request.getParameter("cours");

        int idOccurence = Integer.parseInt(request.getParameter("idOccurence"));

        Occurence occurence = occurenceDao.getOc(idOccurence);
        if (occurence.getAppelValide()) {
            Set<Presenter> presences = occurence.getPresences();
            request.setAttribute("presences", presences);
        } else {
            Set<Presenter> presences = occurence.getPresences();
            request.setAttribute("presences", presences);
            Set<Groupe> groupes = occurence.getGroupes();
            request.setAttribute("groupes", groupes);
        }
        session.setAttribute("occurence", occurence);
        request.setAttribute("date", displayFormat.format(occurence.getDateOc()));
        request.setAttribute("debut", timeFormat.format(occurence.getHeureDebutOc()));
        request.setAttribute("fin", timeFormat.format(occurence.getHeureFinOc()));
        request.setAttribute("cours", cours);
        request.setAttribute("isValide", occurence.getAppelValide());
        request.getRequestDispatcher("/listeEtudiantsSeance").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Occurence occurence = (Occurence) session.getAttribute("occurence");
        String action = request.getParameter("action");
        switch (action) {
            case "EnregistrerEtudiant":
                String statut = request.getParameter("statut");
                int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
                Etudiant etudiant = etudiantDao.get(idEtudiant);
                PrensenterId prensenterId = new PrensenterId(occurence.getIdOc(), idEtudiant);
                Presenter presenter = new Presenter(prensenterId, occurence, etudiant, statut);
                presenterDao.saveOrUpdate(presenter);
                break;
            case "Valider":
                occurence.setAppelValide(true);
                occurenceDao.update(occurence, null);
                System.out.println("validéé"+occurence.getPresences());
                Set<Presenter> presenters = occurence.getPresences();
                for (Presenter p : presenters) {
                    if (p.getStatut().equals("Absent")) {
                        sendMail(p.getEtudiant(), occurence);
                    }
                }
                response.sendRedirect("/calendarServlet?week=thisWeek");

                // vers emploi du temps
                break;

        }
    }
    /**
     * Fonction sendMail
     * */
    protected void sendMail(Etudiant etudiant, Occurence occurence) {
        String to = etudiant.getMailE();
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
            message.setContent("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>Message</title>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "</head>\n" +
                    "<body><p>Bonjour,</p><p>Vous avez été absent au cours de : "+occurence.getCours().getNomC()+" le " + displayFormat.format(occurence.getDateOc())+"</p>","text/html") ;

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }


}

