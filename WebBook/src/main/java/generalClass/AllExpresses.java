package generalClass;

import java.util.Date;

public class AllExpresses {
    private String eid;
    private String aid;
    private int number;
    private Date date;
    private char success;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public char getSuccess() {
        return success;
    }

    public void setSuccess(char success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "AllExpresses{" +
                "eid='" + eid + '\'' +
                ", aid='" + aid + '\'' +
                ", number=" + number +
                ", date=" + date +
                ", success=" + success +
                '}';
    }
}
