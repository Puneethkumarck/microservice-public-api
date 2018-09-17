package com.home.work.github.domain

import groovy.transform.CompileStatic
import org.apache.commons.lang.builder.ToStringBuilder
import org.springframework.stereotype.Component

@CompileStatic
@Component
class CommitDetail {

    String sha

    String url

    String html_url

    String message

    Author author

    Committer committer

    Tree tree

    Parent[] parents

    Verification verification


    @Override
     String toString() {
        return new ToStringBuilder(this)
                .append("sha", sha)
                .append("url", url)
                .append("html_url", html_url)
                .append("message", message)
                .append("author", author)
                .append("committer", committer)
                .append("tree", tree)
                .append("parents", parents)
                .append("verification", verification)
                .toString()
    }
}
