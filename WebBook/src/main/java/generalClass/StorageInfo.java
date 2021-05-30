package generalClass;

public class StorageInfo {
    private String said;
    private String address;
    private int contains;
    private int size;
    private int width;
    private int height;
    private int length;

    public int getContains() {
        return contains;
    }

    public void setContains(int contains) {
        this.contains = contains;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

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

    @Override
    public String toString() {
        return "StorageInfo{" +
                "said='" + said + '\'' +
                ", address='" + address + '\'' +
                ", contains=" + contains +
                ", size=" + size +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
