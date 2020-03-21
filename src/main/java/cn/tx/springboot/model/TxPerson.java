package cn.tx.springboot.model;

import java.util.Date;

public class TxPerson {

    private int pid;
    private String username;
    private String password;
    private String pAddr;
    private String pname;
    private int gender;


    private Date birth;


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getpAddr() {
        return pAddr;
    }

    public void setpAddr(String pAddr) {
        this.pAddr = pAddr;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "TxPerson{" +
                "pid=" + pid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addr='" + pAddr + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                '}';
    }
}
