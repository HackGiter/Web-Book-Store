package generalClass;

import java.util.Date;

public class InExpress {
    private String oid;
    private String pid;
    private String eid;
    private int number;
    private String address;
    private String eaddr;
    private String said;
    private Date date;
    private String mid;

    public String getSaid() {
        return said;
    }

    public void setSaid(String said) {
        this.said = said;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getEaddr() {
        return eaddr;
    }

    public void setEaddr(String eaddr) {
        this.eaddr = eaddr;
    }

    @Override
    public String toString() {
        return "InExpress{" +
                "oid='" + oid + '\'' +
                ", pid='" + pid + '\'' +
                ", eid='" + eid + '\'' +
                ", number=" + number +
                ", address='" + address + '\'' +
                ", eaddr='" + eaddr + '\'' +
                ", said='" + said + '\'' +
                ", date=" + date +
                ", mid='" + mid + '\'' +
                '}';
    }
}
