package com.home.work.github.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.home.work.github.domain.Author
import com.home.work.github.domain.CommitDetail
import com.home.work.github.service.CommitService
import groovy.transform.CompileStatic
import org.apache.commons.lang.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@CompileStatic
@RestController
@RequestMapping("/github/commit")
class CommitController {

    @Autowired
    CommitService commitService

    @Autowired
    ObjectMapper objectMapper

    @GetMapping("/{userName}/{repoName}/{sha}")
    CommitDetail getCommit(@PathVariable String userName, @PathVariable String repoName, @PathVariable String sha){
        CommitDetail commitDetail
            if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(repoName) && StringUtils.isNotBlank(sha)) {
                Map responseMap = commitService.getCommit(userName, repoName, sha)
                commitDetail=objectMapper.convertValue(responseMap,CommitDetail.class)
            } else {
                throw new IllegalArgumentException("invalid argument for get commit details arguments [ ${userName} ${repoName} ${sha}]")
            }
        commitDetail
    }


    @GetMapping("/authors")
    List<Author> getAutors() {
        commitService.getAuthors()
    }
}
