package dao;

import generalClass.Orders;

import java.util.List;

public interface OrdersDAO {
    public boolean insertOrders(Orders orders) ;

    public boolean updateOrders(String aid) ;

    public List<Orders> selectOrdersByPID(String pid) ;

    public List<Orders> selectOrdersByAID(String oid) ;

    int[] batchInsertOrders(List<Orders> ordersList) ;

    Orders selectOrdersByOID(String oid) ;
}
