package generalClass;

import java.util.List;

public class AllDeliver {
//    private List<String> edList;
//    private List<String> deliverList;
//    private List<String> oidList;
    private List<deliver> deliverList;
    private String aid;

    public List<deliver> getDeliverList() {
        return deliverList;
    }

    public void setDeliverList(List<deliver> deliverList) {
        this.deliverList = deliverList;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "AllDeliver{" +
                "deliverList=" + deliverList +
                ", aid='" + aid + '\'' +
                '}';
    }
}
