package controller;

import generalClass.*;
import impl.BookDetailsDAOImpl;
import impl.BooksDAOImpl;
import impl.ProductsDAOImpl;
import impl.StorageInfoDAOImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/books")
public class booksController {
    private static final Log logger =
            LogFactory.getLog(booksController.class);

    @RequestMapping(value = "/insertBook")
    public String insertBook(Books books, Products products, BooksDetail booksDetail, MultipartFile imgFile, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
        ProductsDAOImpl productsDAOImpl = new ProductsDAOImpl(jdbcTemplate);
        BookDetailsDAOImpl bookDetailsDAO = new BookDetailsDAOImpl(jdbcTemplate);
        StorageInfoDAOImpl storageInfoDAO = new StorageInfoDAOImpl(jdbcTemplate);
        System.out.println(imgFile.getOriginalFilename());
        try {
            String bdid = bookDetailsDAO.insertBooksDetail(booksDetail);
            books.setBdid(bdid);
            books.setAccess('1');
            StorageInfo storageInfo = storageInfoDAO.getStorageInfo(products.getSaid());
            products.setAddress(storageInfo.getAddress());
            String bid = booksDAOImpl.insertBooks(books);
            products.setBid(bid);
            products.setPName(books.getName());
            productsDAOImpl.insertProducts(products);
            String realpath = request.getServletContext().getRealPath("images");
            File targetFile = new File(realpath, bid+".jpg");
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            // 上传
            imgFile.transferTo(targetFile);
            redirectAttributes.addFlashAttribute("command", 3);
            logger.info("成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("失败");
        }
//        return "information";
        return "redirect:/index/entry";
    }

    @RequestMapping(value = "/editBook")
    public String addBookInfo(String bid, String command, HttpSession session, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
        try {
            Books books = booksDAOImpl.selectBooksByBID(bid);
            request.setAttribute("books", books);
            request.setAttribute("command", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin";
    }

    @RequestMapping(value = "/detailBook")
    public String detailBook(String bid, String location, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
        ProductsDAOImpl productsDAOImpl = new ProductsDAOImpl(jdbcTemplate);
        BookDetailsDAOImpl bookDetailsDAOImpl = new BookDetailsDAOImpl(jdbcTemplate);
        try {
            Books books = booksDAOImpl.selectBooksByBID(bid);
            Products products = productsDAOImpl.selectProductsByBID(bid);
            BooksDetail booksDetail = bookDetailsDAOImpl.selectBooksDetailByBDID(books.getBdid());
            request.setAttribute("command", 2);
            request.setAttribute("books", books);
            request.setAttribute("products", products);
            request.setAttribute("booksDetail", booksDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    @RequestMapping(value = "/addBook")
    public String addBook(HttpServletRequest request) {
        request.setAttribute("command", 3);
        return "redirect:/index/entry";
    }

    @RequestMapping(value = "/editBook2")
    public String editBook2(AllBPB allBPB,int has, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
        ProductsDAOImpl productsDAOImpl = new ProductsDAOImpl(jdbcTemplate);
        BookDetailsDAOImpl bookDetailsDAOImpl = new BookDetailsDAOImpl(jdbcTemplate);
        try {
            if (has==1) {
                bookDetailsDAOImpl.updateBooksDetail(allBPB.getBooksDetail());
            } else {
                String bdid = bookDetailsDAOImpl.insertBooksDetail(allBPB.getBooksDetail());
                Books books = allBPB.getBooks();
                books.setBdid(bdid);
                allBPB.setBooks(books);
            }
            booksDAOImpl.updateBooks(allBPB.getBooks());
            Products products = allBPB.getProducts();
            products.setPName(allBPB.getBooks().getName());
            productsDAOImpl.updateProducts(products);
            if (!allBPB.getImgFile().isEmpty()) {
                String bid = allBPB.getBooks().getBid();
                String realpath = request.getServletContext().getRealPath("images");
                File folder = new File(realpath);
                File[] files = folder.listFiles();
                for(File file:files){
                    if(file.getName().equals(bid+".jpg")){
                        file.delete();
                    }
                }
                File targetFile = new File(realpath, bid+".jpg");
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                // 上传
                allBPB.getImgFile().transferTo(targetFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("command", 3);
        return "redirect:/index/entry";

    }

    @RequestMapping(value = "search")
    public String searchBook(Books books, HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
        BooksDAOImpl booksDAOImpl = new BooksDAOImpl(jdbcTemplate);
        int have = 0;
        try {
            List<Books> booksList = booksDAOImpl.searchBookLike(books);
            request.setAttribute("booksList", booksList);
            System.out.println(booksList);
            have = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("command", 3);
        request.setAttribute("have", have);
        request.setAttribute("ids", 0);
        return "admin";
    }
}
