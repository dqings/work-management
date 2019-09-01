
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/WEB-INF/js/jquery-3.4.1.min.js" language="JavaScript"></script>--%>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
    <title>用户注册</title>
    <script>
        function checkAndSubmit() {
            //用户名
            var userName = document.getElementById("userName").value;
            if(userName==""){
                alert("用户名不能为空!")
                return;
            }
            //密码
            var passwoed = document.getElementById("password").value;
            if(passwoed==""){
                alert("密码不能为空!")
                return;
            }
            //邮箱
            //手机号
            $("#FORM").submit()
        }
    </script>
</head>
<body>
<form method="post" action="/user/doRegister" id="FORM">
<table align="center">
    <tr>
        <td>用户名：</td>
        <td><input type="text" name="userName" id="userName"></td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><input type="password" name="password" id="password"></td>
    </tr>
    <tr>
        <td>邮箱：</td>
        <td><input type="text" name="email" id="email"></td>
    </tr>
    <tr>
        <td>手机号：</td>
        <td><input type="text" name="mobile" id="mobile"></td>
    </tr>
</table>
    <br>
    <div align="center">
        <input type="button" value="注册" onclick="checkAndSubmit()">
    </div>
</form>
</body>
</html>
