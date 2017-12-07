<%--
  Created by IntelliJ IDEA.
  User: songlinwei
  Date: 17/1/11
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>抽奖数据后台-admin</title>
    <link rel="stylesheet" type="text/css" href="../static/css/pages.css"/>
    <script type="text/javascript" src="../static/js/pages.js"></script>
</head>
<body>
<h1>${admin}</h1>
可以填写多个奖品 用英文,号隔开
<form action="main.jsp" method="POST">
    抽奖活动名称: <input type="text" name="name">
    <br />
    奖品名称: <input type="text" name="name">
    <br />
    奖品类别: <input type="text" name="name">
    <br />
    奖品数量: <input type="text" name="name">
    <br />
    中奖概率: <input type="text" name="url" />
    <br />
    <input type="submit" value="提交" />
    <br />
    <p>初始数据提交后 生成奖品列表 如有概率或奖品数量问题可根据需要事实调整</p>
</form>

<div class="div1">
    <p>hell</p>
</div>
<img src="../static/img/1.png">
</body>
</html>
