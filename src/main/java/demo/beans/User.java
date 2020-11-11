package demo.beans;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("user")
public class User extends BasicBean{
    private String name;
    private int age;
    private double salary;

    private Integer UserId;
    private String LoginName;
    private String Truename;
    private String NickName;
    private String LoginPwd;
    private String QQ;
    private String Phone;
    private String Email;
    private String Remark;
    private String Account_Non_Locked;
    private String Telelephone;
    private String Indate;
    private Integer IsDelete;
    private List<Role> RoleList;

    public User() {
    }

    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public User(String name, int age, double salary, Integer userId, String loginName, String truename, String nickName, String loginPwd, String QQ, String phone, String email, String remark, String account_Non_Locked, String telelephone, String indate, Integer isDelete, List<Role> roleList) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        UserId = userId;
        LoginName = loginName;
        Truename = truename;
        NickName = nickName;
        LoginPwd = loginPwd;
        this.QQ = QQ;
        Phone = phone;
        Email = email;
        Remark = remark;
        Account_Non_Locked = account_Non_Locked;
        Telelephone = telelephone;
        Indate = indate;
        IsDelete = isDelete;
        RoleList = roleList;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public User setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getTruename() {
        return Truename;
    }

    public void setTruename(String truename) {
        Truename = truename;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getLoginPwd() {
        return LoginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        LoginPwd = loginPwd;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getAccount_Non_Locked() {
        return Account_Non_Locked;
    }

    public void setAccount_Non_Locked(String account_Non_Locked) {
        Account_Non_Locked = account_Non_Locked;
    }

    public String getTelelephone() {
        return Telelephone;
    }

    public void setTelelephone(String telelephone) {
        Telelephone = telelephone;
    }

    public String getIndate() {
        return Indate;
    }

    public void setIndate(String indate) {
        Indate = indate;
    }

    public Integer getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Integer isDelete) {
        IsDelete = isDelete;
    }

    public List<Role> getRoleList() {
        return RoleList;
    }

    public void setRoleList(List<Role> roleList) {
        RoleList = roleList;
    }
}
