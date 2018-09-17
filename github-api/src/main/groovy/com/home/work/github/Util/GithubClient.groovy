package com.home.work.github.Util

import groovy.transform.CompileStatic
import org.springframework.stereotype.Component


@CompileStatic
@Component
class GithubClient {

   static HttpURLConnection makeApiCall(String method, String url, String... param) throws Exception {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection()
        con.setRequestMethod(method)
        con.setRequestProperty("Accept", "application/json")
        if (param.length > 0) {
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5")
            con.setDoOutput(true)
            DataOutputStream wr = new DataOutputStream(con.getOutputStream())
            wr.writeBytes(param[0])
            wr.flush()
            wr.close()
        }
        con.getResponseCode()
        con
    }
}
