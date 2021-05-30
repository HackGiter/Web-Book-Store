package dao;

import generalClass.Users;
//import java.util.List;

public interface UsersDAO {
	/*
	 *通过会员账号查询用户
	 */
//	public Users selectUsersByAccount(String uid)throws Exception;
	/*
	 *查询所有会员 
	 */
//	public List<Users> selectUsers()throws Exception;
	/*
	 * 增加会员
	 */
	public String insertUsers(Users users)throws Exception;
	 /*
	  * 删除会员
	  */
//	public boolean deleteUsersByAccount(String uid)throws Exception;
	/*
	 * 修改会员信息
	 */
	public boolean updateUsers(Users users)throws Exception;
	/*
	 * 
	 */
	public Users selectUsersByPassword(String uid, String upassw)throws Exception;

	boolean checkUsers(String email);

	public boolean removeUsers(String uid) throws Exception;

	String getNameByUID(String uid) throws Exception;

}
