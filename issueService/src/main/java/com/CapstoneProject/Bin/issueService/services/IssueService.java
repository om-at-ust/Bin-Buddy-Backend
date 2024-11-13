package com.CapstoneProject.Bin.issueService.services;

import com.CapstoneProject.Bin.issueService.dtos.Bin;
import com.CapstoneProject.Bin.issueService.dtos.IssueDTO;
import com.CapstoneProject.Bin.issueService.dtos.UserDTO;
import com.CapstoneProject.Bin.issueService.entity.Issue;
import com.CapstoneProject.Bin.issueService.entity.IssueStatus;
import com.CapstoneProject.Bin.issueService.feignClients.BinFeignClient;
import com.CapstoneProject.Bin.issueService.feignClients.UserFeignClient;
import com.CapstoneProject.Bin.issueService.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private BinFeignClient binFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;

    public String createIssue(IssueDTO issue,Long binId) {
        Bin bin1 = binFeignClient.getBinById(binId);
        String userName = issue.getUsername();

        UserDTO user= userFeignClient.getUserByUserName(userName);

        if(bin1 == null || user == null) {
            return "Bin or User not found";
        }
        Issue realIssue = new Issue();
        realIssue.setBinId(bin1.getId());
        realIssue.setUsername(issue.getUsername());
        realIssue.setDescription(issue.getDescription());
        realIssue.setCreatedAt(LocalDateTime.now());
        realIssue.setStatus(IssueStatus.PENDING);
        realIssue.setResolvedAt(null);
        issueRepository.save(realIssue);
        return "Issue created successfully";

    }

    public Issue resolveIssue(String issueId) {
        Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new RuntimeException("Issue not found"));
        issue.setStatus(IssueStatus.RESOLVED);
        issue.setResolvedAt(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    public List<Issue> getPendingIssues() {
        return issueRepository.findByStatus(IssueStatus.PENDING);
    }

    public List<Issue> getResolvedIssues() {
        return issueRepository.findByStatus(IssueStatus.RESOLVED);
    }
    public List<Issue> getUserIssues(String username) {

        return issueRepository.findByusername(username);
    }
}


