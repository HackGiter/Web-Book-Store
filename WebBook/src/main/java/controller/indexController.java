package controller;

import generalClass.*;
import impl.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* “@Controller”表示 IndexController 的实例是一个控制器
*
* @Controller相当于@Controller(@Controller) 或@Controller(value="@Controller")
*/

@Controller
@RequestMapping("/index")
public class indexController {
    private static final Log logger = 
    		LogFactory.getLog(indexController.class);

    private Managers managers = null;
    private int level = 0;


    @RequestMapping(value = "/home")
    public String home() {
        return "index";
    }

    // 处理请求的方法
	// 方法级别注解
    @RequestMapping(value = "/login")
    public String login(HttpSession session,HttpServletRequest request) {
        /**
         * login代表逻辑视图名称，需要根据Spring MVC配置
         * 文件中internalResourceViewResolver的前缀和后缀找到对应的物理视图
         */
        return "login";
    }
    @RequestMapping(value = "/register")
    public String register(Model model) {
    	model.addAttribute("success", "注册成功");
        return "register";
    }


    @RequestMapping(value = "/admin")
    public String AdminInfo(@RequestParam(value = "ids", defaultValue = "0")int ids, @RequestParam(value = "command", defaultValue = "3")int command, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        int have = 0;

        if (command == 1) {
            StorageInfoDAOImpl storageInfoDAO = new StorageInfoDAOImpl(jdbcTemplate);
            List<String> stringList = storageInfoDAO.countStorages();
            System.out.println(stringList);
            request.setAttribute("stringList", stringList);
        } else if (command == 3) {
            BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
            try {
                List<Books> booksList = booksDAOImpl.getBooksList();
                System.out.println(booksList);
                request.setAttribute("booksList", booksList);
                have = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command == 4) {
            try {
                ProductsDAOImpl productsDAOImpl = new ProductsDAOImpl(jdbcTemplate);
                List<Products> productsList = productsDAOImpl.selectProductsList();
                request.setAttribute("productsList", productsList);
                have = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command == 5) {
            try {
                SeriesDAOImpl seriesDAOImpl = new SeriesDAOImpl(jdbcTemplate);
                List<Series> seriesList  = seriesDAOImpl.getSeriesLists();
                request.setAttribute("seriesList", seriesList);
                have = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command == 6) {
            try {
                AllOrdersDAOImpl allOrdersDAOImpl = new AllOrdersDAOImpl(jdbcTemplate);
                List<AllOrders> allOrdersList = allOrdersDAOImpl.getAllOrdersList();
                request.setAttribute("allOrdersList", allOrdersList);
                have = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command == 7) {
            try {
                AllBuysDAOImpl allBuysDAOImpl = new AllBuysDAOImpl(jdbcTemplate);
                List<AllBuys> allBuysList = allBuysDAOImpl.getAllBuysList();
                request.setAttribute("allBuysList", allBuysList);
                have = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command == 8) {
            try {
                AllStoragesDAOImpl allStoragesDAOImpl = new AllStoragesDAOImpl(jdbcTemplate);
                List<AllStorages> allStoragesList = allStoragesDAOImpl.getAllStoragesList();
                request.setAttribute("allStoragesList", allStoragesList);
                have = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command == 9) {
            try {
                AllExpressesDAOImpl allExpressesDAOImpl = new AllExpressesDAOImpl(jdbcTemplate);
                List<AllExpresses> allExpressesList = allExpressesDAOImpl.getAllExpresses();
                request.setAttribute("allexpressesList", allExpressesList);
                have = 1;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command == 10) {
            try {
                BookDetailsDAOImpl bookDetailsDAO = new BookDetailsDAOImpl(jdbcTemplate);
                List<BooksDetail> booksDetailList = bookDetailsDAO.getBooksDetail();
                request.setAttribute("booksDetailList", booksDetailList);
                have = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (command == 11) {

            StorageInfoDAOImpl storageInfoDAO = new StorageInfoDAOImpl(jdbcTemplate);
            List<StorageInfo> storageInfoList = storageInfoDAO.getStorageInfoList();
            request.setAttribute("storageInfoList", storageInfoList);
            have = 1;
        }
        System.out.println(command);
        System.out.println(ids);
        request.setAttribute("command", command);
        request.setAttribute("have", have);
        request.setAttribute("ids", ids);
        return "admin";
    }

    @RequestMapping(value = "/entry")
    public String entry(@RequestParam(value = "command", required = true, defaultValue = "3")int command, HttpServletRequest request, HttpSession session) {
//        System.out.println(command);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);

        managers = (Managers) session.getAttribute("managers");
        level = Integer.parseInt(String.valueOf(managers.getLevel()));
        int have = 0;
        try {
            System.out.println(level);
            if (level == 0) {
                BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
                List<Books> booksList = booksDAOImpl.getBooksList();
                have = 1;
                request.setAttribute("have", have);
                request.setAttribute("command", 3);
                request.setAttribute("booksList", booksList);
            } else if (level == 1) {
                AllStoragesDAOImpl allStoragesDAO = new AllStoragesDAOImpl(jdbcTemplate);
                List<AllStorages> allStoragesList = allStoragesDAO.getAllStoragesList();
                have = 1;
                request.setAttribute("have", have);
                request.setAttribute("command", 8);
                request.setAttribute("allStoragesList", allStoragesList);
            } else if (level == 2) {
                AllBuysDAOImpl allBuysDAO = new AllBuysDAOImpl(jdbcTemplate);
                List<AllBuys> allBuysList = allBuysDAO.getAllBuysList();
                have = 1;
                request.setAttribute("have", have);
                request.setAttribute("command", 7);
                request.setAttribute("allBuysList", allBuysList);
            } else if (level == 3) {
                AllOrdersDAOImpl allOrdersDAO = new AllOrdersDAOImpl(jdbcTemplate);
                List<AllOrders> allOrdersList = allOrdersDAO.getAllOrdersList();
                have = 1;
                request.setAttribute("have", have);
                request.setAttribute("command", 6);
                request.setAttribute("allOrdersList", allOrdersList);
            } else if (level == 4) {
                AllBuysDAOImpl allBuysDAO = new AllBuysDAOImpl(jdbcTemplate);
                List<AllBuys> allBuysList = allBuysDAO.getAllBuysList();
                have = 1;
                request.setAttribute("have", have);
                request.setAttribute("command", 7);
                request.setAttribute("allBuysList", allBuysList);
            }

        } catch (Exception a) {
            a.printStackTrace();
        }
        request.setAttribute("ids", 0);
        return "admin";


    }

    @RequestMapping(value = "/orders")
    public String ordersToExpress(@RequestParam(value = "aid") String aid, HttpServletRequest request, HttpSession session) {
        int command = 0;
//        Managers managers = (Managers) session.getAttribute("managers");
//        int level = Integer.parseInt(String.valueOf(managers.getLevel()));
        if (!(level == 0 || level == 3 || level==1 )) {
            return "redirect:/index/admin";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        AllOrdersDAOImpl allOrdersDAOImpl = new AllOrdersDAOImpl(jdbcTemplate);
        OrdersDAOImpl ordersDAOImpl = new OrdersDAOImpl(jdbcTemplate);
        ExpressesDAOImpl expressesDAO = new ExpressesDAOImpl(jdbcTemplate);
        AllExpressesDAOImpl allExpressesDAO = new AllExpressesDAOImpl(jdbcTemplate);
        List<Expresses> expressesList = new ArrayList<>();
        try {
            AllOrders allOrders = allOrdersDAOImpl.selectAllOrdersByAID(aid);
            List<Orders> ordersList =  ordersDAOImpl.selectOrdersByAID(aid);
            for (int i = 0; i < ordersList.size(); i++) {
                if (ordersList.get(i).getSuccess() == '1') {
                    Expresses expresses = expressesDAO.selectExpressesByOID(ordersList.get(i).getOid());
                    if (expresses != null) {
                        expressesList.add(expresses);
                    }

                }
            }
            if (expressesList.size()==ordersList.size()) {
                allOrdersDAOImpl.updateAllOrders(allOrders.getAid());
                allExpressesDAO.updateAllExpress(allOrders.getAid());
                allOrders.setSuccess('1');
            }
            request.setAttribute("allOrders", allOrders);
            request.setAttribute("ordersList", ordersList);
            request.setAttribute("expressesList", expressesList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("have", 0);
        request.setAttribute("ids", 6);
        request.setAttribute("command", command);
        return "admin";
    }

    @RequestMapping(value = "/express")
    public String dealWithExpress(String ed, String deliver, String oid, String aid, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        AllExpressesDAOImpl allExpressesDAOImpl = new AllExpressesDAOImpl(jdbcTemplate);
        AllOrdersDAOImpl allOrdersDAOImpl = new AllOrdersDAOImpl(jdbcTemplate);
        OrdersDAOImpl ordersDAOImpl = new OrdersDAOImpl(jdbcTemplate);
//        UsersDAOImpl usersDAOImpl = new UsersDAOImpl(jdbcTemplate);
        InExpressDAOImpl inExpressDAO = new InExpressDAOImpl(jdbcTemplate);
        ExpressesDAOImpl expressesDAO = new ExpressesDAOImpl(jdbcTemplate);
        ProductsDAOImpl productsDAO = new ProductsDAOImpl(jdbcTemplate);
        AllExpresses allExpresses = null;
        InExpress inExpress = null;
        AllOrders allOrders = null;
        Orders orders = null;
        Products products = null;
        String name = null;
        try {
            orders = ordersDAOImpl.selectOrdersByOID(oid);
            allOrders = allOrdersDAOImpl.selectAllOrdersByAID(aid);
//            name = usersDAOImpl.getNameByUID(allOrders.getUid());
            products = productsDAO.selectProductsByPID(orders.getPid());
            productsDAO.updateProductsNumber(orders.getPid(), products.getNumber()-orders.getNumber());
            productsDAO.updateProductsSale(orders.getPid(), products.getSale()+orders.getNumber());
            allExpresses =  allExpressesDAOImpl.selectAllExpressesByAID(aid);
            inExpress = inExpressDAO.insertInExpress(allExpresses.getEid(), orders, products.getSaid(), allOrders.getAddress(), products.getAddress(), managers.getMid());
            String edid = expressesDAO.insertExpressByInExpress(inExpress, ed, deliver, name, allOrders.getPhone());
            ordersDAOImpl.updateOrders(orders.getOid());
            request.setAttribute("allexpressesList", allExpressesDAOImpl.getAllExpresses());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (allExpressesDAOImpl.insertAllExpresses(allOrders, aid)) {
                    allExpresses = allExpressesDAOImpl.selectAllExpressesByAID(aid);
                }
                inExpress = inExpressDAO.insertInExpress(allExpresses.getEid(), orders, products.getSaid(), allOrders.getAddress(), products.getAddress(), managers.getMid());
                String edid = expressesDAO.insertExpressByInExpress(inExpress, ed, deliver, name, allOrders.getPhone());
                ordersDAOImpl.updateOrders(orders.getOid());
                request.setAttribute("allexpressesList", allExpressesDAOImpl.getAllExpresses());
            } catch (Exception a) {
                a.printStackTrace();
            }

        }
//        request.setAttribute("have", 1);
//        request.setAttribute("ids", 0);
//        request.setAttribute("command", 9);
//
//        return "admin";
        return "redirect:/index/orders?aid="+allOrders.getAid();
    }

    @RequestMapping(value = "/express2")
    public String dealWithExpress(AllDeliver allDeliver, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        AllExpressesDAOImpl allExpressesDAOImpl = new AllExpressesDAOImpl(jdbcTemplate);
        AllOrdersDAOImpl allOrdersDAOImpl = new AllOrdersDAOImpl(jdbcTemplate);
        OrdersDAOImpl ordersDAOImpl = new OrdersDAOImpl(jdbcTemplate);
//        UsersDAOImpl usersDAOImpl = new UsersDAOImpl(jdbcTemplate);
        InExpressDAOImpl inExpressDAO = new InExpressDAOImpl(jdbcTemplate);
        ExpressesDAOImpl expressesDAO = new ExpressesDAOImpl(jdbcTemplate);
        ProductsDAOImpl productsDAO = new ProductsDAOImpl(jdbcTemplate);
        AllExpresses allExpresses = null;
//        InExpress inExpress = null;
        List<InExpress> inExpressList = new ArrayList<>();
        List<Expresses> expressesList = new ArrayList<>();
        AllOrders allOrders = null;
        Orders orders = null;
        Products products = null;
        allOrders = allOrdersDAOImpl.selectAllOrdersByAID(allDeliver.getAid());
        allExpresses =  allExpressesDAOImpl.selectAllExpressesByAID(allDeliver.getAid());
        if (allExpresses == null) {
            allExpressesDAOImpl.insertAllExpresses(allOrders, allDeliver.getAid());
            allExpresses = allExpressesDAOImpl.selectAllExpressesByAID(allDeliver.getAid());
        }

        for (int i = 0; i < allDeliver.getDeliverList().size(); i++) {
            orders = ordersDAOImpl.selectOrdersByOID(allDeliver.getDeliverList().get(i).getOid());
            products = productsDAO.selectProductsByPID(orders.getPid());
            productsDAO.updateProductsNumber(orders.getPid(), products.getNumber()-orders.getNumber());
            productsDAO.updateProductsSale(orders.getPid(), products.getSale()+orders.getNumber());
            InExpress inExpress = new InExpress();
            inExpress.setMid(managers.getMid());
            inExpress.setEid(allExpresses.getEid());
            inExpress.setOid(orders.getOid());
            inExpress.setPid(products.getPid());
            inExpress.setAddress(allOrders.getAddress());
            inExpress.setEaddr(products.getAddress());
            inExpress.setSaid(products.getSaid());
            inExpress.setNumber(orders.getNumber());
            inExpressList.add(inExpress);

            Expresses expresses = new Expresses();
            expresses.setEid(allExpresses.getEid());
            expresses.setOid(orders.getOid());
            expresses.setEd(allDeliver.getDeliverList().get(i).getEd());
            expresses.setNumber(orders.getNumber());
            expresses.setName(allOrders.getName());
            expresses.setAddress(allOrders.getAddress());
            expresses.setPhone(allOrders.getPhone());
            expresses.setDeliver(allDeliver.getDeliverList().get(i).getDeliver());
            expressesList.add(expresses);
            ordersDAOImpl.updateOrders(orders.getOid());
        }
        inExpressDAO.patchInsertExpress(inExpressList);
        expressesDAO.patchInsertExpress(expressesList);

        request.setAttribute("allexpressesList", allExpressesDAOImpl.getAllExpresses());
        return "redirect:/index/orders?aid="+allOrders.getAid();
    }


    @RequestMapping(value = "buy")
    public String buy(HttpServletRequest request) {
        if (!(level == 0 || level==2 )) {
            int command = 3;
            if (level == 1) {
                command = 8;
            } else if (level == 3) {
                command = 6;
            } else {
                command = 7;
            }
            return "redirect:/index/admin?command="+String.valueOf(command);
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        ProductsDAOImpl productsDAO = new ProductsDAOImpl(jdbcTemplate);
        try {
            request.setAttribute("productsList", productsDAO.selectProductsList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("command", 0);
        request.setAttribute("ids", 7);
        request.setAttribute("have", 0);
        return "admin";
    }

    @RequestMapping(value = "allBuy")
    public String dealWithBuy(AllBuyList allBuyList, AllBuys allBuys) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        AllBuysDAOImpl allBuysDAO = new AllBuysDAOImpl(jdbcTemplate);
        BuysDAOImpl buysDAOImpl = new BuysDAOImpl(jdbcTemplate);
        allBuys.setNumber(allBuyList.getBuysList().size());
        allBuys.setMid(managers.getMid());
        double allPrice = 0;
        int number = 0;
        for (Buys buys:allBuyList.getBuysList()) {
            allPrice += buys.getPrice();
            number += buys.getNumber();
        }
        allBuys.setPrice(allPrice);
        allBuys.setAnumber(number);
        try {
            String abid = allBuysDAO.insertAllBuys(allBuys);
            buysDAOImpl.patchInsertBuys(allBuyList.getBuysList(), abid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/index/entry";
    }

    @RequestMapping(value = "/storage")
    public String dealWithStorage(@RequestParam(value = "abid") String abid, HttpServletRequest request) {
        int level = Integer.parseInt(String.valueOf(managers.getLevel()));
        if (!(level==0||level==4)) {
            return "redirect:/index/admin?command=7";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        AllBuysDAOImpl allBuysDAO = new AllBuysDAOImpl(jdbcTemplate);
        BuysDAOImpl buysDAOImpl = new BuysDAOImpl(jdbcTemplate);
        StorageDAOImpl storageDAO = new StorageDAOImpl(jdbcTemplate);
        List<Storages> storagesList = new ArrayList<>();
        try {
            AllBuys allBuys = allBuysDAO.selectAllBuysByABID(abid);
            List<Buys> buysList = buysDAOImpl.selectBuysByABID(abid);
            for (int i = 0; i < buysList.size(); i++) {
                if (buysList.get(i).getSuccess() == '1') {
                    storagesList.add(storageDAO.getStorages(buysList.get(i).getBid()));
                }
            }
            if (storagesList.size()==buysList.size() && allBuys.getSuccess() == '0') {
                allBuysDAO.updateOneAllBuys(abid);
                allBuys.setSuccess('1');
            }
            request.setAttribute("allBuys", allBuys);
            request.setAttribute("buysList", buysList);
            request.setAttribute("storagesList", storagesList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("have", 0);
        request.setAttribute("ids", 8);
        request.setAttribute("command", 0);
        return "admin";
    }


    @RequestMapping(value = "/allstorage")
    public String allStorageDone(AllBuyList allBuyList, HttpSession httpSession) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        AllBuysDAOImpl allBuysDAO = new AllBuysDAOImpl(jdbcTemplate);
        BuysDAOImpl buysDAOImpl = new BuysDAOImpl(jdbcTemplate);
        StorageDAOImpl storageDAO = new StorageDAOImpl(jdbcTemplate);
        AllStoragesDAOImpl allStoragesDAO = new AllStoragesDAOImpl(jdbcTemplate);
        ProductsDAOImpl productsDAO = new ProductsDAOImpl(jdbcTemplate);
        List<Storages> storagesList = new ArrayList<>();
        AllStorages allStorages = null;
        AllBuys allBuys = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Buys> newBL = new ArrayList<>();
        String arid = null;
        System.out.println(allBuyList);
        try {
            allBuys = allBuysDAO.selectAllBuysByABID(allBuyList.getBuysList().get(0).getAbid());
            allStorages = allStoragesDAO.selectAllStoragesByABID(allBuys.getAbid());
            if (allBuyList.getBuysList().size()==allBuys.getNumber()) {
                allStoragesDAO.updateAllStorages(allStorages.getArid());
                allStorages.setSuccess('1');
            }
            arid = allStorages.getArid();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                allStorages = new AllStorages();
                allStorages.setNumber(allBuys.getNumber());
                allStorages.setSuccess('0');
                allStorages.setDate(dateFormat.parse(dateFormat.format(new Date())));
                allStorages.setAbid(allBuys.getAbid());
                if (allBuyList.getBuysList().size()==allBuys.getNumber()) {
                    allStorages.setSuccess('1');
                }
                arid = allStoragesDAO.insertAllStorages(allStorages);
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
        try {
            for (int i = 0; i < allBuyList.getBuysList().size(); i++) {
                Buys buys = allBuyList.getBuysList().get(i);
                Products products = productsDAO.selectProductsByPID(buys.getPid());
                productsDAO.updateProductsNumber(buys.getPid(), products.getNumber()+buys.getNumber());
                Storages storages = new Storages();
                storages.setBid(buys.getBid());
                storages.setPid(buys.getPid());
                storages.setNumber(buys.getNumber());
                storages.setSaid(products.getSaid());
                storages.setAddress(products.getAddress());
                storages.setArid(arid);
                storages.setMid(managers.getMid());
                storages.setSuccess('1');
                storagesList.add(storages);
                buys.setSuccess('1');
                newBL.add(buys);
            }
            storageDAO.patchInsertStorages(storagesList);
            buysDAOImpl.patchUpdateBuys(newBL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/index/storage?abid="+allBuys.getAbid();
    }

    @RequestMapping(value = "editbook")
    public String editBook(String bid, HttpServletRequest request) {
        if (!(level == 0 || level == 2)) {
            return "redirect:/index/admin";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
        ProductsDAOImpl productsDAOImpl = new ProductsDAOImpl(jdbcTemplate);
        BookDetailsDAOImpl bookDetailsDAO = new BookDetailsDAOImpl(jdbcTemplate);
        Books books = null;
        Products products = null;
        BooksDetail booksDetail;
        int has = 0;
        try {
            books = booksDAOImpl.selectBooksByBID(bid);
            products = productsDAOImpl.selectProductsByBID(bid);
            booksDetail = bookDetailsDAO.selectBooksDetailByBDID(books.getBdid());
            has = 1;
        } catch (Exception e) {
            e.printStackTrace();
            booksDetail = new BooksDetail();
        }
        request.setAttribute("command", 0);
        request.setAttribute("ids", 3);
        request.setAttribute("has", has);
        request.setAttribute("books", books);
        request.setAttribute("products", products);
        request.setAttribute("booksDetail", booksDetail);
        request.setAttribute("have", 0);
        return "admin";
    }

    @RequestMapping(value = "/editBuy")
    public String editBuy(@RequestParam(value = "abid") String abid, HttpServletRequest request, HttpSession session) {
//        Managers managers = (Managers) session.getAttribute("managers");
//        int level = Integer.parseInt(String.valueOf(managers.getLevel()));
        if (!(level==0||level==2)) {
            return "redirect:/index/admin";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        AllBuysDAOImpl allBuysDAO = new AllBuysDAOImpl(jdbcTemplate);
        BuysDAOImpl buysDAOImpl = new BuysDAOImpl(jdbcTemplate);
        ProductsDAOImpl productsDAO = new ProductsDAOImpl(jdbcTemplate);
        try {
            AllBuys allBuys = allBuysDAO.selectAllBuysByABID(abid);
            List<Buys> buysList = buysDAOImpl.selectBuysByABID(abid);
            List<Products> productsList = productsDAO.selectProductsList();
            request.setAttribute("allBuys", allBuys);
            request.setAttribute("buysList", buysList);
            request.setAttribute("productsList", productsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("have", 0);
        request.setAttribute("ids", 5);
        request.setAttribute("command", 0);
        return "admin";
    }

    @RequestMapping(value = "/editBuy2")
    public String edit2Buy(AllBuys allBuys, AllBuyList allBuyList, int length, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        AllBuysDAOImpl allBuysDAO = new AllBuysDAOImpl(jdbcTemplate);
        BuysDAOImpl buysDAOImpl = new BuysDAOImpl(jdbcTemplate);
        try {
            if (allBuys.getSuccess() == '1') {
                List<Buys> deleteList = buysDAOImpl.selectBuysByABID(allBuys.getAbid());
                buysDAOImpl.patchDeleteBuys(deleteList);
                allBuysDAO.deleteAllBuys(allBuys.getAbid());
            } else {

                int price = 0;
                int anumber = 0;
//                for (int i = 0; i < allBuyList.getBuysList().size(); i++) {
//                    price += allBuyList.getBuysList().get(i).getPrice();
//                }

                List<Buys> updateList = new ArrayList<>();
                List<Buys> insertList = new ArrayList<>();
                List<Buys> deleteList = new ArrayList<>();

                for (int i = 0; i < allBuyList.getBuysList().size(); i++) {
                    if (i < length) {
                        if (allBuyList.getBuysList().get(i).getSuccess() == '1') {
                            deleteList.add(allBuyList.getBuysList().get(i));
                        } else {
                            updateList.add(allBuyList.getBuysList().get(i));
                            price += allBuyList.getBuysList().get(i).getPrice();
                            anumber += allBuyList.getBuysList().get(i).getNumber();
                        }
                    } else {
                        insertList.add(allBuyList.getBuysList().get(i));
                        price += allBuyList.getBuysList().get(i).getPrice();
                        anumber += allBuyList.getBuysList().get(i).getNumber();
                    }
                }

                allBuys.setPrice(price);
                allBuys.setAnumber(anumber);
                buysDAOImpl.patchInsertBuys(insertList, allBuys.getAbid());
                buysDAOImpl.patchDeleteBuys(deleteList);
                buysDAOImpl.patchUpdateBuys(updateList);
                allBuys.setNumber(insertList.size()+updateList.size());
                allBuysDAO.updateAllBuys(allBuys);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("have", 0);
        request.setAttribute("ids", 8);
        request.setAttribute("command", 0);
        return "redirect:/index/admin?command=7";
    }

    @RequestMapping(value = "deleteProduct")
    public String deleteProduct(String bid, HttpServletRequest request, HttpSession session) {
//        Managers managers = (Managers) session.getAttribute("managers");
//        int level = Integer.parseInt(String.valueOf(managers.getLevel()));
        if (!(level == 0)) {
            return "redirect:/index/admin";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        BooksDAOImpl booksDAO = new BooksDAOImpl(jdbcTemplate);
        try {
            booksDAO.deleteBooks(bid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/index/admin";
    }

    @RequestMapping(value = "getProducts")
    public String resetProduct(String bid , HttpServletRequest request) {
        if (!(level == 0)) {
            return "redirect:/index/admin";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        BooksDAOImpl booksDAO = new BooksDAOImpl(jdbcTemplate);
        try {
            booksDAO.resetBooks(bid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/index/admin";
    }

    @RequestMapping("addStorage")
    public String addStorage(StorageInfo storageInfo) {
        if (!(level == 0 || level == 1)) {
            return "redirect:/index/admin";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        StorageInfoDAOImpl storageInfoDAO = new StorageInfoDAOImpl(jdbcTemplate);
        storageInfoDAO.insertStorageInfo(storageInfo);
        return "redirect:/index/admin?command=11";
    }

}
