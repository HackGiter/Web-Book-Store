package impl;

import dao.AllBuysDAO;
import generalClass.AllBuys;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AllBuysDAOImpl implements AllBuysDAO {

    private JdbcTemplate jdbcTemplate = null;

    public AllBuysDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String insertAllBuys(AllBuys allBuys) throws Exception {
//        String sql = "INSERT INTO allbuys VALUES(replace(uuid(), '-', ''),?,?,?,?,?,?,?)";
        String sql = "INSERT INTO allbuys(ABID,Date,Number,Anumber,Price,Provider,Phone,Email,MID,Success) VALUES(?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = dateFormat.format(new Date());
        String abid = "CGD" + allBuys.getMid() + datetime.replace(":", "").replace("-", "").replace(" ", "");
        Object[] params = new Object[]{
                abid,
                datetime,
                allBuys.getNumber(),
                allBuys.getAnumber(),
                allBuys.getPrice(),
                allBuys.getProvider(),
                allBuys.getPhone(),
                allBuys.getEmail(),
                allBuys.getMid(),
                String.valueOf(0),
        };

        if (this.jdbcTemplate.update(sql, params) >= 1) {
            return abid;
        }
        throw new Exception();
    }

    @Override
    public boolean updateAllBuys(AllBuys allBuys) throws Exception {
        String sql = "UPDATE allbuys SET Number=?, Anumber=?, Price=?, Provider=?, Phone=?, Email=?, Success=? WHERE ABID=?";
        Object[] params = new Object[]{
                allBuys.getNumber(),
                allBuys.getAnumber(),
                allBuys.getPrice(),
                allBuys.getProvider(),
                allBuys.getPhone(),
                allBuys.getEmail(),
                String.valueOf(allBuys.getSuccess()),
                allBuys.getAbid()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<AllBuys> selectAllBuysByProvider(String provider) throws Exception {
        String sql = "SELECT * FROM allbuys WHERE Provider=?";
        Object[] params = new Object[] {provider};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AllBuys.class));

    }

    @Override
    public List<AllBuys> selectAllBuysBySuccess(char success) throws Exception {
        String sql = "SELECT * FROM allbuys WHERE Success=?";
        Object[] params = new Object[] {String.valueOf(success)};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AllBuys.class));

    }

    @Override
    public AllBuys selectAllBuysByABID(String abid) throws Exception {
        String sql = "SELECT * FROM allbuys WHERE ABID=?";
        Object[] params = new Object[] {abid};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(AllBuys.class));
    }

    @Override
    public List<AllBuys> getAllBuysList() throws Exception {
        String sql = "SELECT * FROM allbuys";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AllBuys.class));
    }

    @Override
    public boolean updateOneAllBuys(String abid) throws Exception {
        String sql = "UPDATE allbuys SET Success=? WHERE ABID=?";
        Object[] params = new Object[]{ String.valueOf(1),abid};
        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public boolean deleteAllBuys(String abid) throws Exception {
        String sql = "DELETE FROM allbuys WHERE ABID=?";
        Object[] params = new Object[] {
                abid,
        };
        return this.jdbcTemplate.update(sql, params) >= 1;

    }

    @Override
    public List<AllBuys> searchAllBuys(AllBuys allBuys) throws Exception {
        String sql = "SELECT * FROM allbuys WHERE ABID LIKE CONCAT('%',?,'%') AND Date >= ? AND Number>=? AND Anumber>=? AND Price>=? AND Provider LIKE CONCAT('%',?,'%') AND Success LIKE CONCAT('%',?,'%')";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(allBuys);
        Object[] objects = new Object[] {
                allBuys.getAbid(),
                dateFormat.format(allBuys.getDate()),
                allBuys.getNumber(),
                allBuys.getAnumber(),
                allBuys.getPrice(),
                allBuys.getProvider(),
                String.valueOf(allBuys.getSuccess())
        };
        return this.jdbcTemplate.query(sql, objects, new BeanPropertyRowMapper<>(AllBuys.class));
    }


}
