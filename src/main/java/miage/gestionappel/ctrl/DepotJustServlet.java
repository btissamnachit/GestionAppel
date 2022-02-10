package miage.gestionappel.ctrl;

import miage.gestionappel.dao.HibernateUtil;
import miage.gestionappel.metier.Justificatif;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;

@MultipartConfig(maxFileSize = 16777215)
public class DepotJustServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    public static final String CHEMIN_FICHIERS = "C:\\Users\\radoa\\Downloads\\Test\\";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final long serialVersionUID = 1L;

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

        final long serialVersionUID = 1L;

        String description = request.getParameter("description");
        request.setAttribute("description", description);
        String debutPeriode = request.getParameter("debutPeriode");
        request.setAttribute("debutPeriode", debutPeriode);
        String finPeriode = request.getParameter("finPeriode");
        request.setAttribute("finPeriode", finPeriode);

        Part part = request.getPart("fichier");
        InputStream is = null;
        if (part != null)
            is = part.getInputStream();

        try {
            String filename = "justificatif_" + description + ".pdf";
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

        response.sendRedirect("/depotjustificatif");

//        Transaction tx = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()){
//            tx = session.beginTransaction();
//            session.persist();
//            tx.commit();
//
//        }catch(Exception e){

        }
    }

