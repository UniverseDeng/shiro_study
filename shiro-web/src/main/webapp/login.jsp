<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>

</head>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<body>
<div style="text-align:center;margin:0 auto;">
    <h2>登录页面!</h2>
    <form action="subLogin" method="POST">
        <div> 用户名：<input type="text" name="username"/></div>
        <div> 密码：<input type="password" name="password"/></div>
        记住我：<input type="checkbox" name="rememberMe"><br>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
