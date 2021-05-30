package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import generalClass.Managers;
import impl.ManagersDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import impl.UsersDAOImpl;
import generalClass.Users;

@Controller
@RequestMapping("/user")
public class UserController {
	// 得到一个用来记录日志的对象，这样在打印信息的时候能够标记打印的是哪个类的信息
    private static final Log logger = 
    		LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/delete")
	public String delete(HttpSession session) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl(jdbcTemplate);
		Users users = (Users) session.getAttribute("users");
		session.removeAttribute("users");
		String uid = users.getUid();
		try {
			usersDAOImpl.removeUsers(uid);
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
		return "index";
	}


    /**
     * 处理登录 使用UserForm对象(实体Bean) user接收注册页面提交的请求参数
	 *
     */
    @RequestMapping(value = "/update")
	public String update(Users users, HttpSession session, HttpServletRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl(jdbcTemplate);
		Users users1 = (Users) session.getAttribute("users");
		try {
			users.setUid(users1.getUid());
			users.setWallet(users1.getWallet());
			users.setCredit(users1.getCredit());
			users.setAccess(users1.getAccess());
			usersDAOImpl.updateUsers(users);
			session.setAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ok", 0);
			return "profile";
		}
    	return "index";
	}

    @RequestMapping("/check")
	public String check(HttpSession session, HttpServletRequest request) {
    	Users users = (Users) session.getAttribute("users");
    	if (users == null) {
    		request.setAttribute("status", 0);
    		return "login";
		}
    	request.setAttribute("ok", 1);
    	return "profile";
	}

    @RequestMapping("/login")
    public String login(Users user, HttpSession session, Model model) {
//    	System.out.println(user.getUname());
//    	System.out.println(user.getUpassw());
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
    	UsersDAOImpl usersDAOImpl = new UsersDAOImpl(jdbcTemplate);
//    	usersDAOImpl.setJdbcTemplate(jdbcTemplate);
//    	if ("zhangsan".equals(user.getUname())
//                && "123456".equals(user.getUpassw())) {
//            session.setAttribute("user", user);
//            logger.info("成功");
//            //return new ModelAndView("index.jsp");; // 登录成功，跳转到 main.jsp
//            return "index";
//        } else {
//            logger.info("失败");
//            model.addAttribute("messageError", "用户名或密码错误");
//            return "login";
//        }
    	try {
    		Users users = usersDAOImpl.selectUsersByPassword(user.getEmail(), user.getPassword());
    		session.setAttribute("user", users);
    		logger.info("成功");
    		return "index";
    	} catch (Exception e) {
    		logger.info("失败");
    		System.out.println(e);
    		model.addAttribute("messageError", "用户名或密码错误");
    		return "login";
    	}
    	
    }
    /**
     * 处理注册 使用UserForm对象(实体Bean) user接收注册页面提交的请求参数
     */
    @RequestMapping("/register")
    public String register(Users user, Model model,HttpServletRequest request) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
    	UsersDAOImpl usersDAOImpl = new UsersDAOImpl(jdbcTemplate);
//        if ("zhangsan".equals(user.getUname())
//                && "123456".equals(user.getUpassw())) {
//            logger.info("成功");
//            return "login"; // 注册成功，跳转到 login.jsp
//        } else {
//            logger.info("失败");
//            System.out.print("失败");
//            // 在register.jsp页面上可以使用EL表达式取出model的uname值
//            model.addAttribute("uname", user.getUname());
//            return "register"; // 返回 register.jsp
//        }
    	try {
    		System.out.println(user);
//    		if (!usersDAOImpl.insertUsers(user)) {
//        		logger.info("失败");
//        		System.out.print("失败");
//        		model.addAttribute("uname", user.getUname());
//        		return "register";
//    		}
			boolean checked = usersDAOImpl.checkUsers(user.getEmail());
			if (!checked) {
				model.addAttribute("command", 1);
				return "register";
			}
    		String uid = usersDAOImpl.insertUsers(user);
    		logger.info("成功");
			request.setAttribute("status", 0);
    		return "login";
    	} catch (Exception e) {
    		logger.info("失败");
    		System.out.print(e);
			model.addAttribute("command", 0);
    		model.addAttribute("uname", user.getName());
    		return "register";
    	}
    }

    @RequestMapping(value = "loginOrRegister")
	public String loginOrRegister(String user, String password, int command, HttpSession httpSession, HttpServletRequest request) {
    	if (command == 0) {
    		request.setAttribute("command", command);
    		return "register";
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl(jdbcTemplate);
		try {
			Users users = usersDAOImpl.selectUsersByPassword(user, password);
			request.setAttribute("status", 0);
			httpSession.setAttribute("users", users);
		} catch (Exception e) {
			ManagersDAOImpl managersDAOImpl = new ManagersDAOImpl(jdbcTemplate);
			try {
				System.out.println(user);
				System.out.println(password);
				Managers managers = managersDAOImpl.selectManagersByPassword(user, password);
				httpSession.setAttribute("managers", managers);
				request.setAttribute("command", 3);
 			} catch (Exception a) {
				request.setAttribute("status", 1);
				a.printStackTrace();
				return "login";
			}
			return "redirect:/index/entry";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout")
	public String logOut(HttpSession session, HttpServletRequest request) {
    	session.removeAttribute("users");
    	request.setAttribute("status", 0);
    	return "login";
	}
}
