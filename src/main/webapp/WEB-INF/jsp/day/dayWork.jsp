
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../static/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/easyUi/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../static/easyUi/themes/icon.css">
    <script type="text/javascript" src="../static/easyUi/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../static/easyUi/easyui-lang-zh_CN.js"></script>
</head>
<script>
    $(function () {
        //定义添加窗口
        $('#addDialog').dialog({
            title: '新增日报',
            width: 400,
            height: 500,
            closed: true,
            cache: false,
            href: '../static/day/addDayWork.html',
            modal: true
        });
        var toolbar = $("#tb");
        $('#addDayWork').bind('click', function(){
            $("#addDialog").dialog("open");
        });
        $("#dayWorkGrid").datagrid({
            url:'/day/getWorkContent',
            columns:[[
                {field:'dayId',title:'编号',width:100},
                {field:'userId',title:'用户编号',width:100},
                {field:'createTime',title:'创建时间',width:100,align:'center'},
                {field:'workEnvironment',title:'工作环境',width:100,align:'center'},
                {field:'workContent',title:'工作内容',width:100,align:'center'}
            ]],
            toolbar:toolbar,
            rownumbers:true,
            pagination:true,
            pagePosition:'bottom'
        });
    });
</script>
<body>
    <table id="dayWorkGrid"></table>
    <div id="tb">
        <a id="addDayWork" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
    </div>
    <div id="addDialog"></div>
</body>
</html>
