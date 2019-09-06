<%--
  Created by IntelliJ IDEA.
  User: shanwujun
  Date: 2019/9/4
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../static/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/easyUi/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../static/easyUi/themes/icon.css">
    <script type="text/javascript" src="../static/easyUi/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../static/easyUi/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
            //定义添加窗口
            $('#addWorkRemarkDialog').dialog({
                title: '新增备忘录',
                width: 400,
                height: 500,
                closed: true,
                cache: false,
                href: '../static/day/workRemark.html',
                modal: true
            });
            var toolbar = $("#tb");
            $('#addWorkRemark').bind('click', function(){
                $("#addWorkRemarkDialog").dialog("open");
            });
            $("#workRemarkGrid").datagrid({
                url:'/day/getWorkRemark',
                columns:[[
                    {field:'remarkId',title:'编号',width:230},
                    {field:'userId',title:'用户编号',width:230},
                    {field:'title',title:'标题',width:200,align:'center'},
                    {field:'contentDescribe',title:'备注内容',width:100,align:'center'}
                ]],
                pagePosition:'bottom',
                toolbar:toolbar,
                rownumbers:true,
                pagination:true,
                fit:true
            });
        });
    </script>
</head>
<body>
    <table id="workRemarkGrid"></table>
    <div id="tb">
        <a id="addWorkRemark" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
    </div>
    <div id="addWorkRemarkDialog"></div>
</body>
</html>
