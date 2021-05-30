package generalClass;

import java.util.Date;

public class Storages {
	private String rid;
	private String bid;
	private String pid;
	private String arid;
	private int number;
	private String address;
	private String mid;
	private Date date;
	private char success;
	private String said;

	public String getSaid() {
		return said;
	}

	public void setSaid(String said) {
		this.said = said;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getArid() {
		return arid;
	}

	public void setArid(String arid) {
		this.arid = arid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Storages{" +
				"rid='" + rid + '\'' +
				", bid='" + bid + '\'' +
				", pid='" + pid + '\'' +
				", arid='" + arid + '\'' +
				", number=" + number +
				", address='" + address + '\'' +
				", mid='" + mid + '\'' +
				", date=" + date +
				", success=" + success +
				", said='" + said + '\'' +
				'}';
	}
}
