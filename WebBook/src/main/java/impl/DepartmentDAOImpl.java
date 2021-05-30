package impl;

import dao.DepartmentDAO;
import generalClass.AllStorages;
import generalClass.Department;
import generalClass.Storages;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    private JdbcTemplate jdbcTemplate = null;

    public DepartmentDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertDepartment(Department department) throws Exception {
        String sql = "INSERT INTO department VALUES(replace(uuid(), '-', ''),?,?,?,?,?)";
        Object[] params = new Object[]{
                department.getName(),
                department.getNumber(),
                department.getManager(),
                department.getEmail(),
                department.getPhone()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public boolean updateDepartment(Department department) throws Exception {
        String sql = "UPDATE department SET Name=?, Number=?, Manager=?, Email=?, Phone=? WHERE DID=?";
        Object[] params = new Object[]{
                department.getName(),
                department.getNumber(),
                department.getManager(),
                department.getEmail(),
                department.getPhone(),
                department.getDid()
        };

        return this.jdbcTemplate.update(sql, params) >= 1;
    }

    @Override
    public Department selectDepartmentByName(String name) throws Exception {
        String sql = "SELECT * FROM department WHERE Name=?";
        Object[] params = new Object[] {name};
        return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Department.class));

    }

    @Override
    public List<Department> selectDepartmentByManager(String manager) throws Exception {
        String sql = "SELECT * FROM department WHERE Manager=?";
        Object[] params = new Object[] {manager};
        List<Department> departmentList = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Department.class));
        return departmentList;
    }
}
