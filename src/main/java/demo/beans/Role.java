package demo.beans;

/**
 * @author imnot
 */
public class Role{
    private Integer Roleid;
    private String Name;
    private String Show_Name;
    private String Remark;
    private Integer Type;

    public Integer getRoleid() {
        return Roleid;
    }

    public void setRoleid(Integer roleid) {
        Roleid = roleid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getShow_Name() {
        return Show_Name;
    }

    public void setShow_Name(String show_Name) {
        Show_Name = show_Name;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }
}