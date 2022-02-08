package miage.gestionappel.ctrl;

import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.metier.Occurence;
import miage.gestionappel.metier.Presenter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AppelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OccurenceDao occurenceDao = new OccurenceDao();

        String cours = request.getParameter("cours");
        int idOccurence = Integer.parseInt(request.getParameter("idOccurence"));
        System.out.println(idOccurence);
        Occurence occurence = occurenceDao.getOc(idOccurence);
      /*  Presenter presence =

        Set<Presenter> presences = occurence.getPresences();
        System.out.println("hhhhhh : "+presences.toString());

        for (Presenter p: presences ){
            System.out.println("hhhhhh : "+p.getEtudiant().getNomE());
        }

        request.setAttribute("presences", presences);
        request.getRequestDispatcher("/listeEtudiantsSeance").forward(request,response);

*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
