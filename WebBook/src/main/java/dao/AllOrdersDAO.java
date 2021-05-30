package dao;

import generalClass.AllOrders;
import generalClass.Users;

import java.util.List;

public interface AllOrdersDAO {
    public boolean insertAllOrders(AllOrders allorders) ;

    public boolean updateAllOrders(String aid) ;

    public List<AllOrders> selectAllOrdersByUID(String uid) ;

    public AllOrders selectAllOrdersByAID(String aid) ;

    List<AllOrders> getAllOrdersList() ;

    String insertOrders(Users users, double Price, int number, int anumber) ;

    List<AllOrders> searchAllOrders(AllOrders allOrders) ;
}
