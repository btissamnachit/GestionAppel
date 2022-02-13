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
    EtudiantDao etudiantDao = new EtudiantDao();
    SendMail sendMail= new SendMail();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String cours = request.getParameter("cours");

        int idOccurence = Integer.parseInt(request.getParameter("idOccurence"));

        Occurence occurence = occurenceDao.get(idOccurence);
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
                Set<Presenter> presenters = occurence.getPresences();
                for (Presenter p : presenters) {
                    if (p.getStatut().equals("Absent")) {
                        String to = p.getEtudiant().getMailE();
                        String objet = "[Capitole UT1] Notification d'absence";
                        String message = "<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "<head>\n" +
                                "    <title>Message</title>\n" +
                                "    <meta charset=\"UTF-8\">\n" +
                                "</head>\n" +
                                "<body><p>Bonjour,</p><p>Vous avez été absent au cours de : "+occurence.getCours().getNomC()+" le " + displayFormat.format(occurence.getDateOc())+"</p>";
                        sendMail.sendMail(to,objet, message);
                    }
                }
                response.sendRedirect("/calendarServlet?week=thisWeek");

                // vers emploi du temps
                break;

        }
    }

}

