package dao;

import generalClass.AllBuys;

import java.util.List;

public interface AllBuysDAO {
    String insertAllBuys(AllBuys allBuys)throws Exception;

    boolean updateAllBuys(AllBuys allBuys)throws Exception;

    List<AllBuys> selectAllBuysByProvider(String provider) throws Exception;

    List<AllBuys> selectAllBuysBySuccess(char success) throws Exception;

    AllBuys selectAllBuysByABID(String abid) throws Exception;

    List<AllBuys> getAllBuysList() throws Exception;

    boolean updateOneAllBuys(String abid) throws Exception;

    boolean deleteAllBuys(String abid) throws Exception;

    List<AllBuys> searchAllBuys(AllBuys allBuys) throws Exception;

}
