<%--
  Created by IntelliJ IDEA.
  User: manaa
  Date: 08/02/2022
  Time: 03:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestion d'Appel</title>

    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">


    <link href="${pageContext.request.contextPath}/assets/css/sb-admin-2.min.css" rel="stylesheet">
    <%--    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">--%>
    <%--    <link href="${pageContext.request.contextPath}/assets/css/all.min.css" rel="stylesheet" type="text/css">--%>
    <!-- Custom styles for this template-->

    <%--    <link href="${pageContext.request.contextPath}/css/fonts.css" rel="stylesheet">--%>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Gestion d'Appel</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">


        <!-- Divider -->
        <hr class="sidebar-divider">



        <!-- Nav Item - Pages Collapse Menu -->
        <c:if test="${sessionScope.role == 'etudiant'}">
            <!-- Heading -->
            <div class="sidebar-heading">
                Espace Etudiant
            </div>
            <li class="nav-item">
                <a class="nav-link" href="listeabsenceservlet">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Consulter mes absences</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="depotJustificatif">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Deposer un justificatif</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="depotJustServlet?action=Afficher">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Liste des justificatifs</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="recappresenceprof">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Recapitulatif de présence</span></a>
            </li>

        </c:if>
        <c:if test="${sessionScope.role == 'professeur'}">
            <!-- Heading -->
            <div class="sidebar-heading">
                Espace Professeur
            </div>

            <li class="nav-item">
                <a class="nav-link" href="listeCoursServlet">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Mes cours</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="calendarServlet?week=thisWeek">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Mon emploi du temps</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="listeetudiants?">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Liste des étudiants</span></a>
            </li>

        </c:if>
        <c:if test="${sessionScope.role == 'scolarite'}">
            <!-- Heading -->
            <div class="sidebar-heading">
                Espace Scolarite
            </div>

            <li class="nav-item">
                <a class="nav-link" href="depotJustServlet?action=Afficher">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Liste des justificatifs</span></a>
            </li>

        </c:if>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">


                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.prenom} ${sessionScope.nom}</span>
                            <img class="img-profile rounded-circle"
                                 src="${pageContext.request.contextPath}/image/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profil
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/deconnexionServlet" data-toggle="modal"
                               data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Se déconnecter
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->

                <%--            </div>--%>
                <%--            <!-- /.container-fluid -->--%>

                <%--        </div>--%>
                <%--        <!-- End of Main Content -->--%>

                <%--    </div>--%>
                <%--    <!-- End of Content Wrapper -->--%>

                <%--</div>--%>


                <script src="${pageContext.request.contextPath}/assets/chart.js/jquery.min.js"></script>
                <script src="${pageContext.request.contextPath}/assets/chart.js/bootstrap.bundle.min.js"></script>

                <!-- Core plugin JavaScript-->
                <script src="${pageContext.request.contextPath}/assets/chart.js/jquery.easing.min.js"></script>

                <script src="${pageContext.request.contextPath}/assets/chart.js/sb-admin-2.min.js"></script>

</body>

</html>
