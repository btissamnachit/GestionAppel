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
        <details>
            <%
                Set<Cours> cours = (Set<Cours>) request.getAttribute("cours");
                HashMap<Cours, Integer> nbAbsences = (HashMap<Cours, Integer>) request.getAttribute("nbAbsence");
                HashMap<Cours, Float> moyenneAbsence = (HashMap<Cours, Float>) request.getAttribute("moyenneAbsence");
                request.getAttribute("etudiantsAbsenteistes");
                request.getAttribute("absenceEtudiantGlobal");
            %>
            <summary>Details</summary>
            <p>
                Lorem ipsum dolor sit amet, eu alia suscipit mei. Reque iriure delectus vix id, ex sed forensibus
                suscipiantur. In eos exerci mollis apeirian, an qui latine alienum. Ad mea libris maluisset, consul
                assueverit sea ex.
            </p>
        </details>
        <details>
            <summary>Features</summary>
            <p>
                Lorem ipsum dolor sit amet, eu alia suscipit mei. Reque iriure delectus vix id, ex sed forensibus
                suscipiantur. In eos exerci mollis apeirian, an qui latine alienum. Ad mea libris maluisset, consul
                assueverit sea ex.
            </p>
        </details>
        <details>
            <summary>Information
            </summary>
            <p>Lorem ipsum dolor sit amet, eu alia suscipit mei. Reque iriure delectus vix id, ex sed forensibus
                suscipiantur. In eos exerci mollis apeirian, an qui latine alienum. Ad mea libris maluisset, consul
                assueverit sea ex. </p>
        </details>
        <details>
            <summary>Specifications
            </summary>
            <p>Lorem ipsum dolor sit amet, eu alia suscipit mei. Reque iriure delectus vix id, ex sed forensibus
                suscipiantur. In eos exerci mollis apeirian, an qui latine alienum. Ad mea libris maluisset, consul
                assueverit sea ex. </p>
        </details>
    </section>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
</body>
</html>

