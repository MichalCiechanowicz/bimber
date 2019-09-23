<%@ page import="controller.LanguageProvider" %>
<html>
<body>
<h2>Strona Glowna</h2>
<h1><%=LanguageProvider.INSTANCE.getMessage("greting")%></h1>
<a href="product.jsp">Product List</a><br>
<hr>
<a href="login.jsp">LOGIN</a><br>
<hr>
<a href="/bimber/languageServlet?Language=pl"> POLSKI</a>
<a href="/bimber/languageServlet?Language=en"> ANGIELSKI</a>
</body>
</html>
