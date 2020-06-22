<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index.jsp</title>
  </head>
  <body>

  <h2>测试提交表单</h2>
  <form id="account_form" action="${pageContext.request.contextPath}/insertAccount.action" method="post">
    Username: <input type="text" name="username"><br>
    Money:<input type="text" name="money"><br>
    <input type="submit" id="account_form_submit_btn"><br>
  </form>
  <hr>

  <h2>测试事务的回滚</h2>
  <a href="${pageContext.request.contextPath}/transferAccount1.action">transferAccount1</a><br>
  <a href="${pageContext.request.contextPath}/transferAccount2.action">transferAccount2</a><br>
  <a href="${pageContext.request.contextPath}/transferAccount3.action">transferAccount3</a><br>
  <a href="${pageContext.request.contextPath}/transferAccount4.action">transferAccount4</a><br>
  <a href="${pageContext.request.contextPath}/transferAccount5.action">transferAccount5</a><br>
  <hr>

  <h2>测试事务的传播级别</h2>
  <a href="${pageContext.request.contextPath}/testPropagation1.action">testPropagation1</a><br>
  <a href="${pageContext.request.contextPath}/testPropagation2.action">testPropagation2</a><br>
  <a href="${pageContext.request.contextPath}/testPropagation3.action">testPropagation3</a><br>
  <a href="${pageContext.request.contextPath}/testPropagation4.action">testPropagation4</a><br>
  <a href="${pageContext.request.contextPath}/testPropagation5.action">testPropagation5</a><br>
  <a href="${pageContext.request.contextPath}/testPropagation6.action">testPropagation6</a><br>
  <a href="${pageContext.request.contextPath}/testPropagation7.action">testPropagation7</a><br>
  <hr>


  </body>
</html>
