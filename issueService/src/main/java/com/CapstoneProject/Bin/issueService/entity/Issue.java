package com.CapstoneProject.Bin.issueService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Issue {
    @Id
    String id;
    String description;
    String username;
    Long binId;
    IssueStatus status;
    LocalDateTime createdAt;
    LocalDateTime resolvedAt;

    public Issue() {
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

    public Issue(String id, String description, String username, Long binId, IssueStatus status, LocalDateTime createdAt, LocalDateTime resolvedAt) {
        this.id = id;
        this.description = description;
        this.username = username;
        this.binId = binId;
        this.status = status;
        this.createdAt = createdAt;
        this.resolvedAt = resolvedAt;
    }
}
