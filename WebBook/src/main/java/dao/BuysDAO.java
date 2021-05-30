package dao;

import generalClass.Buys;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface BuysDAO {
    boolean insertBuys(Buys buys)throws Exception;

    boolean updateBuys(Buys buys)throws Exception;

    List<Buys> selectBuysByBID(String bid) throws Exception;

    List<Buys> selectBuysByPID(String pid) throws Exception;

    List<Buys> selectBuysByABID(String abid) throws Exception;

    int[] patchInsertBuys(List<Buys> buysList, String abid) throws Exception;

    int[] patchUpdateBuys(List<Buys> buysList) throws Exception;

    int[] patchDeleteBuys(List<Buys> buysList) throws Exception;

}
