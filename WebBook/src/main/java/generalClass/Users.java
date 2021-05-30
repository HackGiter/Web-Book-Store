package generalClass;

public class Users {
	private String uid;
	private String password;
	private String name;
	private String address;
	private String email;
	private String phone;
	private char sex;
	private int age;
	private int credit;
	private double wallet;
	private char access;

	public char getAccess() {
		return access;
	}

	public void setAccess(char access) {
		this.access = access;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String uname) {
		this.name = uname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String addr) {
		this.address = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users{" +
				"uid='" + uid + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", sex=" + sex +
				", age=" + age +
				", credit=" + credit +
				", wallet=" + wallet +
				", access=" + access +
				'}';
	}
}
