<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Random" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Deposer un justificatif d'absence</title>

    <!-- Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styleJustif.css" rel="stylesheet">

</head>
<%@ include file="Menu.jsp" %>
<body>
<c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été envoyé!" /></p></c:if>
<div class="container-fluid px-1 py-5 mx-auto">
    <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
            <h3>Depot de justificatif</h3>

            <div class="card">

        <form method="POST" class="form-card" action="/depotJustServlet?action=EnregistrerJustificatif" enctype="multipart/form-data">
            <div class="row justify-content-between text-left">
                <div class="form-group col-sm-6 flex-column d-flex nativeDatePicker">
                    <label class="form-control-label px-3">Date de debut <span class="text-danger"> *</span></label>
                    <input type="date" name="debutPeriode" required="required">
                </div>
                <div class="form-group col-sm-6 flex-column d-flex">
                    <label class="form-control-label px-3 nativeDatePicker">Date de fin <span class="text-danger"> *</span></label>
                    <input type="date" name="finPeriode" required="required">
                </div>
                <div class="form-group col-sm-6 flex-column d-flex">
                    <label class="form-control-label px-3 nativeDatePicker">Description du fichier <span class="text-danger"> *</span></label>
                    <input type="text" name="description"  required="required" >
                </div>
                <div class="form-group col-sm-6 flex-column d-flex">
                    <label class="form-control-label px-3 nativeDatePicker">Justificatif à envoyer <span class="text-danger"> *</span></label>
                    <input type="file" name="fichier" class="form-control-file" required="required" />
                </div>
                </div>
                <div class="row justify-content-end">
                    <div class="form-group col-sm-6"> <input type="submit" name="Envoyer" value="Valider" class="btn-block btn-primary"/> </div>
                </div>
        </form>
            </div>

        </div>
        </div>
    </div>
</div>

</body>
</html>
