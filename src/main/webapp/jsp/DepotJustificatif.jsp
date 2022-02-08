<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>DepotJustificatif</title>

    <!-- Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

</head>
<body>
<div class="tableJustificatif">
    <form action=""
          method="GET"
          name="DepotJustificatif">

        <table class="table">


            <thead>
            <tr>
                <th>P&eacute;riode de d&eacute;but</th>
                <th>P&eacute;riode de fin</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>
                    <div class="nativeDatePicker">
                        <label for="day"></label>
                        <input type="date" id="DateDebut" name="DebutPeriode">
                        <span class="validity"></span>
                    </div>
                </td>
                <td>
                    <div class="nativeDatePicker">
                        <label for="day"></label>
                        <input type="date" id="DateFin" name="FinPeriode">
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
                    <div class="form-group">
                        <input type="file" class="form-control-file" id="exampleFormControlFile1">
                    </div>
                </td>
                <td>
                    <input type="submit" name="Envoyer" value="Valider"/>
                </td>
            </tr>
            </tbody>
</div>
</table>
</form>
</div>
</body>
</html>
