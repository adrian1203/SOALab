
<%@ page import="Counter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="counter" class="Counter" />
<html>
<head>
    <title>Kliknięcia</title>
</head>
<body>

Baner 1: <% out.print(counter.getClicks(0)); %><br>
Baner 2: <% out.print(counter.getClicks(1)); %><br>

</body>
</html>