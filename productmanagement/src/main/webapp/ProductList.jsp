<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.ArrayList, l.Product" %>
<html>
<head>
    <title>ProductList</title>
</head>
<body>
    <%
    ArrayList<Product> productList = (ArrayList<Product>) getServletContext().getAttribute("productList");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("<th>id</th>");
    out.println("<th>name</th>");
    out.println("<th>price</th>");
    out.println("<th>Description</th>");
    out.println("</tr>");

    if (productList != null) {
        for (Product product : productList) {
            out.println("<tr>");
            out.println("<td>" + product.getId() + "</td>");
            out.println("<td>" + product.getName() + "</td>");
            out.println("<td>" + product.getPrice() + "</td>");
            out.println("<td>" + product.getDescription() + "</td>");
            out.println("</tr>");
        }
    } else {
        out.println("<tr>");
        out.println("<td colspan='4'>No products available</td>");
        out.println("</tr>");
    }

    out.println("</table>");
    %>
</body>
</html>
