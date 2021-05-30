package generalClass;

public class Books {
	private String bid;
	private String author;
	private String name;
	private String sid;
	private char category;
	private String category_name;
	private int age;
	private String country;
	private String bdid;
	private double score;
	private char access;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getBdid() {
		return bdid;
	}

	public void setBdid(String bdid) {
		this.bdid = bdid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
		this.category = category;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public char getAccess() {
		return access;
	}

	public void setAccess(char access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "Books{" +
				"bid='" + bid + '\'' +
				", author='" + author + '\'' +
				", name='" + name + '\'' +
				", sid='" + sid + '\'' +
				", category=" + category +
				", category_name='" + category_name + '\'' +
				", age=" + age +
				", country='" + country + '\'' +
				", bdid='" + bdid + '\'' +
				", score=" + score +
				", access=" + access +
				'}';
	}
}
