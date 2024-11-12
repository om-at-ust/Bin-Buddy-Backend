package com.CapstoneProject.Bin.issueService.dtos;

import com.CapstoneProject.Bin.issueService.entity.IssueStatus;

import java.time.LocalDateTime;

public class IssueDTO {
    String description;
    String userName;

    public IssueDTO() {
    }

    public IssueDTO(String description, String userName) {
        this.description = description;
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
