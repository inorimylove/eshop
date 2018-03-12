<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String path=request.getContextPath();%>

  </head>
  
欢迎<%=request.getAttribute("name")%> ！

<form >
<input type="text" name="id" id="idstr"/> id
 
<input type="text" name="name" id="namestr"/> name
<input type="button" id="btn"
 value="提交"/> 
</form>
<input type="button" id="btn1"
 value="多次操作数据的回滚"/> 
 <input type="button" id="btn2"
 value="一次操作多数据的回滚"/>
 <script type="text/javascript" src="<%=path%>/static/js/third/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
      $(function(){
         $("#btn").click(function(){
        	 //var datas = '{"id":"' + $('#id').val() + '","name":"' + $('#name').val()+'"}';
             var idstr = $('#idstr').val();
             var namestr = $('#namestr').val();
             var datas={'id':idstr,'name':namestr};
             console.log('idstr='+idstr+',namestr='+namestr);
        	 $.ajax({
               type:"POST",
               url:"<%=path%>/test/create",
               dataType: 'json',  
               contentType:'application/json;charset=UTF-8',  
               data:JSON.stringify(datas),
               success:function(data){ 
               alert(data.message);
           
               }
             });
         });        
         $("#btn1").click(function(){
             $.ajax({
               type:"POST",
               url:"<%=path%>/test/rollback0",
               dataType: 'json',  
               contentType:'application/json;charset=UTF-8',  
               success:function(data){ 
               //解析对象
               alert(data.message);
               }
             });
         });
         $("#btn2").click(function(){
             $.ajax({
               type:"POST",
               url:"<%=path%>/test/rollback1",
               dataType: 'json',  
               contentType:'application/json;charset=UTF-8',  
               success:function(data){ 
               //解析对象
               alert(data.message);
               }
             });
         });
      });
    </script>
</body>
</html>
