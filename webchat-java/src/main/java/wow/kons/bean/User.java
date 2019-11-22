package wow.kons.bean;

import java.sql.Date;

public class User {
    private int p_id;
    private String p_account;
    private String p_password;
    private String p_name;
    private char p_sex;
    private Date p_birthday;
    private String p_head_file;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_account() {
        return p_account;
    }

    public void setP_account(String p_account) {
        this.p_account = p_account;
    }

    public String getP_password() {
        return p_password;
    }

    public void setP_password(String p_password) {
        this.p_password = p_password;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public char getP_sex() {
        return p_sex;
    }

    public void setP_sex(char p_sex) {
        this.p_sex = p_sex;
    }

    public Date getP_birthday() {
        return p_birthday;
    }

    public void setP_birthday(Date p_birthday) {
        this.p_birthday = p_birthday;
    }

    public String getP_head_file() {
        return p_head_file;
    }

    public void setP_head_file(String p_head_file) {
        this.p_head_file = p_head_file;
    }
}
