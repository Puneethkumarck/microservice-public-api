package com.home.work.github.service
import com.fasterxml.jackson.databind.ObjectMapper
import com.home.work.github.Util.GithubClient
import com.home.work.github.domain.TreeDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TreeService {

    @Autowired
    ObjectMapper objectMapper

    Map getTrees(String userName, String repoName, String sha){
        objectMapper.readValue(GithubClient.makeApiCall("GET", "https://api.github.com/repos/${userName}/${repoName}/git/trees/${sha}").getInputStream(), Map.class)
    }

}
