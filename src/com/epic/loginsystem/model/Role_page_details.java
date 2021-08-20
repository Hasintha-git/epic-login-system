package com.epic.loginsystem.model;

public class Role_page_details {
    private String roleType;
    private String pageName;


    public Role_page_details() {
    }

    public Role_page_details( String roleType,String pageName) {
        this.pageName = pageName;
        this.roleType = roleType;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "Role_page_details{" +
                "pageName='" + pageName + '\'' +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
