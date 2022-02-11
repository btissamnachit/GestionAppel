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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/print.css" type="text/css" media="print"/>
</head>

<%@ include file="Menu.jsp" %>

<body>
<!-- Begin Page Content -->
<div class="container-fluid">
    <form action='/appelServlet' method="POST">

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Liste des justificatifs</h6>
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
                            <th>Date debut</th>
                            <th>Date fin</th>
                            <th>Justificatif</th>
                            <th>Statut</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Identifiant</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Email</th>
                            <th>Date debut</th>
                            <th>Date fin</th>
                            <th>Justificatif</th>
                            <th>Statut</th>
                        </tr>
                        </tfoot>
                        <tbody>

                        <c:forEach items="${justificatifs}" var="justificatif">
                            <tr>
                                <td id="idEtudiant">${justificatif.getEtudiant().getIdE()}</td>
                                <td>${justificatif.getEtudiant().getNomE()}</td>
                                <td>${justificatif.getEtudiant().getPrenomE()}</td>
                                <td>${justificatif.getEtudiant().getMailE()}</td>
                                <td>${justificatif.getDateDebut()}</td>
                                <td>${justificatif.getDateFin()}</td>
                                <td><a class="btn btn-primary" href="${lienJust}${justificatif.getUrlj()}"
                                       role="button">Justificatif</a>
                                </td>
                                <td>
                                    <label for="statutJustificatif"> </label>
                                    <input type="hidden" value="${justificatif.getIdJ()}">
                                    <select id="statutJustificatif" name="statut"
                                            class="statutJustificatif form-control form-control-lg center"
                                            required="required">
                                        <c:choose>
                                            <c:when test="${justificatif.getStatutJustif() == 'En cours'}">
                                                <option value="En cours" selected="selected">"En cours"</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="En cours">En cours</option>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${justificatif.getStatutJustif() == 'Valide'}">
                                                <option value="Valide" selected="selected">Validée</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="Valide">Validée</option>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${justificatif.getStatutJustif() == 'Refus'}">
                                                <option value="Refus" selected="selected">Refusée</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="Refus">Refusée</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="d-flex justify-content-end row">
                        <a href="" class="btn btn-lg btn-secondary" id="retour">
                            Retour </a>

                    </div>
                </div>
            </div>
        </div>

    </form>
</div>
<!-- /.container-fluid -->
<!-- End of Main Content -->

</body>
<script type="text/JavaScript" src="${pageContext.request.contextPath}/javascript/fctxml.js"></script>
</html>

