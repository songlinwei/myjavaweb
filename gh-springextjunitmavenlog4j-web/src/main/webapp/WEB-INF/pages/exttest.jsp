<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title></title>
      <!--ExtJs框架开始-->
      <script type="text/javascript" src="/Ext/adapter/ext/ext-base.js"></script>
      <script type="text/javascript" src="/Ext/ext-all.js"></script>
      <link rel="stylesheet" type="text/css" href="/Ext/resources/css/ext-all.css" />


    <!--ExtJs框架结束-->
         <script type="text/javascript">
        Ext.onReady(function () {
                var win = new Ext.Window({
                     title: '窗口',
                         width: 476,
                         height: 374,
                         html: '<div>这里是窗体内容</div>',
                         resizable: true,
                         modal: true,
                         closable: true,
                         maximizable: true,
                         minimizable: true
                });
            win.show();
        });
    </script>
    <!--ExtJs框架结束-->
    <script type="text/javascript">
        Ext.onReady(function () {
            Ext.MessageBox.alert('标题', 'Hello World!');
        });
    </script>
   </head>
<body>


extw
<!--
说明：
(1)Ext.onReady():ExtJS Application的入口...就相当于Java或C#的main函数.
(2)Ext.MessageBox.alert()：弹出对话框。
-->
</body>
</html>