package com.CapstoneProject.Bin.issueService.repository;

import com.CapstoneProject.Bin.issueService.entity.Issue;
import com.CapstoneProject.Bin.issueService.entity.IssueStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends MongoRepository<Issue, String>{
    List<Issue> findByBinIdAndStatus(Long binId, IssueStatus status);

    List<Issue> findByStatus(IssueStatus issueStatus);

    List<Issue> findByusername(String username);

}
