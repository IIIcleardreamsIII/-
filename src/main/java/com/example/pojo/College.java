package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class College {
    private int collegeId;     // 院校编号
    private String collegeName; // 院校名称

    private String collegeAddress;     // 院校地址

    // Getters and Setters

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", address='" + collegeAddress + '\'' +
                '}';
    }
}
