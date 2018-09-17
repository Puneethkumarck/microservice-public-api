package com.home.work.github.domain

import groovy.transform.CompileStatic
import org.apache.commons.lang.builder.ToStringBuilder
import org.springframework.stereotype.Component

@CompileStatic
@Component
class Author {

    String name

    String email

    String date


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("email", email)
                .append("date", date)
                .toString();
    }
}
