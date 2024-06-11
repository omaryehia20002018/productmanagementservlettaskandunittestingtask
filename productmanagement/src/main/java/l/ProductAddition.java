package l;

import l.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addproducts")
public class ProductAddition extends HttpServlet {
    private ProductDao productDao=new ProductDao();

    @Override
    public void init() throws ServletException {
        ArrayList<Product> productList=new ArrayList<>();
        getServletContext().setAttribute("productList",productList);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id= Integer.parseInt(req.getParameter("id"));
       float price=Float.parseFloat(req.getParameter("price"));
       String name=req.getParameter("name");
       String description=req.getParameter("description");
       Product product=new Product(id,price,name,description);
        ServletContext context=getServletContext();
        ArrayList<Product> productList=(ArrayList<Product>) context.getAttribute("productList");
       //productDao.addProduct(product);
        productList.add(product);
       req.getRequestDispatcher("Result.jsp").forward(req,resp);
    }
}
