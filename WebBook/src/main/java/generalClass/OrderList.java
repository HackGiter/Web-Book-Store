package generalClass;

import java.util.List;

public class OrderList {
    private AllOrders allOrders;
    private List<Orders> ordersList;

    public AllOrders getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(AllOrders allOrders) {
        this.allOrders = allOrders;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "allOrders=" + allOrders +
                ", ordersList=" + ordersList +
                '}';
    }
}
