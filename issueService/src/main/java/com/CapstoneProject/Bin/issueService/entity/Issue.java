package com.CapstoneProject.Bin.issueService.entity;


import com.CapstoneProject.Bin.issueService.dtos.BinDTO1;
import com.CapstoneProject.Bin.issueService.dtos.UserDTO;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Issue {
    @Id
    String id;
    String description;
    UserDTO sender;
    BinDTO1 bin;
    IssueStatus status;
    LocalDateTime createdAt;
    LocalDateTime resolvedAt;

    public Issue() {
    }

    public Issue(String id, String description, UserDTO sender, BinDTO1 bin, IssueStatus status, LocalDateTime createdAt, LocalDateTime resolvedAt) {
        this.id = id;
        this.description = description;
        this.sender = sender;
        this.bin = bin;
        this.status = status;
        this.createdAt = createdAt;
        this.resolvedAt = resolvedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    public BinDTO1 getBin() {
        return bin;
    }

    public void setBin(BinDTO1 bin) {
        this.bin = bin;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
}
