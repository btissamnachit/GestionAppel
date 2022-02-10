package miage.gestionappel.ctrl;

import miage.gestionappel.metier.Justificatif;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig(maxFileSize = 16777215)
public class GetJustServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final long serialVersionUID = 1L;

        Justificatif justificatif = new Justificatif();
        justificatif.setIdJ(Integer.parseInt(request.getParameter("idj")));


        OutputStream is = response.getOutputStream();


        try {
            String filename = "justificatif_" + justificatif.getIdJ() + ".pdf";
            FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\radoa\\Downloads\\Test\\" + filename));

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {








    }
}
