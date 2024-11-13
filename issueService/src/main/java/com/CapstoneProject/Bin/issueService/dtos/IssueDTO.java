package com.CapstoneProject.Bin.issueService.dtos;

import com.CapstoneProject.Bin.issueService.entity.IssueStatus;

import java.time.LocalDateTime;

public class IssueDTO {
    String description;
    String username;
    Long binId;

    public IssueDTO(String description, String username, Long binId) {
        this.description = description;
        this.username = username;
        this.binId = binId;
    }

    public IssueDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getBinId() {
        return binId;
    }

    public void setBinId(Long binId) {
        this.binId = binId;
    }
}
