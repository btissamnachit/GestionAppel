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
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.css'>
    <link rel='stylesheet'
          href='https://rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css'>

    <link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/script.js" rel="script">
</head>
<%@ include file="Menu.jsp" %>
<body>
<div class="container">
    <h1>Liste des Absences</h1>

    <div class="accordion" id="accordionExample">
        <div class="card">
            <div class="card-header" id="headingOne">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Janvier
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">

                    <%
                        List<Occurence> occurencesjanvier = (List<Occurence>) request.getAttribute("absencesjanvier");
                        int i = 0;
                        if (!(occurencesjanvier == null)) {
                            for (Occurence o : occurencesjanvier) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("Cours :" + o.getCours().getNomC());
                                out.println("date " + o.getDateOc());
                                out.println("de " + o.getHeureDebutOc());
                                out.println("a " + o.getHeureFinOc());
                                i = i + 1;
                            }

                            out.println("vous avez " + i + " absence(s) pour ce mois");
                        }
                        if (occurencesjanvier.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="headingtwo">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Fevrier
                    </button>
                </h5>
            </div>

            <div id="collapsetwo" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">


                    <%
                        List<Occurence> occurencesfevrier = (List<Occurence>) request.getAttribute("absencesfevrier");
                        int i1 = 0;
                        if (!(occurencesfevrier == null)) {
                            for (Occurence o : occurencesfevrier) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i1 = i1 + 1;
                            }

                            out.println("vous avez " + i1 + " absence(s) pour ce mois");
                        }
                        if (occurencesfevrier.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading3">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Mars
                    </button>
                </h5>
            </div>

            <div id="collapse3" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">

                    <%
                        List<Occurence> occurencesmars = (List<Occurence>) request.getAttribute("absencesmars");
                        int i2 = 0;
                        if (!(occurencesmars == null)) {
                            for (Occurence o : occurencesmars) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i2 = i2 + 1;
                            }
                            out.println("vous avez " + i2 + " absence(s) pour ce mois");
                        }
                        if (occurencesmars.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading4">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Avril
                    </button>
                </h5>
            </div>

            <div id="collapse4" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">


                    <%
                        List<Occurence> occurencesavril = (List<Occurence>) request.getAttribute("absencesjanvier");
                        int i3 = 0;
                        if (!(occurencesavril == null)) {
                            for (Occurence o : occurencesavril) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i3 = i3 + 1;
                            }
                            out.println("vous avez " + i3 + " absence(s) pour ce mois");
                        }
                        if (occurencesavril.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading5">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Mai
                    </button>
                </h5>
            </div>

            <div id="collapse5" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">

                    <%
                        List<Occurence> occurencesmai = (List<Occurence>) request.getAttribute("absencesmai");
                        int i4 = 0;
                        if (!(occurencesmai == null)) {
                            for (Occurence o : occurencesmai) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i4 = i4 + 1;
                            }
                            out.println("vous avez " + i4 + " absence(s) pour ce mois");
                        }
                        if (occurencesmai.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading6">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Juin
                    </button>
                </h5>
            </div>

            <div id="collapse6" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">

                    <%
                        List<Occurence> occurencesjuin = (List<Occurence>) request.getAttribute("absencesjuin");
                        int i5 = 0;
                        if (!(occurencesjuin == null)) {
                            for (Occurence o : occurencesjuin) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i5 = i5 + 1;
                            }
                            out.println("vous avez " + i5 + " absence(s) pour ce mois");
                        }
                        if (occurencesjuin.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>


                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading7">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Juillet
                    </button>
                </h5>
            </div>

            <div id="collapse7" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">


                    <%
                        List<Occurence> occurencesjuillet = (List<Occurence>) request.getAttribute("absencesjuillet");
                        int i6 = 0;
                        if (!(occurencesjuillet == null)) {
                            for (Occurence o : occurencesjuillet) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i6 = i6 + 1;
                            }
                            out.println("vous avez " + i6 + " absence(s) pour ce mois");
                        }
                        if (occurencesjuillet.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>


                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading8">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Aout
                    </button>
                </h5>
            </div>

            <div id="collapse8" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">


                    <%
                        List<Occurence> occurencesaout = (List<Occurence>) request.getAttribute("absencesaout");
                        int i7 = 0;
                        if (!(occurencesaout == null)) {
                            for (Occurence o : occurencesaout) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i7 = i7 + 1;
                            }
                            out.println("vous avez " + i7 + " absence(s) pour ce mois");
                        }
                        if (occurencesaout.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>


                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading9">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Septembre
                    </button>
                </h5>
            </div>

            <div id="collapse9" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">


                    <%
                        List<Occurence> occurencesseptembre = (List<Occurence>) request.getAttribute("absencesseptembre");
                        int i8 = 0;
                        if (!(occurencesseptembre == null)) {
                            for (Occurence o : occurencesseptembre) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i8 = i8 + 1;
                            }
                            out.println("vous avez " + i8 + " absence(s) pour ce mois");
                        }
                        if (occurencesseptembre.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading10">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Octobre
                    </button>
                </h5>
            </div>

            <div id="collapse10" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">

                    <%
                        List<Occurence> occurencesoctobre = (List<Occurence>) request.getAttribute("absencesoctobre");
                        int i9 = 0;
                        if (!(occurencesoctobre == null)) {
                            for (Occurence o : occurencesoctobre) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i9 = i9 + 1;
                            }
                            out.println("vous avez " + i9 + " absence(s) pour ce mois");
                        }
                        if (occurencesoctobre.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading11">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Novembre
                    </button>
                </h5>
            </div>

            <div id="collapse11" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">


                    <%
                        List<Occurence> occurencesnovembre = (List<Occurence>) request.getAttribute("absencesnovembre");
                        int i10 = 0;
                        if (!(occurencesnovembre == null)) {
                            for (Occurence o : occurencesnovembre) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i10 = i10 + 1;
                            }
                            out.println("vous avez " + i10 + " absence(s) pour ce mois");
                        }
                        if (occurencesnovembre.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }
                    %>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="heading12">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="true" aria-controls="collapseOne">
                        Decembre
                    </button>
                </h5>
            </div>
            <div id="collapse12" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">


                    <%
                        List<Occurence> occurencesdecembre = (List<Occurence>) request.getAttribute("absencesdecembre");
                        int i11 = 0;

                        if (!(occurencesdecembre == null)) {
                            for (Occurence o : occurencesdecembre) {

//                        out.println("\n" +
//                                "                <td class=\"bs-checkbox\"><input data-index=\"" + i + "\"name=\"btSelectItem\" type=\"checkbox\"></td>");
                                out.println("<td>" + o.getCours().getNomC() + "</td>");
                                out.println("<td>" + o.getDateOc() + "</td>");
                                out.println("<td>" + o.getHeureDebutOc() + "</td>");
                                out.println("<td>" + o.getHeureFinOc() + "</td>");
                                i11 = i11 + 1;
                            }
                            out.println("vous avez " + i11 + " absence(s) pour ce mois");
                        }
                        if (occurencesdecembre.isEmpty()) {
                            out.println("Pas d'absence pour ce mois");
                        }

                    %>


                </div>
            </div>


        </div>

    </div>
</div>
<input class="btn btn-lg btn-dark" type="button" id = "impression" onclick="imprimer_page()" name="impression" value="Imprimer"/>
</body>
<script type="text/javascript">
    function imprimer_page(){
        window.print();
    }
</script>
</html>
