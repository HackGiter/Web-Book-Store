package generalClass;

import java.util.Date;

public class AllOrders {
	private String aid;
	private String uid;
	private Date date;
	private String address;
	private String phone;
	private double pays;
	private int numbers;
	private int anumbers;
	private String name;
	private char success;

	public int getAnumbers() {
		return anumbers;
	}

	public void setAnumbers(int anumbers) {
		this.anumbers = anumbers;
	}

	public char getSuccess() {
		return success;
	}

	public void setSuccess(char success) {
		this.success = success;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getPays() {
		return pays;
	}

	public void setPays(double pays) {
		this.pays = pays;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AllOrders{" +
				"aid='" + aid + '\'' +
				", uid='" + uid + '\'' +
				", date=" + date +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", pays=" + pays +
				", numbers=" + numbers +
				", anumbers=" + anumbers +
				", name='" + name + '\'' +
				", success=" + success +
				'}';
	}
}
