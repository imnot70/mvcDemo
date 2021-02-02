package demo.beans;

import java.util.List;

/**
 * @author imnot
 */
public class ProjectVO {
    private List<Project> project_basic_list;

    private Integer total_count;

    public List<Project> getProject_basic_list() {
        return project_basic_list;
    }

    public void setProject_basic_list(List<Project> project_basic_list) {
        this.project_basic_list = project_basic_list;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }
}
