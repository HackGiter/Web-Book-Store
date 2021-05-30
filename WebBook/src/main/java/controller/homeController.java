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
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.util.List;

@Controller
public class homeController {
    String[] titles = {"文学", "流行", "文化", "生活", "经管", "科技"};
    private static final Log logger =
            LogFactory.getLog(homeController.class);

    @RequestMapping("/")
    public String index(HttpSession session){
  		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  		JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
		try {
			BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
			session.setAttribute("command", 3);
	  	    for (int i = 0; i < titles.length; i++) {
	            List<Books> booksList = booksDAOImpl.selectBooksByCategory(i);
	            session.setAttribute(titles[i], booksList);
	        }
			logger.info("Body Load 成功");
		} catch (Exception e) {
			logger.info("Body Load 失败");
			e.printStackTrace();
		}
		return "index";
    }
}
