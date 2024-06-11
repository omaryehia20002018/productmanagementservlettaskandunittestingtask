import l.Product;
import l.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewProducts")
public class ProductList extends HttpServlet {
    private ProductDao productDao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product>products=productDao.getAllProducts();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/ProductList.jsp").forward(req,resp);
    }
}
