package controller;

import generalClass.Books;
import generalClass.Products;
import impl.BooksDAOImpl;
import impl.ProductsDAOImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private static final Log logger =
            LogFactory.getLog(ProductsController.class);

    @RequestMapping(value = "/searchProducts")
    public String searchProducts(Products products, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        ProductsDAOImpl productsDAO = new ProductsDAOImpl(jdbcTemplate);
        BooksDAOImpl booksDAO = new BooksDAOImpl(jdbcTemplate);
        int have = 0;
        try {
            List<Products> productsList = productsDAO.searchProduct(products);
            List<String> bid = new ArrayList<>();
            for (Products productss:productsList) {
                bid.add(productss.getBid());
            }
            List<Books> booksList = booksDAO.getBooksByBID(bid);
            request.setAttribute("productsList", productsList);
            have = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("command", 4);
        request.setAttribute("have", have);
        request.setAttribute("ids", 0);
        return "admin";
    }
}
