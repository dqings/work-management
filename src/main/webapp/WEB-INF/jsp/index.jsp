
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工作管理系统首页</title>
    <script type="text/javascript" src="static/js/jquery-3.4.1.min.js"></script>
    <!-- easyui start-->
    <link rel="stylesheet" type="text/css" href="static/easyUi/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyUi/themes/icon.css">
    <script type="text/javascript" src="static/easyUi/jquery.easyui.min.js"></script>
    <!--easyui end -->
    <!-- ztree start-->
    <link rel="stylesheet" href="static/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="static/ztree/jquery.ztree.all.min.js"></script>
    <!-- ztree end-->
    <SCRIPT LANGUAGE="JavaScript">
        var zTreeObj;
        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {};
        // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
        var zNodes = [
            {name:"日报管理", open:true, children:[
                    {name:"日报"}, {name:"备忘录"}]},
            {name:"周报管理", open:true, children:[
                    {name:"周报"}, {name:"下周工作计划"}]}
        ];
        $(document).ready(function(){
            zTreeObj = $.fn.zTree.init($("#treeId"), setting, zNodes);
        });
    </SCRIPT>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'北'" style="height:100px;"></div>
    <div data-options="region:'west',title:'西'" style="width:200px;">
        <ul id="treeId" class="ztree"></ul>
    </div>
    <div data-options="region:'center',title:'中间'"></div>
    <div data-options="region:'south',title:'南'" style="height:100px;"></div>
</body>
</html>
