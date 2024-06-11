<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" %>
<html>
  <head>
     <title>add product</title>
  </head>
  <body>
       <form action="addproducts" method="post">
                <label>id:</label>
                <input type="text" name="id">
                <br> </br>
                <label>name: </label>
                <input type="text" name="name">
                <br> </br>
                <label>price: </label>
                <input type="text" name="price">
                <br> </br>
                <label>description: </label>
                <input type="text" name="description">
                <br> </br>
                <button> add</button>
            </form>

  </body>
</html>