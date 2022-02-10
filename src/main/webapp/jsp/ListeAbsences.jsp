<%@ page import="miage.gestionappel.metier.Occurence" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: manaa
  Date: 07/02/2022
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UT1 Capitole</title>

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/script.js" rel="script">
</head>
<%@ include file="Menu.jsp" %>
<body>
<div class="container">
    <h1>Liste des Absences</h1>

    <table id="table"
           data-toggle="table"
           data-search="true"
           data-filter-control="true"
           data-show-export="true"
           data-click-to-select="true"
           data-toolbar="#toolbar">
        <thead>
        <tr>
            <th data-field="state" data-checkbox="true"></th>
            <th data-field="prenom" data-filter-control="select" data-sortable="true">Cour</th>
            <th data-field="date" data-filter-control="select" data-sortable="true">Date</th>
            <th data-field="examen" data-filter-control="select" data-sortable="true">Heure de debut</th>
            <th data-field="examen" data-filter-control="select" data-sortable="true">Heure de fin</th>

        </tr>
        </thead>
        <tbody>


            <%
                    List<Occurence> occurences = (List<Occurence>) request.getAttribute("absencesetudiant");
                    int i = 0;
                    for (Occurence o : occurences) {
                        out.println("<tr>");
                        out.println("\n" +
                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                        out.println("<td>" + o.getCours().getNomC() + "</td>");
                        out.println("<td>" + o.getDateOc() + "</td>");
                        out.println("<td>" + o.getHeureDebutOc() + "</td>");
                        out.println("<td>" + o.getHeureFinOc() + "</td>"); }

            %>



        </tbody>
    </table>
</div>
</body>
</html>
