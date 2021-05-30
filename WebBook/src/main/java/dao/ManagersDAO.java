package dao;

import generalClass.Managers;

public interface ManagersDAO {

	/*
	 *通过会员账号查询用户
	 */
//	public Managers selectManagersByAccount(String uid)throws Exception;
	/*
	 *查询所有会员 
	 */
//	public List<Managers> selectManagers()throws Exception;
	/*
	 * 增加会员
	 */
	public boolean insertManagers(Managers managers)throws Exception;
	 /*
	  * 删除会员
	  */
//	public boolean deleteManagersByAccount(String uid)throws Exception;
	/*
	 * 修改会员信息
	 */
	public boolean updateManagers(Managers managers)throws Exception;
	/*
	 * 
	 */
	public Managers selectManagersByPassword(String uid, String upassw)throws Exception;
	
//	public boolean selectAndupdateManager(Managers managers, String name) throws Exception;
}
