package com.home.work.github.service
import com.fasterxml.jackson.databind.ObjectMapper
import com.home.work.github.Util.GithubClient
import com.home.work.github.domain.Author
import com.home.work.github.domain.CommitDetail
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@CompileStatic
@Service
class CommitService {

    @Autowired
    ObjectMapper objectMapper

    Map getCommit(String userName,String repoName,String sha){
        objectMapper.readValue(GithubClient.makeApiCall("GET", "https://api.github.com/repos/${userName}/${repoName}/git/commits/${sha}").getInputStream(), Map.class)
    }

    List<Author> getAuthors(){
        Author author=new Author()
        author.name = "puneeth"
        author.email="punith.564@gmail.com"

        Author author1=new Author()
        author1.name="dileep"
        author1.email="dileep.123@gmail"

        List<Author> authorList=new ArrayList<>()
        authorList << author
        authorList <<author1
        authorList
    }

}
