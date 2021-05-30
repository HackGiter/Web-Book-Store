package generalClass;

import java.util.Date;

public class AllBuys {
    private String abid;
    private Date date;
    private int number;
    private double price;
    private String provider;
    private String phone;
    private String email;
    private String mid;
    private int anumber;
    private char success;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSuccess() {
        return success;
    }

    public void setSuccess(char success) {
        this.success = success;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getAnumber() {
        return anumber;
    }

    public void setAnumber(int anumber) {
        this.anumber = anumber;
    }

    @Override
    public String toString() {
        return "AllBuys{" +
                "abid='" + abid + '\'' +
                ", date=" + date +
                ", number=" + number +
                ", price=" + price +
                ", provider='" + provider + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", mid='" + mid + '\'' +
                ", anumber=" + anumber +
                ", success=" + success +
                '}';
    }
}
