package impl;

import dao.ExpressesDAO;
import generalClass.Expresses;
import generalClass.InExpress;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExpressesDAOImpl implements ExpressesDAO {

    private JdbcTemplate jdbcTemplate = null;

    public ExpressesDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertExpresses(Expresses expresses) {
        String sql = "INSERT INTO express(EDID, EID, OID, ED, Number, Date, Name, Address, Phone, Deliver, Success) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = dateFormat.format(new Date());
        String edid = expresses.getOid()+datetime.replace(":", "").replace("-", "").replace(" ", "");
        Object[] params = new Object[]{
                edid,
                expresses.getEid(),
                expresses.getEd(),
                expresses.getNumber(),
                datetime,
                expresses.getName(),
                expresses.getAddress(),
                expresses.getPhone(),
                expresses.getDeliver(),
                String.valueOf(0)
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }



    @Override
    public boolean updateExpresses(Expresses expresses) {
        String sql = "UPDATE express SET Name=?, Address=?, Phone=?, Deliver=?, Success=? WHERE EID=?";
        Object[] params = new Object[]{
                expresses.getName(),
                expresses.getAddress(),
                expresses.getPhone(),
                expresses.getDeliver(),
                String.valueOf(1),
                expresses.getEd()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<Expresses> selectExpressesByName(String name) {
        String sql = "SELECT * FROM express WHERE Name=?";
        Object[] params = new Object[] {name};
        List<Expresses> expressesList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Expresses.class));
        return expressesList;
    }

    @Override
    public List<Expresses> selectExpressesByDeliver(String deliver) {
        String sql = "SELECT * FROM express WHERE Deliver=?";
        Object[] params = new Object[] {deliver};
        List<Expresses> expressesList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Expresses.class));
        return expressesList;
    }

    @Override
    public List<Expresses> selectExpressesBySuccess(char success) {
        String sql = "SELECT * FROM express WHERE Success=?";
        Object[] params = new Object[] {String.valueOf(success)};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Expresses.class));

    }

    @Override
    public Expresses selectExpressesByOID(String oid) {
        String sql = "SELECT * FROM express WHERE OID=?";
        Object[] params = new Object[] {oid};
        Expresses expresses;
        try {
            expresses = this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Expresses.class));
        } catch (Exception e) {
            e.printStackTrace();
            expresses = null;
        }
        return expresses;
    }

    @Override
    public Expresses selectExpressesByEDID(String edid) {
        String sql = "SELECT * FROM express WHERE EDID=?";
        Object[] params = new Object[] {edid};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Expresses.class));
    }

    @Override
    public List<Expresses> getExpressedList() {
        String sql = "SELECT * FROM express";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Expresses.class));
    }

    @Override
    public String insertExpressByInExpress(InExpress inExpress, String ed, String deliver, String name, String Phone) {
        String sql = "INSERT Express(EDID, EID, OID, ED, Number, Date, Name, Address, Phone, Deliver, Success) values(?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(inExpress.getDate());
        String edid = date.replace(":", "").replace("-", "").replace(" ", "") + ed.substring(ed.length()-4);
        Object[] params = new Object[] {
                edid,
                inExpress.getEid(),
                inExpress.getOid(),
                ed,
                inExpress.getNumber(),
                date,
                name,
                inExpress.getAddress(),
                Phone,
                deliver,
                String.valueOf(1)
        };
        this.jdbcTemplate.update(sql, params);
        return edid;

    }

    @Override
    public int[] patchInsertExpress(List<Expresses> expressesList) {
        String sql = "INSERT Express(EDID, EID, OID, ED, Number, Date, Name, Address, Phone, Deliver, Success) values(?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        String dateString = date.replace(":", "").replace("-", "").replace(" ", "");
        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                String ed = expressesList.get(i).getEd();
                String edid = dateString + ed.substring(ed.length()-4)+ i;
                preparedStatement.setString(1, edid);
                preparedStatement.setString(2, expressesList.get(i).getEid());
                preparedStatement.setString(3, expressesList.get(i).getOid());
                preparedStatement.setString(4, ed);
                preparedStatement.setInt(5, expressesList.get(i).getNumber());
                preparedStatement.setString(6, date);
                preparedStatement.setString(7, expressesList.get(i).getName());
                preparedStatement.setString(8, expressesList.get(i).getAddress());
                preparedStatement.setString(9, expressesList.get(i).getPhone());
                preparedStatement.setString(10, expressesList.get(i).getDeliver());
                preparedStatement.setString(11, "1");
            }

            @Override
            public int getBatchSize() {
                return expressesList.size();
            }
        });

    }
}
