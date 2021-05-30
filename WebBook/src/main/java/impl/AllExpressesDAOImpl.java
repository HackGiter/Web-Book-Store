package impl;

import dao.AllExpressesDAO;
import generalClass.AllExpresses;
import generalClass.AllOrders;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AllExpressesDAOImpl implements AllExpressesDAO {


    private JdbcTemplate jdbcTemplate = null;

    public AllExpressesDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertAllExpresses(AllOrders allOrders, String edid){
        String sql = "INSERT allexpress(EID, AID, Number, Date, Success) values(?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Random random = new Random();
        String eid = "CKD" + random.nextInt(10) +String.format("%03d", allOrders.getAnumbers());
        String dateTime = dateFormat.format(new Date());
        eid += dateTime.replace(":", "").replace("-", "").replace(" ", "");
        String finalEid = eid;
        return this.jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, finalEid);
            ps.setString(2, allOrders.getAid());
            ps.setInt(3, allOrders.getAnumbers());
            ps.setString(4, dateTime);
            ps.setString(5, String.valueOf(0));
            return ps;
        }) >= 1;
    }

    @Override
    public List<AllExpresses> getAllExpresses() {
        String sql = "SELECT * FROM allexpress";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AllExpresses.class));
    }

    @Override
    public AllExpresses selectAllExpressesByAID(String aid) {
        String sql = "SELECT * FROM allexpress WHERE AID=?";
        Object[] params = new Object[] {aid};
        AllExpresses allExpresses;
        try {
            allExpresses = this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(AllExpresses.class));
        } catch (Exception e) {
            allExpresses = null;
            e.printStackTrace();
        }
        return allExpresses;
    }

    @Override
    public void updateAllExpress(String aid) {
        String sql = "UPDATE allexpress SET Success=? WHERE AID=?";
        Object[] params = new Object[] {
                String.valueOf(1),
                aid
        };
        this.jdbcTemplate.update(sql, params);
    }
}
