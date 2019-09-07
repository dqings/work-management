
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
            modal: true,
            border:false
        });
        var toolbar = $("#tb");
        $('#addDayWork').bind('click', function(){
            $("#addDialog").dialog("open");
        });
        $("#dayWorkGrid").datagrid({
            url:'/day/getWorkContent',
            columns:[[
                {field:'dayId',title:'编号',width:230},
                {field:'userId',title:'用户编号',width:230},
                {field:'createTime',title:'创建时间',width:200,align:'center',
                    formatter:formatDateBoxFull},
                {field:'workEnvironment',title:'工作环境',width:100,align:'center',
                    formatter: function(value,row,index){
                        if (value=='1'){
                            return '公司';
                        } else if(value=='2'){
                            return '在家';
                        }else {
                            return '出差';
                        }
                    }
                },
                {field:'workContent',title:'工作内容',align:'center'}
            ]],
            pagePosition:'bottom',
            toolbar:toolbar,
            rownumbers:true,
            pagination:true,
            fit:true,
            striped:true
        });
    });

    function formatDateBoxFull(value) {
        if (value == null || value == '') {
            return '';
        }
        var dt = parseToDate(value);
        return dt.format("yyyy-MM-dd hh:mm:ss");
    }
    function parseToDate(value) {
        if (value == null || value == '') {
            return undefined;
        }

        var dt;
        if (value instanceof Date) {
            dt = value;
        }
        else {
            if (!isNaN(value)) {
                dt = new Date(value);
            }
            else if (value.indexOf('/Date') > -1) {
                value = value.replace(/\/Date\//, '$1');
                dt = new Date();
                dt.setTime(value);
            } else if (value.indexOf('/') > -1) {
                dt = new Date(Date.parse(value.replace(/-/g, '/')));
            } else {
                dt = new Date(value);
            }
        }
        return dt;
    }

    //为Date类型拓展一个format方法，用于格式化日期
    Date.prototype.format = function (format) //author: meizz
    {
        var o = {
            "M+": this.getMonth() + 1, //month
            "d+": this.getDate(),    //day
            "h+": this.getHours(),   //hour
            "m+": this.getMinutes(), //minute
            "s+": this.getSeconds(), //second
            "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
            "S": this.getMilliseconds() //millisecond
        };
        if (/(y+)/.test(format))
            format = format.replace(RegExp.$1,
                (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(format))
                format = format.replace(RegExp.$1,
                    RegExp.$1.length == 1 ? o[k] :
                        ("00" + o[k]).substr(("" + o[k]).length));
        return format;
    };
</script>
<body>
    <table id="dayWorkGrid"></table>
    <div id="tb">
        <a id="addDayWork" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增日报</a>
        <%--<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>--%>
    </div>
    <div id="addDialog"></div>
</body>
</html>
