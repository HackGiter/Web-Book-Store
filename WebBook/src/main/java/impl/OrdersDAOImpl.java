package impl;

import dao.OrdersDAO;
import generalClass.Orders;
import generalClass.Series;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {

    private JdbcTemplate jdbcTemplate = null;

    public OrdersDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertOrders(Orders orders) {
        String sql = "INSERT INTO orders VALUES(replace(uuid(), '-', ''),?,?,?)";
        Object[] params = new Object[]{
                orders.getAid(),
                orders.getPid(),
                orders.getType(),
                orders.getPrice(),
                orders.getNumber(),
                orders.getSuccess()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public boolean updateOrders(String oid) {
        String sql = "UPDATE orders SET Success=? WHERE OID=?";
        Object[] params = new Object[]{
                String.valueOf(1),
                oid
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<Orders> selectOrdersByPID(String pid) {
        String sql = "SELECT * FROM orders WHERE PID=?";
        Object[] params = new Object[] {pid};
        List<Orders> ordersList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Orders.class));
        return ordersList;
    }

    @Override
    public List<Orders> selectOrdersByAID(String aid) {
        String sql = "SELECT * FROM orders WHERE AID=?";
        Object[] params = new Object[] {aid};
        List<Orders> ordersList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Orders.class));
        return ordersList;
    }

    @Override
    public int[] batchInsertOrders(List<Orders> ordersList)  {
        String sql = "INSERT INTO orders(AID, PID, Name, Type, Price, Number, Success) VALUES(?,?,?,?,?,?,?)";
        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, ordersList.get(i).getAid());
                preparedStatement.setString(2, ordersList.get(i).getPid());
                preparedStatement.setString(3, ordersList.get(i).getName());
                preparedStatement.setString(4, String.valueOf(ordersList.get(i).getType()));
                preparedStatement.setDouble(5, ordersList.get(i).getPrice());
                preparedStatement.setInt(6, ordersList.get(i).getNumber());
                preparedStatement.setString(7, String.valueOf(ordersList.get(i).getSuccess()));
            }

            @Override
            public int getBatchSize() {
                return ordersList.size();
            }
        });
    }

    @Override
    public Orders selectOrdersByOID(String oid) {
        String sql = "SELECT * FROM orders WHERE OID=?";
        Object[] params = new Object[] {oid};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Orders.class));
    }
}
