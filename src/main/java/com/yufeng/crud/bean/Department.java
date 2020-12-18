
package com.yufeng.crud.bean;
  /**
  *每天进步一点点鸭！ 
  *@Param: 
  *@Author: lyf
  *@date : 2020/12/15 16:24
  */
public class Department {
    private Integer deptId;

    private String deptName;

    public Department() {
    }

    public Department(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}