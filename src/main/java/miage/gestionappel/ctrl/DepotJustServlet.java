package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.HibernateUtil;
import miage.gestionappel.dao.JustificatifDao;
import miage.gestionappel.dao.PresenterDao;
import miage.gestionappel.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@MultipartConfig(maxFileSize = 16777215)
public class DepotJustServlet extends HttpServlet {
    EtudiantDao etudiantDao = new EtudiantDao();
    PresenterDao presenterDao = new PresenterDao();
    SendMail sendMail= new SendMail();
    JustificatifDao justificatifDao = new JustificatifDao();
    private static final long serialVersionUID = 1L;
  //  ${pageContext.request.contextPath}
    public static final String CHEMIN_FICHIERS = "D:\\Projet JEE\\GestionAppel\\src\\main\\webapp\\justificatif\\";
    private final SimpleDateFormat displayFormat = new SimpleDateFormat("EEEE, dd/MM");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        String role = (String) session.getAttribute("role");

        List<Justificatif> justificatifList = justificatifDao.getAll();
        request.setAttribute("justificatifs", justificatifList);
        request.setAttribute("lienJust", CHEMIN_FICHIERS);
        switch (action){
            case "Afficher":
                if(role.equals("scolarite"))
                request.getRequestDispatcher("/consultationJustif").forward(request, response);
                else if(role.equals("etudiant")){
                    String email = (String) session.getAttribute("email");
                    Etudiant etudiant = etudiantDao.getByEmail(email);
                    request.setAttribute("etudiant",etudiant);
                    request.getRequestDispatcher("/consultationJustifEtudiant").forward(request, response);
                }
                break;
            case "AfficherJustificatif":
                recupererJustificatifEnLocal(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        switch (action) {
            case "EnregistrerJustificatif":
                try {
                    String filename = enregistrerJustificatifEnLocal(request, response);
                    Date dateDebut = new SimpleDateFormat("dd-MM-yy").parse(request.getParameter("debutPeriode"));
                    Date dateFin = new SimpleDateFormat("dd-MM-yy").parse(request.getParameter("finPeriode"));
                    String email = (String) session.getAttribute("email");
                    Etudiant etudiant = etudiantDao.getByEmail(email);
                    Justificatif justificatif = new Justificatif("En cours", filename, dateDebut, dateFin, etudiant);
                    justificatifDao.save(justificatif);

                    //envoie de mail à la scolarité
                    String objet = "[Capitole UT1] Notification d'absence";
                    String message = "<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "    <title>Message</title>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "</head>\n" +
                            "<body><p>Bonjour,</p><p>L'etudiant " + etudiant.getNomE() + " " + etudiant.getPrenomE() + ",INE : " + etudiant.getIdE() + " a diposé une justificatif pour la période suivante : entre le " + displayFormat.format(dateDebut) + " et le " + displayFormat.format(dateFin) + "</p>";
                    sendMail.sendMail("scolarite@ut-capitole.fr", objet, message);

                    String msg_avert = "Votre justificatif a été transmis à la scolarité";
                    request.setAttribute("msg_a", msg_avert);
                    List<Justificatif> justificatifList = justificatifDao.getAll();
                    request.setAttribute("justificatifs", justificatifList);
                    request.setAttribute("lienJust", CHEMIN_FICHIERS);
                    request.setAttribute("etudiant", etudiant);
                    request.getRequestDispatcher("/consultationJustifEtudiant").forward(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "EnregistrerStatutJustificatif":
                String statut = request.getParameter("statut");
                int idJustificatif = Integer.parseInt(request.getParameter("idJustificatif"));
                Justificatif justificatif = justificatifDao.get(idJustificatif);
                justificatif.setStatutJustif(statut);
                justificatifDao.update(justificatif, null);
                List<Presenter> presenters = presenterDao.getAll();
                for (Presenter presenter: presenters ) {
                    if(presenter.getEtudiant().getIdE() == justificatif.getEtudiant().getIdE()){
                        Occurence occurence = presenter.getOccurence();
                        if((occurence.getDateOc().compareTo(justificatif.getDateDebut()) >= 0) && (occurence.getDateOc().compareTo(justificatif.getDateFin()) <= 0) ){
                                presenter.setStatut("Absence justifie");
                                presenterDao.saveOrUpdate(presenter);
                        }
                    }
                }

                break;
        }

    }

    protected String enregistrerJustificatifEnLocal(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        final long serialVersionUID = 1L;

        String description = request.getParameter("description");
        request.setAttribute("description", description);
        String debutPeriode = request.getParameter("debutPeriode");
        request.setAttribute("debutPeriode", debutPeriode);
        String finPeriode = request.getParameter("finPeriode");
        request.setAttribute("finPeriode", finPeriode);

        String filename = "justificatif_" + description + ".pdf";

        Part part = request.getPart("fichier");
        InputStream is = null;
        if (part != null)
            is = part.getInputStream();

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(new File(CHEMIN_FICHIERS + filename));

            byte[] buffer = new byte[8192];
            int readBytes = -1;

            while ((readBytes = is.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, readBytes);
            }
            is.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return filename;
    }


    protected void recupererJustificatifEnLocal(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String description = request.getParameter("description");
        request.setAttribute("description", description);

        OutputStream is = response.getOutputStream();

        try {
            String filename = description;
            FileInputStream fileInputStream = new FileInputStream(new File( CHEMIN_FICHIERS+ filename));

            byte[] buffer = new byte[8192];
            int readBytes = -1;

            while ((readBytes = fileInputStream.read(buffer)) != -1) {
                is.write(buffer, 0, readBytes);
            }
            fileInputStream.close();
            is.flush();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}

