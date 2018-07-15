package deepin.com.greendaodemo1.data;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String username;
    private int age;
    private boolean sex;
    private String address;
    @Keep
    @Generated(hash = 673726861)
    public User(Long id, @NotNull String username, int age, boolean sex,
            String address) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }
    @Keep
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getSex() {
        return this.sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void print(){
        Log.i("leeTest------>", "id = " + id + ", userName = " + username);
    }
}
