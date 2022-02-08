<%--
  Created by IntelliJ IDEA.
  User: manaa
  Date: 06/02/2022
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html lang="en">

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

<body class="bg-gradient-primary">
<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-6">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Se connecter</h1>
                                </div>
                                <div>
                                <%
                                    String msg_a = (String)request.getAttribute("msg_a");
                                    if(msg_a != null){
                                %>
                                        <div class="alert alert-primary" ><%=msg_a%></div>
                                <%
                                    }

                                    String msg_e = (String)request.getAttribute("msg_e");
                                    if(msg_e != null){
                                %>
                                        <div class="alert alert-danger" ><%=msg_e%></div>
                                <%
                                    }
                                %>
                                </div>
                                <form class="user" action="${pageContext.request.contextPath}/connexionServlet" method="post">
                                    <div class="form-group">
                                        <%
                                            String email = request.getParameter("email");
                                            if(email == null){
                                                email = "";
                                            }
                                        %>
                                        <input type="email" class="form-control form-control-user"
                                               id="exampleInputEmail" aria-describedby="emailHelp"
                                               placeholder="Entrez votre mail..." name="email" value="<%= email %>">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user"
                                               id="exampleInputPassword" placeholder="Mot de passe" name="motdepasse">
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" class="custom-control-input" id="customCheck">
                                            <label class="custom-control-label" for="customCheck">Se souvenir de moi</label>
                                        </div>
                                    </div>
                                    <button class="btn btn-primary btn-user btn-block" type="submit">
                                        Se connecter
                                    </button>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="">Mot de passe oublié ?</a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>


</body>

</html>
