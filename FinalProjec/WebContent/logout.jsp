<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    session.invalidate();
    response.sendRedirect("index.jsp");
    %>
</html>
