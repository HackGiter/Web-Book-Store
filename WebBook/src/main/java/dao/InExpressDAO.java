package dao;

import generalClass.InExpress;
import generalClass.Orders;

import java.util.List;

public interface InExpressDAO {

//    int[] patchInsertExpress(String eid, List<Orders> ordersList, List<String> said, List<String> addr, String mid);

    int[] patchInsertExpress(List<InExpress> inExpressList);

    List<InExpress> getExpress(String eid);

    InExpress insertInExpress(String eid, Orders orders, String said, String addr, String eaddr, String mid);

}
