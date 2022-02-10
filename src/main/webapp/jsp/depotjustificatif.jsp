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

</head>
<%@ include file="Menu.jsp" %>
<body>
<c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été envoyé!" /></p></c:if>
<div class="tableJustificatif">
  <table class="table">


    <thead>
    <tr>
      <th>P&eacute;riode de d&eacute;but</th>
      <th>P&eacute;riode de fin</th>
    </tr>
    </thead>

    <tbody>
    <form method="post" action="/depotJustServlet" enctype="multipart/form-data">
      <tr>
        <td>
          <div class="nativeDatePicker">
            <label></label>
            <input type="date" name="debutPeriode"  required>
            <span class="validity"></span>
          </div>
        </td>
        <td>
          <div class="nativeDatePicker">
            <label></label>
            <input type="date" name="finPeriode" required>
            <span class="validity"></span>
          </div>
        </td>
      </tr>
      <tr>
        <th>D&eacute;poser un justificatif</th>
        <th>Envoyer</th>
      </tr>
      <tr>
        <td>
          <label for="description"> Description du fichier :</label>
          <input type="text" name="description" id="description" required/>
        </td>
        <td>
          <div class="form-group">
            <label for="fichier"> Justificatif à envoyer :</label>
            <input type="file" name="fichier" class="form-control-file" id="fichier"/>
          </div>
        </td>
        <td>
          <input type="submit" name="Envoyer" value="Valider"/>
        </td>
      </tr>
    </form>
    </tbody>

  </table>
</div>
</body>
</html>
