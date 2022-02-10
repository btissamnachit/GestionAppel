<%--
  Created by IntelliJ IDEA.
  User: btissam NACHIT
  Date: 07/02/2022
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UT1 Capitole</title>

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/print.css" type="text/css" media="print" />
</head>

<%@ include file="Menu.jsp" %>

<body>
<!-- Begin Page Content -->
<div class="container-fluid">
    <form action='/appelServlet' method="POST">
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Cours : ${cours}                ${date} de ${debut}
            à ${fin}</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Liste des Etudiants </h6>
            </div>
            <div id="alert"></div>
            <div class="card-body">
                <div class="">
                    <table class="table table-bordered" id="dataTable">
                        <thead>
                        <tr>
                            <th>Identifiant</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Email</th>
                            <th>Statut</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Identifiant</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Email</th>
                            <th>Statut</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:if test="${isValide}">
                            <c:forEach items="${presences}" var="presence">
                                <tr>
                                    <td>${presence.getEtudiant().getIdE()}</td>
                                    <td>${presence.getEtudiant().getNomE()}</td>
                                    <td>${presence.getEtudiant().getPrenomE()}</td>
                                    <td>${presence.getEtudiant().getMailE()}</td>
                                    <td>${presence.getStatut()}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${!isValide}">
                            <c:forEach items="${groupes}" var="groupe">
                                <c:forEach items="${groupe.getEtudiants()}" var="etudiant">
                                    <tr>
                                        <td id="idEtudiant">${etudiant.getIdE()}</td>
                                        <td>${etudiant.getNomE()}</td>
                                        <td>${etudiant.getPrenomE()}</td>
                                        <td>${etudiant.getMailE()}</td>
                                        <td>
                                            <label for="statutEtudiant"> </label>
                                            <input type="hidden" value="${etudiant.getIdE()}">
                                            <c:set var="target" value="false" scope="page"></c:set>
                                            <select id="statutEtudiant" name="statut"
                                                    class="statutEtudiant form-control form-control-lg center" required="required">
                                                <option  value="">-- Choisissez un statut --</option>
                                                <c:forEach items="${presences}" var="presence">

                                                    <c:if test="${presence.getEtudiant().getIdE() == etudiant.getIdE()}">

                                                        <c:set var="target" value="true" scope="page"></c:set>
                                                        <c:choose>
                                                            <c:when test="${presence.getStatut() == 'Present'}">
                                                                <option value="Present" selected="selected">Présent </option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="Present">Présent</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:choose>
                                                            <c:when test="${presence.getStatut() == 'Absent'}">
                                                                <option value="Absent" selected="selected">Absent </option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="Absent">Absent</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:choose>
                                                            <c:when test="${presence.getStatut() == 'En retard'}">
                                                                <option value="En retard" selected="selected">En retard</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="En retard">En retard</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!target}">
                                                    <option value="Present">Présent</option>
                                                    <option value="Absent">Absent</option>
                                                    <option value="En retard">En retard</option>
                                                </c:if>
                                            </select>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                    <div class="d-flex justify-content-end row">
                        <a href="calendarServlet?week=thisWeek" class="btn btn-lg btn-secondary" id = "retour"> Retour </a>
                        <c:if test="${!isValide}">
                            <input class="btn btn-lg btn-primary" type="submit" id = "valider" name="action" value="Valider"/>
                        </c:if>
                        <c:if test="${isValide}">
                            <input class="btn btn-lg btn-dark" type="button" id = "impression" onclick="imprimer_page()" name="impression" value="Imprimer"/>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

    </form>
</div>
<!-- /.container-fluid -->
<!-- End of Main Content -->

</body>
<script type="text/javascript">
    function imprimer_page(){
        window.print();
    }
</script>
<script type="text/JavaScript" src="${pageContext.request.contextPath}/javascript/fctxml.js"></script>
</html>

