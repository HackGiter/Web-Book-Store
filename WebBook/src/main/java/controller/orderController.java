package controller;

import generalClass.*;
import impl.AllOrdersDAOImpl;
import impl.AllStoragesDAOImpl;
import impl.OrdersDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class orderController {

    @RequestMapping(value = "remove")
    public String remove(int id, HttpSession session) {
        List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
        List<Books> booksList = (List<Books>) session.getAttribute("ordersBook");
        List<String> isbnList = (List<String>) session.getAttribute("isbnList");
        ordersList.remove(id);
        booksList.remove(id);
        isbnList.remove(id);
        session.setAttribute("ordersList", ordersList);
        session.setAttribute("ordersBook", booksList);
        session.setAttribute("isbnList", isbnList);
        return "cart_info";
    }

    @RequestMapping(value = "/order_book")
    public String orderBooks(Orders orders, Books book, String isbn, HttpSession session, HttpServletRequest request) {
        Users users = (Users) session.getAttribute("users");
        System.out.println(orders);
        int record = 0;
        if (users == null) {
            request.setAttribute("status", 0);
            return "login";
        }
        List<Orders> ordersList;
        List<Books> booksList;
        List<String> isbnList;
        ordersList = (List<Orders>) session.getAttribute("ordersList");
        booksList = (List<Books>) session.getAttribute("ordersBook");
        isbnList = (List<String>) session.getAttribute("isbnList");
        orders.setPrice(orders.getPrice()*orders.getNumber());
        if (ordersList == null) {
            ordersList = new ArrayList<>();
        }
        if (booksList == null) {
            booksList = new ArrayList<>();
        }
        if (isbnList == null) {
            isbnList = new ArrayList<>();
        }
        orders.setName(book.getName());
        for (int i = 0; i < ordersList.size(); i++) {
            if (booksList.get(i).getBid().equals(book.getBid())) {
                Orders orders1 = ordersList.get(i);
                orders1.setNumber(orders1.getNumber()+orders.getNumber());
                orders1.setPrice(orders1.getPrice()+orders.getPrice());
                if (orders1.getNumber() > 10) {
                    orders1.setPrice((orders1.getPrice()/orders.getNumber())*10);
                    orders1.setNumber(10);
                }
                ordersList.set(i, orders1);
                record = 1;
            }
        }
        if (record == 0) {
            ordersList.add(orders);
            booksList.add(book);
            isbnList.add(isbn);
        }
        session.setAttribute("ordersList", ordersList);
        session.setAttribute("ordersBook", booksList);
        session.setAttribute("isbnList", isbnList);
        return "index";
    }

    @RequestMapping(value = "/change")
    public String change(int number, int id, HttpSession session) {
        List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
        Orders orders = ordersList.get(id);
        double price = (orders.getPrice() / orders.getNumber()) * number;
        orders.setNumber(number);
        orders.setPrice(price);
        ordersList.set(id, orders);
        session.setAttribute("ordersList", ordersList);
        return "cart_info";
    }

    @RequestMapping(value = "/cart")
    public String cart() {
        return "cart_info";
    }

    @RequestMapping(value = "sold")
    public String sold(HttpSession session) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
        Users users = (Users) session.getAttribute("users");
        int price = 0;
        int anumber = 0;
        try {
            AllOrdersDAOImpl allOrdersDAOImpl = new AllOrdersDAOImpl(jdbcTemplate);
            for (Orders orders: ordersList) {
                price += orders.getPrice();
                anumber += orders.getNumber();
            }
            String aid = allOrdersDAOImpl.insertOrders(users, price, ordersList.size(), anumber);
            System.out.println(aid);
            List<Orders> ordersList1 = new ArrayList<>();
            for (Orders orders: ordersList) {
                orders.setAid(aid);
                ordersList1.add(orders);
            }
            OrdersDAOImpl ordersDAOImpl = new OrdersDAOImpl(jdbcTemplate);
            int[] checked = ordersDAOImpl.batchInsertOrders(ordersList1);
            System.out.println(checked);
            session.removeAttribute("ordersList");
            session.removeAttribute("ordersBook");
            session.removeAttribute("isbnList");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cart_info";
    }

    @RequestMapping(value = "/showAll")
    public String showAll(HttpSession session, HttpServletRequest request) {
        Users users = (Users) session.getAttribute("users");
        if (users == null) {
            request.setAttribute("status", 0);
            return "login";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        AllOrdersDAOImpl allOrdersDAOImpl = new AllOrdersDAOImpl(jdbcTemplate);
        try {
            List<AllOrders> allOrdersList = allOrdersDAOImpl.selectAllOrdersByUID(users.getUid());
            OrdersDAOImpl ordersDAOImpl = new OrdersDAOImpl(jdbcTemplate);
            List<List<Orders>> LLOrders = new ArrayList<>();
            for (AllOrders allOrders:allOrdersList) {
                LLOrders.add(ordersDAOImpl.selectOrdersByAID(allOrders.getAid()));
            }
            request.setAttribute("UAllOrder", allOrdersList);
            request.setAttribute("LLOrders", LLOrders);
            request.setAttribute("have", 1);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("have", 0);
            return "user_order_place";
        }
        return "user_order_place";
    }

    @RequestMapping(value = "searchOrders")
    public String searchOrders(AllOrders allOrders, Date sqlDate, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        AllOrdersDAOImpl allOrdersDAO = new AllOrdersDAOImpl(jdbcTemplate);
        int have = 0;
        try {
            java.util.Date date = new java.util.Date(sqlDate.getTime());
            allOrders.setDate(date);
            List<AllOrders> allOrdersList =  allOrdersDAO.searchAllOrders(allOrders);
            request.setAttribute("allOrdersList", allOrdersList);
            have = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("command", 6);
        request.setAttribute("have", have);
        request.setAttribute("ids", 0);
        return "admin";
    }

    @RequestMapping(value = "searchAllStorages")
    public String searchAllstorages(AllStorages allStorages, Date sqlDate, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        AllOrdersDAOImpl allOrdersDAO = new AllOrdersDAOImpl(jdbcTemplate);
        AllStoragesDAOImpl allStoragesDAO = new AllStoragesDAOImpl(jdbcTemplate);
        int have = 0;
        try {
            java.util.Date date = new java.util.Date(sqlDate.getTime());
            allStorages.setDate(date);
            List<AllStorages> allStoragesList = allStoragesDAO.searchAllStorages(allStorages);
            request.setAttribute("allStoragesList", allStoragesList);
            have = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("command", 8);
        request.setAttribute("have", have);
        request.setAttribute("ids", 0);
        return "admin";
    }

    @RequestMapping(value = "details")
    public String orderDetail(String aid, HttpServletRequest request) {
        return "";
    }


}
