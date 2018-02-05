package mybatis.mybatis.Model;

import java.util.Date;

/**
 * @program: MybatisTest
 * @description: 用户类
 * @author: Ming
 * @create: 2018-02-05 09:47
 **/
public class User {
    int id;
    String username = null;
    Date birthday = null;
    String sex = null;
    String address = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
