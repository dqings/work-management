<%--
  Created by IntelliJ IDEA.
  User: shanwujun
  Date: 2019/9/4
  Time: 12:36
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
            //定义添加周报窗口
            $('#addWeekPlanDialog').dialog({
                title: '新增周报',
                width: 400,
                height: 500,
                closed: true,
                cache: false,
                href: '../static/week/addWeekPlan.html',
                modal: true
            });
            //定义添加后续计划窗口
            $('#addBackPlanDialog').dialog({
                title: '新增后续计划',
                width: 400,
                height: 500,
                closed: true,
                cache: false,
                href: '../static/week/addBackPlan.html',
                modal: true
            });
            //为按钮添加点击事件
            var toolbar = $("#tb");
            $('#addWeekPlan').bind('click', function(){
                $("#addWeekPlanDialog").dialog("open");
            });
            $('#addBackPlan').bind('click', function(){
                $("#addBackPlanDialog").dialog("open");
            });
            //初始化数据表格
            $("#weekPlanGrid").datagrid({
                url:'/week/getWeekPlanInfo',
                columns:[[
                    {field:'workIdPri',title:'编号'},
                    {field:'userId',title:'用户编号'},
                    {field:'weekId',title:'周报编号',align:'center'},
                    {field:'workDescribe',title:'周报描述',align:'center'},
                    {field:'planDay',title:'计划天数',align:'center'},
                    {field:'realDay',title:'真实天数',align:'center'},
                    {field:'isComplete',title:'是否完成',align:'center',
                        formatter: function(value,row,index){
                            if (value=='1'){
                                return '是';
                            } else {
                                return '否';
                            }
                        }}
                ]],
                pagePosition:'bottom',
                toolbar:toolbar,
                rownumbers:true,
                pagination:true,
                fit:true,
                striped:true
            });
        });
    </script>
</head>
<body>
    <table id="weekPlanGrid"></table>
    <div id="tb">
        <a id="addWeekPlan" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增周报</a>
        <a id="addBackPlan" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增后续计划</a>
    </div>
    <div id="addWeekPlanDialog"></div>
    <div id="addBackPlanDialog"></div>
</body>
</html>
