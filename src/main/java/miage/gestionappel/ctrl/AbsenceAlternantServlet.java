package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.dao.ProfesseurDao;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Occurence;
import miage.gestionappel.metier.Professeur;
import miage.gestionappel.util.DateManipulation;
import org.joda.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AbsenceAlternantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { HttpSession session = request.getSession(true);


        List<Occurence> absences = new ArrayList<>();
        List<Occurence> absencesJanvier = new ArrayList<>();
        List<Occurence> absencesFevrier = new ArrayList<>();
        List<Occurence> absencesMars = new ArrayList<>();
        List<Occurence> absencesAvril = new ArrayList<>();
        List<Occurence> absencesMai = new ArrayList<>();
        List<Occurence> absencesJuin = new ArrayList<>();
        List<Occurence> absencesJuillet = new ArrayList<>();
        List<Occurence> absencesAout = new ArrayList<>();
        List<Occurence> absencesSeptembre = new ArrayList<>();
        List<Occurence> absencesOctobre = new ArrayList<>();
        List<Occurence> absencesNovembre = new ArrayList<>();
        List<Occurence> absencesDecembre = new ArrayList<>();

        String email = (String)session.getAttribute("email");

        EtudiantDao etudiantDao = new EtudiantDao();
        OccurenceDao occurencedao = new OccurenceDao();

        Etudiant etudiant = etudiantDao.getByEmail(email);

        absences = etudiantDao.getAllAbsence(etudiant);
        for (Occurence absence : absences) {

            if (occurencedao.getMoisOccurence(absence).equals("01")){
                absencesJanvier.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("02")){
                absencesFevrier.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("03")){
                absencesMars.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("04")){
                absencesAvril.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("05")){
                absencesMai.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("06")){
                absencesJuin.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("07")){
                absencesJuillet.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("08")){
                absencesAout.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("09")){
                absencesSeptembre.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("10")){
                absencesOctobre.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("11")){
                absencesNovembre.add(absence);
            }
            if (occurencedao.getMoisOccurence(absence).equals("12")){
                absencesDecembre.add(absence);
            }

        request.setAttribute("absencesetudiant", absences);
            request.setAttribute("absencesjanvier", absencesJanvier);
            request.setAttribute("absencesfevrier", absencesFevrier);
            request.setAttribute("absencesmars", absencesMars);
            request.setAttribute("absencesavril", absencesAvril);
            request.setAttribute("absencesmai", absencesMai);
            request.setAttribute("absencesjuin", absencesJuin);
            request.setAttribute("absencesjuillet", absencesJuillet);
            request.setAttribute("absencesaout", absencesAout);
            request.setAttribute("absencesseptembre", absencesSeptembre);
            request.setAttribute("absencesoctobre", absencesOctobre);
            request.setAttribute("absencesnovembre", absencesNovembre);
            request.setAttribute("absencesdecembre", absencesDecembre);
        request.getRequestDispatcher("/absencesalternant").forward(request, response);
    }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
