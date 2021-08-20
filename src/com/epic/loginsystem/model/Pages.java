package com.epic.loginsystem.model;

public class Pages {
    private String pageName;
    private String des;

    public Pages() {
    }

    public Pages(String pageName, String des) {
        this.pageName = pageName;
        this.des = des;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String email) {
        this.pageName = email;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "pageName='" + pageName + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
