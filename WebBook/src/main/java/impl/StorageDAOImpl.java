package impl;

import dao.StorageDAO;
import generalClass.Storages;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StorageDAOImpl implements StorageDAO {

    private JdbcTemplate jdbcTemplate = null;

    public StorageDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertStorages(Storages storages) throws Exception {
        String sql = "INSERT INTO storage VALUES(replace(uuid(), '-', ''),?,?,?,?,?)";
        Object[] params = new Object[]{
                storages.getPid(),
                storages.getArid(),
                storages.getNumber(),
                String.valueOf(0)
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public boolean updateStorages(String arid) throws Exception {
        String sql = "UPDATE storage SET Success=? WHERE ARID=?";
        Object[] params = new Object[]{
                String.valueOf(1),
                arid
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public List<Storages> selectStoragesByPID(String pid) throws Exception {
        String sql = "SELECT * FROM storage WHERE Success=?";
        Object[] params = new Object[] {pid};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Storages.class));

    }

    @Override
    public List<Storages> selectStoragesByARID(String arid) throws Exception {
        String sql = "SELECT * FROM storage WHERE ARID=?";
        Object[] params = new Object[] {arid};
        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Storages.class));

    }

    @Override
    public List<Storages> getStoragesList() throws Exception {
        String sql = "SELECT * FROM storage";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Storages.class));
    }

    @Override
    public Storages getStorages(String bid) throws Exception {
        String sql = "SELECT * FROM storage WHERE BID=?";
        Object[] params = new Object[] {bid};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Storages.class));
    }

    @Override
    public int[] patchInsertStorages(List<Storages> storagesList) throws Exception {
        String sql = "INSERT storage(BID, PID, ARID, Number, SAID, Address, MID, Date, Success) VALUES(?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = dateFormat.format(new Date());
        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, storagesList.get(i).getBid());
                preparedStatement.setString(2, storagesList.get(i).getPid());
                preparedStatement.setString(3, storagesList.get(i).getArid());
                preparedStatement.setInt(4, storagesList.get(i).getNumber());
                preparedStatement.setString(5, storagesList.get(i).getSaid());
                preparedStatement.setString(6, storagesList.get(i).getAddress());
                preparedStatement.setString(7, storagesList.get(i).getMid());
                preparedStatement.setString(8, datetime);
                preparedStatement.setString(9, String.valueOf(storagesList.get(i).getSuccess()));
            }

            @Override
            public int getBatchSize() {
                return storagesList.size();
            }
        });
    }


}
