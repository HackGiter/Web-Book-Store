package generalClass;

public class Products {
	private String pid;
	private String bid;
	private String bname;
	private char type;
	private double price;
	private int number;
	private String address;
	private int sale;
	private String PName;
	private String said;

	public String getSaid() {
		return said;
	}

	public void setSaid(String said) {
		this.said = said;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

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
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}

	@Override
	public String toString() {
		return "Products{" +
				"pid='" + pid + '\'' +
				", bid='" + bid + '\'' +
				", bname='" + bname + '\'' +
				", type=" + type +
				", price=" + price +
				", number=" + number +
				", address='" + address + '\'' +
				", sale=" + sale +
				", PName='" + PName + '\'' +
				", said='" + said + '\'' +
				'}';
	}
}
