package impl;

import java.text.SimpleDateFormat;
import java.util.List;

import generalClass.Managers;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.ManagersDAO;

public class ManagersDAOImpl implements ManagersDAO {
	
	
	private JdbcTemplate jdbcTemplate = null;

	public ManagersDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean insertManagers(Managers managers) throws Exception {
		String sql = "INSERT INTO manager(DID,Password,Name,Level,Department,Position,Email,Phone,Date,Wages,Age,Sex) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Object[] params=new Object[]{
				managers.getDid(),
				managers.getPassword(),
				managers.getName(),
				String.valueOf(managers.getLevel()),
				managers.getDepartment(),
				managers.getPosition(),
				managers.getEmail(),
				managers.getPhone(),
				dateFormat.format(managers.getDate()),
				managers.getWages(),
				managers.getAge(),
				String.valueOf(managers.getSex()),

		};
		return this.jdbcTemplate.update(sql, params) >= 1;
	}

	@Override
	public boolean updateManagers(Managers managers) throws Exception {
		String sql = "UPDATE manager SET Password=?,Name=?,Sex=?,Address=?,Email=?,Phone=?,Credit=?,Wallet=?,History=?,Age=? WHERE UID=?";
		Object[] params=new Object[]{
				managers.getPassword(),
				managers.getName(),
				String.valueOf(managers.getLevel()),
				managers.getPosition(),
				managers.getEmail(),
				managers.getPhone(),
				managers.getWages(),
				managers.getAge(),
				managers.getDid()
		};
		return this.jdbcTemplate.update(sql, params) >= 1;
	}

	@Override
	public Managers selectManagersByPassword(String email, String upassw)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM manager WHERE Email=? and Password=?";
		Object[] params =new Object[] {email, upassw};
		return this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Managers.class));
		
	}

//	@Override
//	public boolean selectAndupdateManager(Managers managers, String name)
//			throws Exception {
//		if (Integer.parseInt(String.valueOf(managers.getLevel())) <= 1) {
//			String department = managers.getDid();
//			String sql = "SELECT * FROM manager WHERE Name=? and DID=?";
//			Object[] params =new Object[] {name, department};
//			List<Managers> cm = this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Managers.class));
//			if (cm.isEmpty()) {
//				return false;
//			} else {
//				for (Managers m: cm) {
//					System.out.println(m);
//				}
//			}
//			return true;
//		} else {
//			return false;
//		}
//
//	}
	
}
