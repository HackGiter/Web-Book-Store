package impl;

import dao.AllOrdersDAO;
import generalClass.AllOrders;
import generalClass.Users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AllOrdersDAOImpl implements AllOrdersDAO {

    private JdbcTemplate jdbcTemplate = null;

    public AllOrdersDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertAllOrders(AllOrders allorders) {
        String sql = "INSERT INTO allorders VALUES(replace(uuid(), '-', ''),?,?,?,?,?,?)";
        Object[] params = new Object[]{
                allorders.getAid(),
                allorders.getUid(),
                allorders.getAddress(),
                allorders.getPhone(),
                allorders.getDate(),
                allorders.getPays(),
                allorders.getNumbers()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public boolean updateAllOrders(String aid) {
        String sql = "UPDATE allorders SET Success=? WHERE AID=?";
        Object[] params = new Object[]{
                String.valueOf(1),
                aid
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<AllOrders> selectAllOrdersByUID(String uid) {
        String sql = "SELECT * FROM allorders WHERE UID=?";
        Object[] params = new Object[] {uid};
        List<AllOrders> allordersList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AllOrders.class));
        return allordersList;
    }

    @Override
    public AllOrders selectAllOrdersByAID(String aid) {
        String sql = "SELECT * FROM allorders WHERE AID=?";
        Object[] params = new Object[] {aid};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(AllOrders.class));
    }

    @Override
    public List<AllOrders> getAllOrdersList() {
        String sql = "SELECT * FROM allorders";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AllOrders.class));
    }

    @Override
    public String insertOrders(Users users, double Price, int number, int anumber) {
        boolean flag = true;
        String sql = "INSERT INTO allorders(AID, UID, Name, Address, Phone, Date, Pays, Numbers, Anumbers, Success) VALUES(?,?,?,?,?,?,?,?,?,?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Object[] params = new Object[] {users.getUid(), users.getAddress(), users.getPhone(), new Date(), Price, number, '0'};
        Random random = new Random();
        String aid = "XSD"+String.valueOf(random.nextInt(10))+String.format("%03d", number);
        String dateTime = dateFormat.format(new Date());
        aid += dateTime.replace(":", "").replace("-", "").replace(" ", "");
        String finalAid = aid;
        System.out.println(users);
        flag = this.jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, finalAid);
            ps.setString(2,users.getUid());
            ps.setString(3,users.getName());
            ps.setString(4,users.getAddress());
            ps.setString(5,users.getPhone());
            ps.setString(6, dateTime);
            ps.setDouble(7,Price);
            ps.setInt(8, number);
            ps.setInt(9, anumber);
            ps.setString(10, String.valueOf('0'));
            return ps;
        }) >= 1;
        return finalAid;
    }

    @Override
    public List<AllOrders> searchAllOrders(AllOrders allOrders) {
        String sql = "SELECT * FROM allorders WHERE AID LIKE CONCAT('%',?,'%') AND Name LIKE CONCAT('%',?,'%') AND Address LIKE CONCAT('%',?,'%') AND Phone LIKE CONCAT('%',?,'%') AND Pays>=? AND Date >= ? AND Numbers>=? AND Anumbers>=? AND Success LIKE CONCAT('%',?,'%')";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Object[] objects = new Object[] {
                allOrders.getAid(),
                allOrders.getName(),
                allOrders.getAddress(),
                allOrders.getPhone(),
                allOrders.getPays(),
                dateFormat.format(allOrders.getDate()),
                allOrders.getNumbers(),
                allOrders.getAnumbers(),
                String.valueOf(allOrders.getSuccess()),
        };
        return this.jdbcTemplate.query(sql, objects, new BeanPropertyRowMapper<>(AllOrders.class));
    }


}
