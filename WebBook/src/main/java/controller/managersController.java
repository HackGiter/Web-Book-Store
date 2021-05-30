package controller;

import generalClass.Managers;
import impl.ManagersDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/manage")
public class managersController {

    @RequestMapping(value = "add")
    public String addMid(Managers managers, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        ManagersDAOImpl managersDAO = new ManagersDAOImpl(jdbcTemplate);
        try {
            managers.setDepartment("决策部");
            if (managers.getPosition().equals("仓库管理")) {
                managers.setLevel('1');
            } else if (managers.getPosition().equals("采购管理")) {
                managers.setLevel('2');
            } else if (managers.getPosition().equals("发货管理")) {
                managers.setLevel('3');
            } else {
                managers.setLevel('4');
            }
            managers.setDate(new Date());
            managersDAO.insertManagers(managers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/index/admin";
    }

    @RequestMapping(value = "control")
    public String control(HttpSession httpSession, HttpServletRequest request) {
        Managers managers = (Managers) httpSession.getAttribute("managers");
        int level = Integer.parseInt(String.valueOf(managers.getLevel()));
        if (level != 0) {
            return "redirect:/index/admin";
        }
        request.setAttribute("command", 0);
        request.setAttribute("ids", 0);
        request.setAttribute("have", 0);
        return "admin";
    }
}
