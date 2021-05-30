package dao;

import generalClass.AllExpresses;
import generalClass.AllOrders;

import java.util.List;

public interface AllExpressesDAO {
    boolean insertAllExpresses(AllOrders allOrders, String eid) ;
    List<AllExpresses> getAllExpresses() ;
    AllExpresses selectAllExpressesByAID(String aid) ;
    void updateAllExpress(String aid);
}
