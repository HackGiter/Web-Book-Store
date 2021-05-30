package impl;

import dao.BooksDAO;
import generalClass.Books;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksDAOImpl implements BooksDAO {

    private JdbcTemplate jdbcTemplate = null;

    public BooksDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String insertBooks(Books books) throws Exception {
        // TODO Auto-generated method stub
        String sql;
//        Object[] params;
        boolean flag = true;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        if (books.getSid().equals("")) {
//            sql = "INSERT INTO book(BID,Author,Name,Category,Age) VALUES(replace(uuid(), '-', ''),?,?,?,?)";
            sql = "INSERT INTO book(Author,Name,Category,Age, Country, BDID, Score, Access) values(?,?,?,?,?,?,?,?)";
//            params = new Object[]{
//                    books.getAuthor(),
//                    books.getName(),
//                    String.valueOf(books.getCategory()),
//                    books.getAge()
//            };
//            return this.jdbcTemplate.update(sql, ps -> {
//                ps.setString(1,books.getAuthor());
//                ps.setString(2,books.getName());
//                ps.setString(3,String.valueOf(books.getCategory()));
//                ps.setString(4,String.valueOf(books.getAge()));
//            }) >= 1;
            flag = this.jdbcTemplate.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,books.getAuthor());
                ps.setString(2,books.getName());
                ps.setString(3,String.valueOf(books.getCategory()));
                ps.setInt(4,books.getAge());
                ps.setString(5, books.getCountry());
                ps.setString(6, books.getBdid());
                ps.setDouble(7, books.getScore());
                ps.setString(8, String.valueOf(books.getAccess()));
                return ps;
            }, keyHolder) >= 1;
        } else {
//            sql = "INSERT INTO book VALUES(replace(uuid(), '-', ''),?,?,?,?,?)";
            sql = "INSERT INTO book(SID, Author, Name,Category,Age, Country, BDID, Score, Access) values(?,?,?,?,?,?,?,?,?)";
//            params = new Object[]{
//                    books.getSid(),
//                    books.getAuthor(),
//                    books.getName(),
//                    String.valueOf(books.getCategory()),
//                    books.getAge()
//            };
//            return this.jdbcTemplate.update(sql, ps -> {
//                ps.setString(1,books.getSid());
//                ps.setString(2,books.getAuthor());
//                ps.setString(3,books.getName());
//                ps.setString(4,String.valueOf(books.getCategory()));
//                ps.setInt(5,books.getAge());
//            }) >= 1;
            flag = this.jdbcTemplate.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,books.getSid());
                ps.setString(2,books.getAuthor());
                ps.setString(3,books.getName());
                ps.setString(4,String.valueOf(books.getCategory()));
                ps.setInt(5,books.getAge());
                ps.setString(6, books.getCountry());
                ps.setString(7, books.getBdid());
                ps.setDouble(8, books.getScore());
                ps.setString(9, String.valueOf(books.getAccess()));
                return ps;
            }, keyHolder) >= 1;
        }

        if (!flag) {
            throw new Exception();
        } else {
            return keyHolder.getKey().toString();
        }

//        if (books.getSid()==null) {
//            sql = "INSERT INTO product VALUES(replace(uuid(), '-', ''),?,?,?,?)";
//            params = new Object[]{
//                    books.getAuthor(),
//                    books.getName(),
//                    String.valueOf(books.getCategory()),
//                    books.getAge()
//            };
//        } else {
//            sql = "INSERT INTO product VALUES(replace(uuid(), '-', ''),?,?,?,?,?)";
//            params = new Object[]{
//                    books.getSid(),
//                    books.getAuthor(),
//                    books.getName(),
//                    String.valueOf(books.getCategory()),
//                    books.getAge()
//            };
//        }

//        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public boolean updateBooks(Books books) throws Exception {
        // TODO Auto-generated method stub
//        String sql = "INSERT INTO product VALUES(replace(uuid(), '-', ''),?,?,?,?,?)";
        String sql = "UPDATE book SET SID=?, Author=?, Name=?, Category=?, Age=?, Country=?, BDID=? WHERE BID=?";
        Object[] params = null;
        if (!books.getSid().equals("")) {
            params = new Object[]{
                    books.getSid(),
                    books.getAuthor(),
                    books.getName(),
                    String.valueOf(books.getCategory()),
                    books.getAge(),
                    books.getCountry(),
                    books.getBdid(),
                    books.getBid()
            };
            System.out.println(1);
        } else {
            sql = "UPDATE book SET Author=?, Name=?, Category=?, Age=?, Country=?, BDID=? WHERE BID=?";
            params = new Object[]{
                    books.getAuthor(),
                    books.getName(),
                    String.valueOf(books.getCategory()),
                    books.getAge(),
                    books.getCountry(),
                    books.getBdid(),
                    books.getBid()
            };
            System.out.println(2);
        }
        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<Books> selectBooksByName(String name) throws Exception {
        String sql = "SELECT * FROM book WHERE Name=?";
        Object[] params = new Object[] {name};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Books.class));

    }

    @Override
    public List<Books> selectBooksByCategory(int category) throws Exception {
        String sql = "SELECT * FROM book WHERE Category=? AND Access=1";
        Object[] params = new Object[] {category};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Books.class));

    }

    @Override
    public List<Books> selectBooksByAuthor(String author) throws Exception {
        String sql = "SELECT * FROM book WHERE Author=?";
        Object[] params = new Object[] {author};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Books.class));

    }

    @Override
    public List<Books> getBooksList() throws Exception{
        String sql = "SELECT * FROM book";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Books.class));
    }

    @Override
    public Books selectBooksByBID(String bid) throws Exception {
        String sql = "SELECT * FROM book where BID=?";
        Object[] param = new Object[] {bid};
        return this.jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(Books.class));

    }

    @Override
    public boolean deleteBooks(String bid) throws Exception {
        String sql = "UPDATE book SET Access=? WHERE BID=?";
        Object[] param = new Object[] {String.valueOf(0), bid};
        return this.jdbcTemplate.update(sql, param) >= 1;
    }

    @Override
    public List<Books> searchBookLike(Books books) throws Exception {
//        System.out.println(books);
        String sql = "SELECT * FROM book WHERE Name LIKE CONCAT('%',?,'%') AND Author LIKE CONCAT('%',?,'%') AND Country LIKE CONCAT('%',?,'%') AND Age >= ? AND Category=?";
        Object[] param = new Object[] {
                books.getName(),
                books.getAuthor(),
                books.getCountry(),
                books.getAge(),
                String.valueOf(books.getCategory())
        };

        return this.jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<>(Books.class));
    }

    @Override
    public boolean resetBooks(String bid) throws Exception {
        String sql = "UPDATE book SET Access=? WHERE BID=?";
        Object[] param = new Object[] {String.valueOf(1), bid};
        return this.jdbcTemplate.update(sql, param) >= 1;
    }

    @Override
    public List<Books> getBooksByBID(List<String> bid) {
        String sql = "SELECT * FROM book WHERE BID=?";
        List<Books> booksList = new ArrayList<>();
        for (String b:bid) {
            Object[] param = new Object[] {b};
            booksList.add(this.jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(Books.class)));
        }
        return booksList;
    }


}
