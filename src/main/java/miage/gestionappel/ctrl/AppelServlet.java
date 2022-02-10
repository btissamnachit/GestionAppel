package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.dao.PresenterDao;
import miage.gestionappel.metier.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AppelServlet extends HttpServlet {
    OccurenceDao occurenceDao = new OccurenceDao();
    PresenterDao presenterDao = new PresenterDao();
    EtudiantDao etudiantDao = new EtudiantDao();

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
                String statut = request.getParameter("statutEtudiant");
                System.out.println("stt "+statut);
               /* int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
                Etudiant etudiant = etudiantDao.get(idEtudiant);
                PrensenterId prensenterId = new PrensenterId(occurence.getIdOc(), idEtudiant);
                Presenter presenter = new Presenter(prensenterId, occurence, etudiant, statut);
                presenterDao.saveOrUpdate(presenter);*/
                break;
            case "Valider":
                occurence.setAppelValide(true);
                occurenceDao.update(occurence, null);
                for (Presenter p : occurence.getPresences()) {
                    if (p.getStatut() == "absent") {
                        sendMail(p.getEtudiant(), occurence);
                    }
                }

                // vers emploi du temps
                break;
            case "Retour":
                // vers emploi du temps
                break;

        }
    }

    protected void sendMail(Etudiant etudiant, Occurence occurence) {
        String to = etudiant.getMailE();
        String from = "bt.nachit@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("bt.nachit@gmail.com", "BTna1234");

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
            message.setText("Bonjour, Vous etes notifié absent dans la séance de date : " + occurence.getDateOc() + " entre : " + occurence.getHeureDebutOc() + " et " + occurence.getHeureDebutOc());

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }


}

