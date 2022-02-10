<%@ page import="miage.gestionappel.metier.Occurence" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script>document.getElementsByTagName("html")[0].className += " js";</script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/stylecalendar.css">
    <title>Schedule Template | CodyHouse</title>
</head>
<%@ include file="Menu.jsp" %>
<body>
<div class="nav_button">
    <a href="calendarServlet?week=precedent">
        <button> Precedent</button>
    </a>
    <a href="calendarServlet?week=suivant">
        <button> Suivant</button>
    </a>
</div>
<div class="cd-schedule cd-schedule--loading margin-top-lg margin-bottom-lg js-cd-schedule">
    <div class="cd-schedule__timeline">
        <ul>
            <li><span>09:00</span></li>
            <li><span>09:30</span></li>
            <li><span>10:00</span></li>
            <li><span>10:30</span></li>
            <li><span>11:00</span></li>
            <li><span>11:30</span></li>
            <li><span>12:00</span></li>
            <li><span>12:30</span></li>
            <li><span>13:00</span></li>
            <li><span>13:30</span></li>
            <li><span>14:00</span></li>
            <li><span>14:30</span></li>
            <li><span>15:00</span></li>
            <li><span>15:30</span></li>
            <li><span>16:00</span></li>
            <li><span>16:30</span></li>
            <li><span>17:00</span></li>
            <li><span>17:30</span></li>
            <li><span>18:00</span></li>
        </ul>
    </div> <!-- .cd-schedule__timeline -->

    <div id="cd-schedule__events" class="cd-schedule__events">
        <ul>
            <%
                LinkedHashMap<String, List<Occurence>> timeTable = (LinkedHashMap<String, List<Occurence>>) request.getAttribute("timetable");
                Set<String> dates = timeTable.keySet();
                for (String date : dates) {
                    out.println("<li class=\"cd-schedule__group\"> <div class=\"cd-schedule__top-info\">");
                    out.println("<span>" + date + "</span></div><ul>");
                    for (Occurence cours : timeTable.get(date)) {
                        out.println("<li class=\"cd-schedule__event\">");
                        out.println("<a data-start=\"" + cours.getHeureDebutOc());
                        out.println("\"data-end=\" " + cours.getHeureFinOc());
                        out.println("\" data-content=\"" + cours.getIdOc() + "\" data-event=\"event-1\" href=\"#0\">");
                        out.println("<em class=\"cd-schedule__name\">" + cours.getCours().getNomC() + "</em> </a></li>");
                    }
                    out.println("</ul> </li>");
                }
            %>
        </ul>
    </div>
    <div class="cd-schedule-modal">
        <header class="cd-schedule-modal__header">
            <div class="cd-schedule-modal__content">
                <span class="cd-schedule-modal__date"></span>
                <h3 class="cd-schedule-modal__name"></h3>
            </div>
            <div class="cd-schedule-modal__header-bg"></div>
        </header>
        <div class="cd-schedule-modal__body">
            <div class="cd-schedule-modal__event-info"></div>
            <div class="cd-schedule-modal__body-bg"></div>
        </div>
        <a href="#0" class="cd-schedule-modal__close text-replace">Close</a>
    </div>
    <div class="cd-schedule__cover-layer"></div>
</div> <!-- .cd-schedule -->

<script src="assets/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
<script src="assets/js/main.js"></script>
</body>
</html>