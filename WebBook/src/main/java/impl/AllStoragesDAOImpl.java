package impl;

import dao.AllStoragesDAO;
import generalClass.AllOrders;
import generalClass.AllStorages;
import generalClass.AllStorages;
import generalClass.Buys;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.List;

public class AllStoragesDAOImpl implements AllStoragesDAO {

    private JdbcTemplate jdbcTemplate = null;

    public AllStoragesDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String insertAllStorages(AllStorages allStorages) throws Exception {
        String sql = "INSERT INTO allstorages(ARID,ABID,Date,Number,Success) VALUES(?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String arid = "RKD"+allStorages.getNumber() +dateFormat.format(allStorages.getDate()).replace(":", "").replace("-", "").replace(" ", "");
        Object[] params = new Object[]{
                arid,
                allStorages.getAbid(),
                dateFormat.format(allStorages.getDate()),
                allStorages.getNumber(),
                String.valueOf(allStorages.getSuccess())
        };

        if (this.jdbcTemplate.update(sql, params) >= 1) {
            return arid;
        }
        throw new Exception();
    }

    @Override
    public boolean updateAllStorages(String arid) throws Exception {
        String sql = "UPDATE allstorages SET Success=? WHERE ARID=?";
        Object[] params = new Object[]{
                String.valueOf(1),
                arid
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<AllStorages> selectAllStoragesBySuccess(char success) throws Exception {
        String sql = "SELECT * FROM allstorages WHERE Success=?";
        Object[] params = new Object[] {success};
        List<AllStorages> allStoragesList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AllStorages.class));
        return allStoragesList;
    }

    @Override
    public AllStorages selectAllStoragesByARID(String arid) throws Exception {
        String sql = "SELECT * FROM allstorages WHERE ARID=?";
        Object[] params = new Object[] {arid};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(AllStorages.class));

    }

    @Override
    public AllStorages selectAllStoragesByABID(String abid) throws Exception {       
        String sql = "SELECT * FROM allstorages WHERE ABID=?";
        Object[] params = new Object[] {abid};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(AllStorages.class));

    }

    @Override
    public List<AllStorages> getAllStoragesList() throws Exception {
        String sql = "SELECT * FROM allstorages";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AllStorages.class));
    }

    @Override
    public List<AllStorages> searchAllStorages(AllStorages allStorages) {
        String sql = "SELECT * FROM allstorages WHERE ARID LIKE CONCAT('%',?,'%') AND ABID LIKE CONCAT('%',?,'%') AND Date >= ? AND Number >= ? AND Success LIKE CONCAT('%',?,'%')";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Object[] objects = new Object[] {
                allStorages.getArid(),
                allStorages.getAbid(),
                dateFormat.format(allStorages.getDate()),
                allStorages.getNumber(),
                String.valueOf(allStorages.getSuccess()),
        };
        return this.jdbcTemplate.query(sql, objects, new BeanPropertyRowMapper<>(AllStorages.class));
    }
}
