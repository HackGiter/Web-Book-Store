package generalClass;

public class Orders {
	private String oid;
	private String pid;
	private String aid;
	private String name;
	private char type;
	private double price;
	private int number;
	private char success;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
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
	public char getSuccess() {
		return success;
	}
	public void setSuccess(char success) {
		this.success = success;
	}


	@Override
	public String toString() {
		return "Orders{" +
				"oid='" + oid + '\'' +
				", pid='" + pid + '\'' +
				", aid='" + aid + '\'' +
				", name='" + name + '\'' +
				", type=" + type +
				", price=" + price +
				", number=" + number +
				", success=" + success +
				'}';
	}
}
