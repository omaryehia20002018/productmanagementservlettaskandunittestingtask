package l;

import l.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static List<Product> products=new ArrayList<>();

    public List<Product> getAllProducts(){
        return products;
    }
    public void addProduct(Product product){
        products.add(product);
    }

    public ProductDao() {
    }
}
