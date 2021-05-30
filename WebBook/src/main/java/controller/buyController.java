package controller;

import generalClass.AllBuys;
import generalClass.Products;
import impl.AllBuysDAOImpl;
import impl.ProductsDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/buys")
public class buyController {
    @RequestMapping(value = "/searchBuys")
    public String searchProducts(AllBuys allBuys, Date sqlDate, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        AllBuysDAOImpl allBuysDAO = new AllBuysDAOImpl(jdbcTemplate);
        java.util.Date date = new java.util.Date(sqlDate.getTime());
        allBuys.setDate(date);
        int have = 0;
        try {
            List<AllBuys> allBuysList = allBuysDAO.searchAllBuys(allBuys);
            request.setAttribute("allBuysList", allBuysList);
            have = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("command", 7);
        request.setAttribute("have", have);
        request.setAttribute("ids", 0);
        return "admin";
    }
}
