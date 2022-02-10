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
<div class="container">
    <h1>Liste des Absences</h1>

    <div id="toolbar">
        <select class="form-control">
            <option value="">Export Basic</option>
            <option value="all">Export All</option>
            <option value="selected">Export Selected</option>
        </select>
    </div>

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
        <c:forEach items="${absencesetudiant}" var="absence">

            <tr>
                <td class="bs-checkbox "><input data-index="0" name="btSelectItem" type="checkbox"></td>
                <td>${absence.getCours().getNomC()}----------</td>
                <td>${absence.getDateOc()}--------------</td>
                <td>${absence.getHeureDebutOc()}-----------</td>
                <td>${absence.getHeureFinOc()}---------</td>
            </tr>

            <a href="#" class="list-group-item list-group-item-action">[${absence.getDateOc()}: de ${absence.getHeureDebutOc()} à ${absence.getHeureFinOc()}]</a>

        </c:forEach>


        </tbody>
    </table>
</div>
</body>
<script>
    //exporte les données sélectionnées
    var $table = $('#table');
    $(function () {
        $('#toolbar').find('select').change(function () {
            $table.bootstrapTable('refreshOptions', {
                exportDataType: $(this).val()
            });
        });
    })

    var trBoldBlue = $("table");

    $(trBoldBlue).on("click", "tr", function (){
        $(this).toggleClass("bold-blue");
    });
</script>
</html>
