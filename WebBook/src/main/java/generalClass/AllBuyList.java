package generalClass;

import java.util.List;

public class AllBuyList {
    private List<Buys> buysList;

    public List<Buys> getBuysList() {
        return buysList;
    }

    public void setBuysList(List<Buys> buysList) {
        this.buysList = buysList;
    }

    @Override
    public String toString() {
        return "AllBuyList{" +
                "buysList=" + buysList +
                '}';
    }
}
