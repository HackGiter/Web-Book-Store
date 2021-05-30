package impl;

public class PasswordEncode {
    private int key;

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String encode(String password) {
        if (key > 9) {
            return "";
        }
        int tmp = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (tmp == 0) {
                result.append((char)(password.charAt(i) + i % key));
                tmp = 1;
            } else {
                result.append((char)(password.charAt(i) - i % key));
                tmp = 0;
            }
        }
        return result.toString();
    }
    public String decode(String password) {
        if (key > 9) {
            return "";
        }
        int tmp = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (tmp == 0) {
                result.append((char)(password.charAt(i) - i % key));
                tmp = 1;
            } else {
                result.append((char)(password.charAt(i) + i % key));
                tmp = 0;
            }
        }
        return result.toString();
    }
}
