package impl;

import dao.StorageInfoDAO;
import generalClass.StorageInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageInfoDAOImpl implements StorageInfoDAO {

    private JdbcTemplate jdbcTemplate = null;

    public StorageInfoDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> countStorages() {
        String sql = "SELECT SAID FROM storageinfo";
        List<String> stringList;
        try {
            stringList = this.jdbcTemplate.query(sql, new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getString(1);
                }
            });
        } catch (Exception e) {
            stringList = new ArrayList<>();
            e.printStackTrace();
        }
        return stringList;
    }

    @Override
    public int insertStorageInfo(StorageInfo storageInfo) {
        String sql = "INSERT storageinfo(Address, Contains, Size, Width, Height, Length) VALUES(?,?,?,?,?,?)";
        Object[] params = new Object[] {
            storageInfo.getAddress(),
            storageInfo.getContains(),
            storageInfo.getSize(),
            storageInfo.getWidth(),
            storageInfo.getHeight(),
            storageInfo.getLength()
        };
        int success = 0;
        try {
            success = this.jdbcTemplate.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
            success = -1;
        }
        return success;

    }

    @Override
    public StorageInfo getStorageInfo(String said) {
        String sql = "SELECT * FROM storageinfo WHERE SAID=?";
        StorageInfo storageInfo = null;
        try {
            Object[] params = new Object[] {said};
            storageInfo = this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(StorageInfo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storageInfo;
    }

    @Override
    public List<StorageInfo> getStorageInfoList() {
        String sql = "SELECT * FROM storageinfo";
        List<StorageInfo> storageInfoList = null;
        try {
            storageInfoList = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StorageInfo.class));
        } catch (Exception e) {
            storageInfoList = new ArrayList<>();
            e.printStackTrace();
        }
        return storageInfoList;
    }
}
