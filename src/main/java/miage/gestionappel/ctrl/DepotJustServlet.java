package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.HibernateUtil;
import miage.gestionappel.dao.JustificatifDao;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Justificatif;
import miage.gestionappel.metier.Occurence;
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
import java.util.Properties;

@MultipartConfig(maxFileSize = 16777215)
public class DepotJustServlet extends HttpServlet {
    EtudiantDao etudiantDao = new EtudiantDao();
    SendMail sendMail= new SendMail();
    JustificatifDao justificatifDao = new JustificatifDao();
    private static final long serialVersionUID = 1L;
  //  ${pageContext.request.contextPath}
    public static final String CHEMIN_FICHIERS = "D:\\Projet JEE\\GestionAppel\\src\\main\\webapp\\justificatif\\";
    private final SimpleDateFormat displayFormat = new SimpleDateFormat("EEEE, dd/MM");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        request.setAttribute("description", description);
        String debutPeriode = request.getParameter("debutPeriode");
        request.setAttribute("debutPeriode", debutPeriode);
        String finPeriode = request.getParameter("finPeriode");
        request.setAttribute("finPeriode", finPeriode);

        OutputStream is = response.getOutputStream();

        try {
            String filename = "justificatif_"  + description + ".pdf";
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
        response.sendRedirect("/depotjustificatif");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(true);
            String filename = enregistrerJustificatifEnLocal(request,response);
            Date dateDebut = new SimpleDateFormat("dd-MM-yy").parse(request.getParameter("debutPeriode"));
            Date dateFin = new SimpleDateFormat("dd-MM-yy").parse(request.getParameter("finPeriode"));
            String email = (String) session.getAttribute("email");
            Etudiant etudiant = etudiantDao.getByEmail(email);
            Justificatif justificatif = new Justificatif("En cours",CHEMIN_FICHIERS+filename,dateDebut,dateFin,etudiant);
            justificatifDao.save(justificatif);

            //envoie de mail à la scolarité
            String objet = "[Capitole UT1] Notification d'absence";
            String message = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>Message</title>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "</head>\n" +
                    "<body><p>Bonjour,</p><p>L'etudiant "+ etudiant.getNomE()+ " "+ etudiant.getPrenomE() + ",INE : "+etudiant.getIdE()+" a diposé une justificatif pour la période suivante : entre le "+displayFormat.format(dateDebut)+" et le "+displayFormat.format(dateFin)+"</p>";
            sendMail.sendMail("scolarite@ut-capitole.fr",objet, message);
        } catch (ParseException e) {
            e.printStackTrace();
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



}

