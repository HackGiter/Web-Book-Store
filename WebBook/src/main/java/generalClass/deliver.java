package generalClass;

public class deliver {
    private String ed;
    private String deliver;
    private String oid;

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "deliver{" +
                "ed='" + ed + '\'' +
                ", deliver='" + deliver + '\'' +
                ", oid='" + oid + '\'' +
                '}';
    }
}
