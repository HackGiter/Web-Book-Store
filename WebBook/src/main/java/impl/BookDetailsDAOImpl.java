package impl;

import com.mysql.jdbc.Statement;
import dao.BookDetailsDAO;
import generalClass.BooksDetail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.List;

public class BookDetailsDAOImpl implements BookDetailsDAO {

    private JdbcTemplate jdbcTemplate = null;

    public BookDetailsDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String insertBooksDetail(BooksDetail booksDetail) throws Exception {
        boolean flag = true;
//        if (booksDetail.getProducer().equals("")) {
//            booksDetail.setProducer(null);
//        }
//        if (booksDetail.getTranslator().equals("")) {
//            booksDetail.setTranslator(null);
//        }
//        if (booksDetail.getOtitle().equals("")) {
//            booksDetail.setOtitle(null);
//        }
        String sql = "INSERT INTO bookdetail(Otitle, Publisher, Translator, Date, Pages, Binding, ISBN, Producer) values(?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        flag = this.jdbcTemplate.update(conn -> {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, booksDetail.getOtitle());
			ps.setString(2, booksDetail.getPublisher());
			ps.setString(3, booksDetail.getTranslator());
			ps.setString(4, dateFormat.format(booksDetail.getDate()));
			ps.setInt(5, booksDetail.getPages());
			ps.setString(6, booksDetail.getBinding());
			ps.setString(7, booksDetail.getIsbn());
			ps.setString(8, booksDetail.getProducer());
			return ps;
		}, keyHolder) >= 1;
        if (!flag) {
            throw new Exception();
        }
        return keyHolder.getKey().toString();
    }

    @Override
    public BooksDetail selectBooksDetailByBDID(String bdid) throws Exception {
        String sql = "SELECT * from bookdetail WHERE BDID=?";
        Object[] params = new Object[] {bdid};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(BooksDetail.class));
    }

    @Override
    public List<BooksDetail> getBooksDetail() throws Exception {
        String sql = "SELECT * from bookdetail";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BooksDetail.class));
    }

    @Override
    public boolean updateBooksDetail(BooksDetail booksDetail) throws Exception {
        String sql = "UPDATE bookdetail SET Otitle=?,Publisher=?,Translator=?,Date=?,Pages=?,Binding=?,ISBN=?,Producer=? WHERE BDID=?";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Object[] params = new Object[] {
                booksDetail.getOtitle(),
                booksDetail.getPublisher(),
                booksDetail.getTranslator(),
                dateFormat.format(booksDetail.getDate()),
                booksDetail.getPages(),
                booksDetail.getBinding(),
                booksDetail.getIsbn(),
                booksDetail.getProducer(),
                booksDetail.getBdid()
        };
        return this.jdbcTemplate.update(sql, params)>=1;
    }


}
