<%--
  Created by IntelliJ IDEA.
  User: manaa
  Date: 06/02/2022
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleprofil.css">


</head>



<%--<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">--%>
<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<%--<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">--%>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<link href="${pageContext.request.contextPath}/assets/css/sb-admin-2.min.css" rel="stylesheet">


<%@ include file="Menu.jsp" %>
<body>
<!-- partial:index.partial.html -->
<div class="container">
    <div class="profile large">
        <div class="cover"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/584938/sterling-davis-513079-unsplash.jpg" alt="cover"/>
            <div class="layer">
                <div class="loader"></div>
            </div><a class="image-wrapper" href="#">
                <form id="coverForm" action="#">
                    <input class="hidden-input" id="changeCover" type="file"/>
                    <label class="edit glyphicon glyphicon-pencil" for="changeCover" title="Change cover"></label>
                </form></a>
        </div>
        <div class="user-info">
            <div class="profile-pic"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/584938/bg_33.png" alt="pic"/>
                <div class="layer">
                    <div class="loader"></div>
                </div><a class="image-wrapper" href="#">
                    <form id="profilePictureForm" action="#">
                        <input class="hidden-input" id="changePicture" type="file"/>
                        <label class="edit glyphicon glyphicon-pencil" for="changePicture" type="file" title="Change picture"></label>
                    </form></a>
            </div>
            <div class="username">
                <div class="name"><span class="verified"></span>${sessionScope.prenom} ${sessionScope.nom}</div>
                <div class="about"> ${sessionScope.mail} (${sessionScope.role})</div>
            </div>
        </div>
    </div>
</div>
<!-- partial -->
<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script  src="${pageContext.request.contextPath}/css/scriptprofil.js"></script>

</body>

<%--<body>--%>
<%--<div class="container rounded bg-white mt-5">--%>
<%--    <div class="row">--%>
<%--        <form action="profilservlet" name ="form" method="POST" enctype="multipart/form-data">--%>
<%--        <div class="col-md-4 border-right">--%>
<%--            <div class="d-flex flex-column align-items-center text-center p-3 py-5" id="photoprofil"><img class="rounded-circle mt-5" src="${pageContext.request.contextPath}/imagephoto" width="90"><span class="font-weight-bold">${sessionScope.prenom} ${sessionScope.nom} </span><span class="text-black-50">${sessionScope.mail}</span><span>${sessionScope.role}</span>--%>
<%--                <tr>--%>
<%--                    <th>Changer la photo</th>--%>
<%--                    <td><input type="file" id="ajaxfile" name="fichier"/></td>--%>
<%--                </tr>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-md-8">--%>
<%--            <div class="p-3 py-5">--%>
<%--                <div class="d-flex justify-content-between align-items-center mb-3">--%>
<%--                    <div class="d-flex flex-row align-items-center back"><i class="fa fa-long-arrow-left mr-1 mb-1"></i>--%>
<%--                        <h6>Back to home</h6>--%>
<%--                    </div>--%>
<%--                    <h6 class="text-right">Edit Profile</h6>--%>
<%--                </div>--%>
<%--                <div class="row mt-2">--%>
<%--                    <div class="col-md-6"><input type="text" class="form-control" placeholder="first name" value="${sessionScope.nom}"></div>--%>
<%--                    <div class="col-md-6"><input type="text" class="form-control" value="${sessionScope.prenom}" placeholder="Doe"></div>--%>
<%--                </div>--%>
<%--                <div class="row mt-3">--%>
<%--                    <div class="col-md-6"><input type="text" class="form-control" placeholder="Email" value="${sessionScope.mail}"></div>--%>
<%--                    <div class="col-md-6"><input type="text" class="form-control" value="+19685969668" placeholder="Phone number"></div>--%>
<%--                </div>--%>
<%--                <div class="row mt-3">--%>
<%--                    <div class="col-md-6"><input type="text" class="form-control" placeholder="address" value="${sessionScope.role}"></div>--%>
<%--                    <div class="col-md-6"><input type="text" class="form-control" value="USA" placeholder="Country"></div>--%>
<%--                </div>--%>
<%--                <div class="row mt-3">--%>
<%--                    <div class="col-md-6"><input type="text" class="form-control" placeholder="Bank Name" value="Bank of America"></div>--%>
<%--                    <div class="col-md-6"><input type="text" class="form-control" value="043958409584095" placeholder="Account Number"></div>--%>
<%--                </div>--%>
<%--                <div class="mt-5 text-right"><button onclick="uploadFile()"  class="btn btn-primary profile-button" type="submit" value="envoyer">Save Profile</button></div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script>--%>
<%--    async function uploadFile() {--%>
<%--        let formData = new FormData();--%>
<%--        formData.append("file", ajaxfile.files[0]);--%>
<%--        await fetch('profilservlet', {--%>
<%--            method: "POST",--%>
<%--            body: formData--%>
<%--        });--%>
<%--        alert('The file upload with Ajax and Java was a success!');--%>
<%--    }--%>
<%--</script>--%>

<%--<script>--%>
<%--    async function refreshFile() {--%>
<%--        let formData = new FormData();--%>
<%--        formData.append("file", ajaxfile.files[0]);--%>
<%--        await fetch('profilservlet', {--%>
<%--            method: "POST",--%>
<%--            body: formData--%>
<%--        });--%>
<%--        alert('The file upload with Ajax and Java was a success!');--%>
<%--    }--%>
<%--</script>--%>
<%--</body>--%>
</html>
