<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index.jsp</title>
  </head>
  <body>

  <form id="account_form" action="${pageContext.request.contextPath}/insertAccount.action" method="post">
    Username: <input type="text" name="username"><br>
    Money:<input type="text" name="money"><br>
    <input type="submit" id="account_form_submit_btn"><br>
  </form>

  <a href="${pageContext.request.contextPath}/transferAccount.action">transfer</a>

  </body>
</html>
