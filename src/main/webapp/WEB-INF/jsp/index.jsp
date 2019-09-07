
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
        var setting = {
            data:{
                simpleData:{
                    enable: true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootPId: 0
                }
            },
            callback:{
                onClick:function (event,treeId,treeNode) {
                    if(treeNode.pId!=0){
                        var title = treeNode.name;
                        var v = $("#tabId").tabs('exists',title);
                        var page = treeNode.page;
                        if(v){
                            //选中
                            $("#tabId").tabs('select',title);
                        }else {
                            //创建选项卡
                            $("#tabId").tabs('add',{
                                title:title,
                                content:'<iframe  src="'+page+'" scrolling="auto" frameborder="0" height="96.7%" width="100%"></iframe>',
                                closable:true,
                                fit:true,
                            });
                        }
                    }
                }
            }
        };
        // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
        /*var zNodes = [
            {name:"日报管理", open:true, children:[
                    {name:"日报"}, {name:"备忘录"}]},
            {name:"周报管理", open:true, children:[
                    {name:"周报"}, {name:"下周工作计划"}]}
        ];*/
        var zNodes = [
            {"id":1,"pId":0,"name":"日报管理"},
            {"id":2,"pId":1,"name":"日报","page":"/day/work"},
            {"id":3,"pId":1,"name":"备忘录","page":"/day/workRemark"},
            {"id":4,"pId":0,"name":"周报管理"},
            {"id":5,"pId":4,"name":"周报","page":"/week/weekPlanInfo"},
            {"id":6,"pId":4,"name":"后续计划","page":"/week/backPlan"}
        ];
        $(document).ready(function(){
            zTreeObj = $.fn.zTree.init($("#treeId"), setting, zNodes);
            zTreeObj.expandAll(true);
        });
        function logout() {
            $("#logout").submit();
        }
    </SCRIPT>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'工作管理系统'" style="height:100px;">
        <div align="right">
            <a onclick="logout()" href="#">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
    </div>
    <div data-options="region:'west',title:'系统菜单'" style="width:200px;">
        <div class="easyui-accordion" fit="true">
            <div title="工作管理" style="overflow:auto;padding:10px;">
                <ul id="treeId" class="ztree"></ul>
            </div>
        </div>
    </div>
    <div  data-options="region:'center',title:''" style="height: 100%;overflow-y: hidden">
        <div id="tabId" class="easyui-tabs"></div>
    </div>
    <div data-options="region:'south',title:''" style="height:100px;"></div>
    <form id="logout" method="post" action="/user/logout">

    </form>
</body>
</html>
