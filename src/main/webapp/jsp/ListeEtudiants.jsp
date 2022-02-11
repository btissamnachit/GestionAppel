<%--
  Created by IntelliJ IDEA.
  User: manaa
  Date: 08/02/2022
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="static java.lang.System.out" %>
<%@ page import="miage.gestionappel.metier.Cours" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="miage.gestionappel.metier.Etudiant" %>
<%@ page import="java.util.List" %>


<html>
<head>
    <title>Mes cours</title>
</head>
<body>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UT1 Capitole</title>

    <link href="${pageContext.request.contextPath}/assets/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/styleCours.css" rel="stylesheet">
</head>
<%@ include file="Menu.jsp" %>
<body>
<!-- Begin Page Content -->
<div class="container-fluid">
    <section>
        <h1>
            Mes cours
        </h1>
        <%
            Set<Cours> cours = (Set<Cours>) request.getAttribute("cours");
            HashMap<Cours, Long> nbAbsences = (HashMap<Cours, Long>) request.getAttribute("nbAbsence");
            HashMap<Cours, Double> moyenneAbsence = (HashMap<Cours, Double>) request.getAttribute("moyenneAbsence");
            HashMap<Cours, List<Etudiant>> etudiantsAbsenteistes = (HashMap<Cours, List<Etudiant>>) request.getAttribute("etudiantsAbsenteistes");
            System.out.println(etudiantsAbsenteistes.keySet());
            HashMap<Etudiant, Integer> absenceEtudiantGlobal = (HashMap<Etudiant, Integer>) request.getAttribute("absenceEtudiantGlobal");
            for (Cours matiere : cours) {
                System.out.println(matiere);
                out.println("<details><summary> " + matiere.getNomC() + "</summary>");
                out.println("<table>\n" +
                        "                <thead>\n" +
                        "                <tr>\n" +
                        "                    <th colspan=\"2\">Absentéisme</th>\n" +
                        "                </tr>\n" +
                        "                </thead>\n" +
                        "                <tbody>\n" +
                        "                <tr>\n" +
                        "                    <td>Nombre d'absences au total</td>\n" +
                        "                    <td>" + nbAbsences.get(matiere) + "</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                    <td>Nombre moyen d'absence </td>\n" +
                        "                    <td>" + moyenneAbsence.get(matiere) + "</td>\n" +
                        "                </tr>\n" +
                        "                </tbody>\n" +
                        "            </table>");
                System.out.println(etudiantsAbsenteistes.containsKey(cours));
                if ((etudiantsAbsenteistes.containsKey(matiere))) {
                    out.println("<table>\n" +
                            "                <thead>\n" +
                            "                <tr>\n" +
                            "                    <th colspan=\"3\">Etudiant Absenteiste</th>\n" +
                            "                </tr>\n" +
                            "                </thead>\n" +
                            "                <tbody>\n" +
                            "                <tr>\n" +
                            "                    <td>Numéro etudiant</td>\n" +
                            "                    <td>Nom Prénom</td>\n" +
                            "                    <td>Total d'absences globales</td>\n" +
                            "                </tr>\n");

                    for (Etudiant etudiantAbsenteiste : etudiantsAbsenteistes.get(matiere)) {

                        out.println("<tr>\n" +
                                "                   <td><a href='listeabsenceservlet?idE=" + etudiantAbsenteiste.getIdE() + "'> " + etudiantAbsenteiste.getIdE() + "</a></td>\n" +
                                "                    <td>" + etudiantAbsenteiste.getNomE() + " " + etudiantAbsenteiste.getPrenomE() + "</td>\n" +
                                "                    <td>" + absenceEtudiantGlobal.get(etudiantAbsenteiste) + "</td></a>\n" +
                                "                </tr>\n");
                    }
                    out.println("                </tbody>\n" +
                            "            </table>");
                }
                out.println("</details>");
            }

        %>
    </section>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
</body>
</html>

