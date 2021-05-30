package generalClass;

import java.util.Date;

public class Buys {
	private String bid;
	private String pid;
	private String abid;
	private int number;
	private double price;
	private char success;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getAbid() {
		return abid;
	}

	public void setAbid(String abid) {
		this.abid = abid;
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

	public char getSuccess() {
		return success;
	}

	public void setSuccess(char success) {
		this.success = success;
	}



	@Override
	public String toString() {
		return "Buys{" +
				"bid='" + bid + '\'' +
				", pid='" + pid + '\'' +
				", abid='" + abid + '\'' +
				", number=" + number +
				", price=" + price +
				", success=" + success +
				'}';
	}
}
