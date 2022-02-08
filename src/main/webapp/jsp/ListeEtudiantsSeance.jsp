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
<body>


<!-- Begin Page Content -->
<div class="container-fluid">
    <form>
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Cours : [Séance : ]</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Liste des Etudiants </h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
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
                        <tr>
                            <td>Shou Itou</td>
                            <td>Regional Marketing</td>
                            <td>Tokyo</td>
                            <td>20</td>
                            <td>
                                <select id="statut" name="statut" class="form-select form-select-lg mb-3">
                                    <option value="Present" selected>Présent</option>
                                    <option value="Absent">Absent</option>
                                    <option value="En retard">En retard</option>
                                </select>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="d-flex justify-content-end">
                        <button class="btn btn-lg btn-primary" type="submit">
                            Enregistrer
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </form>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

</body>
</html>
