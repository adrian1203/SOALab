<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2019-03-21
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="counter" class="Counter" />

<%
    int id = Integer.parseInt(request.getParameter("id").replace("b", "").replace(".jpg", ""));
    counter.increment(id);
    response.sendRedirect("https://www.google.pl");
%>
