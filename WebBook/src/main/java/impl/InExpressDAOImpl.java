package impl;

import dao.InExpressDAO;
import generalClass.Expresses;
import generalClass.InExpress;
import generalClass.Orders;
import generalClass.Products;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InExpressDAOImpl implements InExpressDAO {

    private JdbcTemplate jdbcTemplate = null;

    public InExpressDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public int[] patchInsertExpress(String eid, List<Orders> ordersList, List<String> said, List<String> addr, String mid) {
//        String sql = "INSERT INTO inExpress(OID, PID, EID, Number, SAID, Address, Date, MID) VALUES(?,?,?,?,?,?,?,?)";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = dateFormat.format(new Date());
//        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                preparedStatement.setString(1, ordersList.get(i).getOid());
//                preparedStatement.setString(2, ordersList.get(i).getPid());
//                preparedStatement.setString(3, eid);
//                preparedStatement.setInt(4, ordersList.get(i).getNumber());
//                preparedStatement.setString(5, said.get(i));
//                preparedStatement.setString(6, addr.get(i));
//                preparedStatement.setString(7, date);
//                preparedStatement.setString(8, mid);
//            }
//
//            @Override
//            public int getBatchSize() {
//                return ordersList.size();
//            }
//        });
//    }

    @Override
    public int[] patchInsertExpress(List<InExpress> inExpressList) {
        String sql = "INSERT INTO inExpress(OID, PID, EID, Number, SAID, Address, EAddr, Date, MID) VALUES(?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, inExpressList.get(i).getOid());
                preparedStatement.setString(2, inExpressList.get(i).getPid());
                preparedStatement.setString(3, inExpressList.get(i).getEid());
                preparedStatement.setInt(4, inExpressList.get(i).getNumber());
                preparedStatement.setString(5, inExpressList.get(i).getSaid());
                preparedStatement.setString(6, inExpressList.get(i).getAddress());
                preparedStatement.setString(7, inExpressList.get(i).getEaddr());
                preparedStatement.setString(8, date);
                preparedStatement.setString(9, inExpressList.get(i).getMid());
            }

            @Override
            public int getBatchSize() {
                return inExpressList.size();
            }
        });
    }

    @Override
    public List<InExpress> getExpress(String eid){
        String sql = "SELECT * FROM inExpress WHERE EID=?";
        Object[] params = new Object[] {eid};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(InExpress.class));
    }

    @Override
    public InExpress insertInExpress(String eid, Orders orders, String said, String addr ,String eaddr, String mid){
        String sql = "INSERT INTO inExpress(OID, PID, EID, Number, SAID, Address, EAddr, Date, MID) VALUES(?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        InExpress inExpress = new InExpress();
        inExpress.setOid(orders.getOid());
        inExpress.setPid(orders.getPid());
        inExpress.setEid(eid);
        inExpress.setNumber(orders.getNumber());
        inExpress.setAddress(addr);
        try {
            inExpress.setDate(dateFormat.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        inExpress.setMid(mid);
        Object[] objects = new Object[] {
                orders.getOid(),
                orders.getPid(),
                eid,
                orders.getNumber(),
                said,
                addr,
                eaddr,
                date,
                mid,
        };
        this.jdbcTemplate.update(sql, objects);
        return inExpress;

    }
}
