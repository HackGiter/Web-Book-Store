package impl;

import dao.BuysDAO;
import generalClass.AllBuys;
import generalClass.Buys;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BuysDAOImpl implements BuysDAO {

    private JdbcTemplate jdbcTemplate = null;

    public BuysDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean insertBuys(Buys buys) throws Exception {
        String sql = "INSERT INTO buy VALUES(replace(uuid(), '-', ''),?,?,?,?,?)";
        Object[] params = new Object[]{
                buys.getPid(),
                buys.getAbid(),
                buys.getNumber(),
                buys.getPrice(),
                String.valueOf(0)
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public boolean updateBuys(Buys buys) throws Exception {
        String sql = "UPDATE buy SET Success=? WHERE BID=?";
        Object[] params = new Object[]{
                String.valueOf(buys.getSuccess()),
                buys.getBid()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<Buys> selectBuysByBID(String bid) throws Exception {
        String sql = "SELECT * FROM buy WHERE BID=?";
        Object[] params = new Object[] {bid};
        List<Buys> buysList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Buys.class));
        return buysList;
    }

    @Override
    public List<Buys> selectBuysByPID(String pid) throws Exception {
        String sql = "SELECT * FROM buy WHERE PID=?";
        Object[] params = new Object[] {pid};
        List<Buys> buysList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Buys.class));
        return buysList;
    }

    @Override
    public List<Buys> selectBuysByABID(String abid) throws Exception {
        String sql = "SELECT * FROM buy WHERE ABID=?";
        Object[] params = new Object[] {abid};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Buys.class));
    }

    @Override
    public int[] patchInsertBuys(List<Buys> buysList, String abid) throws Exception {
        String sql = "INSERT INTO buy(PID, ABID, Number, Price, Success) VALUES(?,?,?,?,?)";
        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, buysList.get(i).getPid());
                preparedStatement.setString(2, abid);
                preparedStatement.setInt(3, buysList.get(i).getNumber());
                preparedStatement.setDouble(4, buysList.get(i).getPrice());
                preparedStatement.setString(5, "0");
            }

            @Override
            public int getBatchSize() {
                return buysList.size();
            }
        });
    }

    @Override
    public int[] patchUpdateBuys(List<Buys> buysList) throws Exception {
        String sql = "UPDATE buy SET PID=?, Number=?, Price=?, Success=? WHERE BID=?";
        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, buysList.get(i).getPid());
                preparedStatement.setInt(2, buysList.get(i).getNumber());
                preparedStatement.setDouble(3, buysList.get(i).getPrice());
                preparedStatement.setString(4, String.valueOf(buysList.get(i).getSuccess()));
                preparedStatement.setString(5, buysList.get(i).getBid());
            }

            @Override
            public int getBatchSize() {
                return buysList.size();
            }
        });
    }

    @Override
    public int[] patchDeleteBuys(List<Buys> buysList) throws Exception {
        String sql = "DELETE FROM buy WHERE BID=?";
        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, buysList.get(i).getBid());
            }

            @Override
            public int getBatchSize() {
                return buysList.size();
            }
        });
    }
}
