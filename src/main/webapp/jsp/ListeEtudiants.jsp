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


<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
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
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<%@ include file="Menu.jsp" %>
<body>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Liste des Etudiants</h1>

    <label for="selectCours">Choisir une mati&eacute;re:</label>

    <select id="selectCours" name="NomC" class="form-control form-control-lg center ">
        <option>-- Choisir une mati&eacute;re --</option>
        <c:forEach items="${cours}" var="cours">
            <option value="${cours.getIdC()}">${cours.getNomC()}</option>
        </c:forEach>
    </select>
    <select id="selectOccurences" name="NomC" class="form-control form-control-lg center">
        <option>----</option>
    </select>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Liste des etudiants</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
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
                    <tbody id="listEtudiant">
                    <tr>
                        <td colspan="4"><b class="text-sm-center">La liste est vide, vous pouvez choisir le cours à afficher.</b></td>

                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
</body>
</html>
<script type="text/JavaScript" src="${pageContext.request.contextPath}/javascript/fctxml.js"></script>
