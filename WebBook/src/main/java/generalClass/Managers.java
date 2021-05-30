package generalClass;

import java.util.Date;

public class Managers {
	
	private String mid;
	private String did;
	private String password;
	private String name;
	private char level;
	private String position;
	private String phone;
	private String email;
	private double wages;
	private int age;
	private String department;
	private char sex;
	private Date date;

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
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
	public void setName(String name) {
		this.name = name;
	}
	public char getLevel() {
		return level;
	}
	public void setLevel(char level) {
		this.level = level;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	public double getWages() {
		return wages;
	}
	public void setWages(int wages) {
		this.wages = wages;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void setWages(double wages) {
		this.wages = wages;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Managers{" +
				"mid='" + mid + '\'' +
				", did='" + did + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", level=" + level +
				", position='" + position + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", wages=" + wages +
				", age=" + age +
				", department='" + department + '\'' +
				", sex=" + sex +
				", date=" + date +
				'}';
	}
}
