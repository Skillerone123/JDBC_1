<%@ page import="org.study.service.TrainService" %>
<%@ page import="org.study.service.Impl.TrainServiceImpl" %>
<%@ page import="org.study.entity.Train" %><%--
  Created by IntelliJ IDEA.
  User: Skiller
  Date: 18.06.2016
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1 align="center">Welcome!</h1>
  <p>Input your query here:</p>
  <input type="text" size="40">
  <button>OK</button>
  <p><% TrainService trainService = new TrainServiceImpl();
    for (Train train : trainService.getAllTrainsFromDB()) {
      out.println(train);
    } %></p>
  </body>
</html>
