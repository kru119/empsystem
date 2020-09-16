package net.togogo.bean;

import java.util.Date;

public class Emp {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private String phone;
    private String idcard;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }

    public Emp() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Emp(Integer id, String name, Integer age, String gender, Date birthday, String phone, String idcard) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.idcard = idcard;
    }
}
