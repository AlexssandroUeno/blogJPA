<%
session.invalidate();
response.sendRedirect("login.jsp?sucessoLogout=true");
%>