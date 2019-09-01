
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="/user/doLogin" method="post">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName" id="userName" /></td>
        </tr>
        <br/>
        <tr>
            <td>密  码：</td>
            <td><input type="password" name="password" id="password" /></td>
        </tr>
    </table>
    <br/>
    <div align="center">
        <input type="submit" value="登录" /> &nbsp;&nbsp;<a href="/user/register"><input type="button" value="注册"></a>
    </div>
</form>
</body>
</html>
