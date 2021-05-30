package generalClass;

import java.util.Date;

public class AllStorages {
    private String arid;
    private String abid;
    private Date date;
    private int number;
    private char success;

    public String getArid() {
        return arid;
    }

    public void setArid(String arid) {
        this.arid = arid;
    }

    public String getAbid() {
        return abid;
    }

    public void setAbid(String abid) {
        this.abid = abid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



    public char getSuccess() {
        return success;
    }

    public void setSuccess(char success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "AllStorages{" +
                "arid='" + arid + '\'' +
                ", abid='" + abid + '\'' +
                ", date=" + date +
                ", number=" + number +
                ", success=" + success +
                '}';
    }
}
