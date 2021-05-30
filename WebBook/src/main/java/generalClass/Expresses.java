package generalClass;

import java.util.Date;

public class Expresses {
	private String edid;
	private String eid;
	private String ed;
	private int Number;
	private Date date;
	private String name;
	private String oid;
	private String address;
	private String phone;
	private String deliver;
	private char success;

	public String getEdid() {
		return edid;
	}

	public void setEdid(String edid) {
		this.edid = edid;
	}

	public String getEd() {
		return ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public char getSuccess() {
		return success;
	}

	public void setSuccess(char success) {
		this.success = success;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "Expresses{" +
				"edid='" + edid + '\'' +
				", eid='" + eid + '\'' +
				", ed='" + ed + '\'' +
				", Number=" + Number +
				", date=" + date +
				", name='" + name + '\'' +
				", oid='" + oid + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", deliver='" + deliver + '\'' +
				", success=" + success +
				'}';
	}
}
