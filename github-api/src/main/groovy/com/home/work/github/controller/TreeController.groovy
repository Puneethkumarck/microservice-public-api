package com.home.work.github.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.home.work.github.domain.CommitDetail
import com.home.work.github.domain.TreeDetail
import com.home.work.github.service.TreeService
import org.apache.commons.lang.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/github/trees")
class TreeController {

    @Autowired
    TreeService treeService

    @Autowired
    ObjectMapper objectMapper

    @GetMapping("/{userName}/{repoName}/{sha}")
    TreeDetail getTrees(@PathVariable String userName, @PathVariable String repoName, @PathVariable String sha){
        TreeDetail treeDetail
        if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(repoName) && StringUtils.isNotBlank(sha)) {
            Map responseMap = treeService.getTrees(userName, repoName, sha)
            treeDetail=objectMapper.convertValue(responseMap,TreeDetail.class)
        } else {
            throw new IllegalArgumentException("invalid argument for get commit details arguments [ ${userName} ${repoName} ${sha}]")
        }
        treeDetail
    }

}
