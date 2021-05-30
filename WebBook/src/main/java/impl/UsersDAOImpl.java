package impl;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
import com.mysql.jdbc.Statement;
import dao.UsersDAO;
import generalClass.Users;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
//import org.springframework.jdbc.core.RowMapper;

public class UsersDAOImpl implements UsersDAO {
//	private PreparedStatement ps = null;// 定义数据库操作对象
	private JdbcTemplate jdbcTemplate = null;

	public UsersDAOImpl(JdbcTemplate jdbcTemplate) {// 设置数据库连接
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	@Override
	/*
	 * 通过会员账号查询用户
	 */
//	public Users selectUsersByAccount(String uid) throws Exception {
//		// TODO Auto-generated method stub
//		Users users = null;//声明Users对象
//		String sql = "SELECT * FROM user WHERE UID=?";
//		this.ps = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
//		this.ps.setString(1, uid);//设置会员账号
//		ResultSet rs = this.ps.executeQuery();//执行查询操作
//		if(rs.next()){
//			users = new Users();//实例化Users对象
//			users.setUid(rs.getString(1));
//			users.setUpassw(rs.getString(2));
//			users.setUname(rs.getString(3));
//			users.setSex(rs.getString(4).charAt(0));
//			users.setAddr(rs.getString(5));
//			users.setEmail(rs.getString(6));
//			users.setPhone(rs.getString(7));
//			users.setPhone(rs.getString(8));
//			users.setCredit(rs.getInt(9));
//			users.setWallet(rs.getInt(10));
//			users.setHistory(rs.getString(11));
//			users.setAge(rs.getInt(12));
//
//		}
//		this.ps.close();//关闭PreparedStatement操作
//		return users;//如果查询不到结果则返回null
//	}


//	@Override
	/*
	 * 查询所有会员
	 */
//	public List<Users> selectUsers() throws Exception {
//		List<Users> list = new ArrayList<Users>();//定义集合
//		String sql = "SELECT * FROM user";//实例化PreparedStatement对象
//		this.ps = this.conn.prepareStatement(sql);
//		ResultSet rs = this.ps.executeQuery();//执行查询操作
//		Users users = null;//声明Users对象
//		while(rs.next()){//依次取出全部数据
//			users = new Users();
//			users.setUid(rs.getString(1));
//			users.setUpassw(rs.getString(2));
//			users.setUname(rs.getString(3));
//			users.setSex(rs.getString(4).charAt(0));
//			users.setAddr(rs.getString(5));
//			users.setEmail(rs.getString(6));
//			users.setPhone(rs.getString(7));
//			users.setPhone(rs.getString(8));
//			users.setCredit(rs.getInt(9));
//			users.setWallet(rs.getInt(10));
//			users.setHistory(rs.getString(11));
//			users.setAge(rs.getInt(12));
//			list.add(users);
//		}
//		this.ps.close();//关闭PreparedStatement操作
//		return list;//返回集合
//    }


	@Override
	/*
	 * 增加会员
	 */
	public String insertUsers(Users users) throws Exception {
		boolean flag = false;
//		String sql = "INSERT INTO user VALUES(replace(uuid(), '-', ''),?,?,?,?,?,?,?,?,?,?)";
//		String sql = "INSERT INTO user(Password, Name, Sex, Address, Email, Phone, Credit, Wallet, Age, Access) values(?,?,?,?,?,?,?,?,?,?)";
//		KeyHolder keyHolder = new GeneratedKeyHolder();
		//this.ps = this.conn.prepareStatement(sql);//实例化PreparedStatement对象			
//		this.ps.setString(1,users.getUid());
//		this.ps.setString(2,users.getUpassw());
//		this.ps.setString(3,users.getUname());
//		this.ps.setString(4,String.valueOf(users.getSex()));
//		this.ps.setString(5,users.getAddr());
//		this.ps.setString(6,users.getEmail());
//		this.ps.setString(7,users.getPhone());
//		this.ps.setString(8,String.valueOf(users.getCredit()));
//		this.ps.setString(9,String.valueOf(users.getWallet()));
//		this.ps.setString(10,users.getHistory());
//		this.ps.setString(11, String.valueOf(users.getAge()));
//		if(this.ps.executeUpdate()>0){//执行插入操作
//			flag = true;//插入成功则将标识符变为true
//		}
//		this.ps.close();//关闭PreparedStatement操作
//		return flag;//返回标识符
//		Object[] params=new Object[]{
////				users.getUid(),
//				users.getUpassw(),
//				users.getUname(),
//				String.valueOf(users.getSex()),
//				users.getAddr(),
//				users.getEmail(),
//				users.getPhone(),
//				100,
//				users.getWallet(),
//				users.getAge()
//		};
//		System.out.println(users.getSex());
//		flag = this.jdbcTemplate.update(conn -> {
//			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ps.setString(1,users.getPassword());
//			ps.setString(2,users.getName());
//			ps.setString(3,String.valueOf(users.getSex()));
//			ps.setString(4,users.getAddress());
//			ps.setString(5, users.getEmail());
//			ps.setString(6, users.getPhone());
//			ps.setInt(7, 100);
//			ps.setDouble(8, users.getWallet());
//			ps.setInt(9, users.getAge());
//			ps.setString(10, String.valueOf(1));
//			return ps;
//		}, keyHolder) >= 1;
//		if (!flag)
//			throw new Exception();
//		return String.valueOf(keyHolder.getKey());
//		return this.jdbcTemplate.update(sql, params) >= 1;
		PasswordEncode passwordEncode = new PasswordEncode();
		passwordEncode.setKey(9);
		String sql = "INSERT INTO user(UID, Password, Name, Sex, Address, Email, Phone, Credit, Wallet, Age, Access) values(?,?,?,?,?,?,?,?,?,?,?)";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Random random = new Random();
		String uid = String.valueOf(random.nextInt(10));
		String dateTime = dateFormat.format(new Date());
		uid += dateTime.replace(":", "").replace("-", "").replace(" ", "");
		String finalUid = uid;
		flag = this.jdbcTemplate.update(conn -> {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, finalUid);
			ps.setString(2, passwordEncode.encode(users.getPassword()));
			ps.setString(3, users.getName());
			ps.setString(4, String.valueOf(users.getSex()));
			ps.setString(5, users.getAddress());
			ps.setString(6, users.getEmail());
			ps.setString(7, users.getPhone());
			ps.setInt(8, 100);
			ps.setDouble(9, users.getWallet());
			ps.setInt(10, users.getAge());
			ps.setString(11, String.valueOf('1'));
			return ps;
		}) >= 1;
		if (!flag) {
			throw new Exception();
		}
		return finalUid;

	}


//	@Override
//	/*
//	 * 删除会员
//	 */
//	public boolean deleteUsersByAccount(String uid) throws Exception {
//		// TODO Auto-generated method stub
//		boolean flag = false;
//		String sql = "DELETE FROM user WHERE UID=?";
//		this.ps = this.conn.prepareStatement(sql);
//		this.ps.setString(1, uid);
//		if(this.ps.executeUpdate()>0){//数据库发生更新
//			flag = true;
//		}
//		this.ps.close();
//		return flag;
//	}

	@Override
	/*
	 * 修改会员信息
	 */
	public boolean updateUsers(Users users) throws Exception {
		String sql = "UPDATE user SET Password=?,Name=?,Sex=?,Address=?,Email=?,Phone=?,Credit=?,Wallet=?,Age=? WHERE UID=?";
//		this.ps = this.conn.prepareStatement(sql);//实例化PreparedStatement对象	
//		this.ps.setString(1,users.getUpassw());
//		this.ps.setString(2,users.getUname());
//		this.ps.setString(3,String.valueOf(users.getSex()));
//		this.ps.setString(4,users.getAddr());
//		this.ps.setString(5,users.getEmail());
//		this.ps.setString(6,users.getPhone());
//		this.ps.setString(7,String.valueOf(users.getCredit()));
//		this.ps.setString(8,String.valueOf(users.getWallet()));
//		this.ps.setString(9,users.getHistory());
//		this.ps.setString(10, String.valueOf(users.getAge()));
//		if(this.ps.executeUpdate()>0){//执行插入操作
//			flag = true;//插入成功则将标识符变为true
//		}
//		this.ps.close();//关闭PreparedStatement操作
//		return flag;//返回标识符
		PasswordEncode passwordEncode = new PasswordEncode();
		passwordEncode.setKey(9);
		Object[] params=new Object[]{
				passwordEncode.encode(users.getPassword()),
				users.getName(),
				String.valueOf(users.getSex()),
				users.getAddress(),
				users.getEmail(),
				String.valueOf(users.getPhone()),
				String.valueOf(users.getCredit()),
				String.valueOf(users.getWallet()),
				String.valueOf(users.getAge()),
				users.getUid()
		};
		return this.jdbcTemplate.update(sql, params) >= 1;
	}

	@Override
	/*
	 * 通过会员账号查询用户
	 */
	public Users selectUsersByPassword(String uid, String upassw)throws Exception {
		// TODO Auto-generated method stub
//		Users users = null;//声明Users对象
//		String sql = "SELECT * FROM user WHERE UID=? and Password=?";
		String sql = "SELECT * FROM user WHERE Email=? and Password=? and Access=?";
//		this.ps = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
//		this.ps.setString(1, uid);//设置会员账号
//		this.ps.setString(2, upassw);//设置会员账号
//		ResultSet rs = this.ps.executeQuery();//执行查询操作
//		if(rs.next()){
//			users = new Users();//实例化Users对象
//			users.setUid(rs.getString(1));
//			users.setUpassw(rs.getString(2));
//			users.setUname(rs.getString(3));
//			users.setSex(rs.getString(4).charAt(0));
//			users.setAddr(rs.getString(5));
//			users.setEmail(rs.getString(6));
//			users.setPhone(rs.getString(7));
//			users.setPhone(rs.getString(8));
//			users.setCredit(rs.getInt(9));
//			users.setWallet(rs.getInt(10));
//			users.setHistory(rs.getString(11));
//			users.setAge(rs.getInt(12));
//
//		}
//		this.ps.close();//关闭PreparedStatement操作
//		return users;//如果查询不到结果则返回null
		PasswordEncode passwordEncode = new PasswordEncode();
		passwordEncode.setKey(9);
		Object[] params =new Object[] {uid, passwordEncode.encode(upassw), "1"};
//		Object[] params =new Object[] {uid, upassw, "1"};
		Users users = this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Users.class));
		users.setPassword(passwordEncode.decode(users.getPassword()));
		return users;
		
	}

	@Override
	public boolean checkUsers(String email) {
		String sql = "SELECT * FROM user WHERE Email=? and Access=?";
		Object[] params = new Object[] {email, "1"};
		try {
			this.jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Users.class));
		} catch (Exception e) {
//			e.printStackTrace();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeUsers(String uid) throws Exception {
//		String sql = "DELETE * FROM user WHERE UID=?";
//		Object[] params = new Object[] {uid};
//		return this.jdbcTemplate.update(sql, params)>=1;
		String sql = "UPDATE user SET Access=? WHERE UID=?";
		Object[] params = new Object[] {"0", uid};
		return this.jdbcTemplate.update(sql, params)>=1;
	}

	@Override
	public String getNameByUID(String uid) throws Exception {
		String sql = "SELECT Name FROM user WHERE UID=?";
		Object[] params = new Object[] {uid};
		return this.jdbcTemplate.queryForObject(sql, params, String.class);
	}

}
