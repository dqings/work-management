
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

        function backPlanToWeekPlanDialog(value) {
            /*$.get(
                value,
                function (data) {
                    $("#backPlanGrid").dialog("reload");
                    alert("转换成功");
                }
            );*/
            var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
            httpRequest.open('GET', value, true);//第二步：打开连接  将请求参数写在url中  ps:"./Ptest.php?name=test&nameone=testone"
            httpRequest.send();//第三步：发送请求  将请求参数写在URL中
            /**
             * 获取数据后的处理程序
             */
            httpRequest.onreadystatechange = function () {
                if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                    var json = httpRequest.responseText;//获取到json字符串，还需解析
                    console.log(json);
                    alert("转换成功");
                    $("#backPlanGrid").dialog("reload");
                }
            };
        }
        function operate_formatter(value, row, index) {
            var ID = row.id;
            var weekId = row.weekId;
            var workDescirbe = row.workDescirbe;
            var value = "/week/backPlanToWeekPlan?ID="+ID+"&weekId="+weekId+"&workDescirbe="+workDescirbe;
            return '<a onclick="backPlanToWeekPlanDialog(\''+value+'\')" href="#" class="easyui-linkbutton">转换工作</a>';
        }
        $(function () {
            $("#backPlanGrid").datagrid({
                url:'/week/getBackPlan',
                columns:[[
                    {field:"id",title:'编号',formatter: function(value,row,index){
                            return value;
                        }
                    },
                    {field:'weekId',title:'周报标识'},
                    {field:'workDescirbe',title:'计划描述',align:'center'},
                    {field:'operate',title:'操作',align:'center',formatter:operate_formatter}
                ]],
                pagePosition:'bottom',
                rownumbers:true,
                pagination:true,
                fit:true,
                striped:true
            });
        });
    </script>
</head>
<body>
    <table id="backPlanGrid"></table>
    <%--<div id="tb">
        <a id="backPlanToWeekPlan" href="#" class="easyui-linkbutton">转换工作</a>
        &lt;%&ndash;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>&ndash;%&gt;
    </div>
    <div id="backPlanToWeekPlanDialog"></div>--%>
</body>
</html>
