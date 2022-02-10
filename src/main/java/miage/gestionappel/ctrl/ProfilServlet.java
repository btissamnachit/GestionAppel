package miage.gestionappel.ctrl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
/* The Java file upload Servlet example */

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ProfilServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Receive file uploaded to the Servlet from the HTML5 form */
        Part filePart = request.getPart("fichier");
        String fileName = filePart.getSubmittedFileName();
        for (Part part : request.getParts()) {
            part.write("C:\\Users\\manaa\\IdeaProjects\\GestionAppel\\src\\main\\webapp\\imagephoto");
        }
        response.getWriter().print("The file uploaded sucessfully.");
//        request.getRequestDispatcher("profil").forward(request,response);
        response.sendRedirect("profil");
    }



}