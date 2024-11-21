package com.CapstoneProject.Bin.issueService.controller;

import com.CapstoneProject.Bin.issueService.dtos.IssueDTO;
import com.CapstoneProject.Bin.issueService.entity.Issue;
import com.CapstoneProject.Bin.issueService.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
@CrossOrigin(origins = "http://localhost:5173")
public class IssueController {

    @Autowired
    private IssueService issueService;
    @PostMapping("/createIssue/{binId}")
    public ResponseEntity<String> createIssue(@RequestBody IssueDTO issue, @PathVariable String binId) {
           String result = issueService.createIssue(issue,binId);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @GetMapping("/pending")
    public ResponseEntity<List<Issue>> getPendingIssues() {
        List<Issue> pendingIssues = issueService.getPendingIssues();
        return new ResponseEntity<>(pendingIssues, HttpStatus.OK);
    }
    @PutMapping("/resolve/{issueId}")
    public ResponseEntity<Issue> resolveIssue(@PathVariable String issueId) {
        Issue resolvedIssue = issueService.resolveIssue(issueId);
        return new ResponseEntity<>(resolvedIssue, HttpStatus.OK);
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<List<Issue>> getUserIssues(@PathVariable String username) {
        List<Issue> userIssues = issueService.getUserIssues(username);
        return new ResponseEntity<>(userIssues, HttpStatus.OK);
    }
    @GetMapping("/resolved")
    public ResponseEntity<List<Issue>> getResolvedIssues() {
        List<Issue> resolvedIssues = issueService.getResolvedIssues();
        return new ResponseEntity<>(resolvedIssues, HttpStatus.OK);
    }
    @GetMapping("/getAllIssues")
    public ResponseEntity<List<Issue>> getAllIssues() {
        List<Issue> allIssues = issueService.getAllIssues();
        return new ResponseEntity<>(allIssues, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{issueId}")
    public ResponseEntity<String> deleteIssue(@PathVariable String issueId) {
        issueService.deleteIssue(issueId);
        return new ResponseEntity<>("Issue deleted successfully", HttpStatus.OK);
    }


}
