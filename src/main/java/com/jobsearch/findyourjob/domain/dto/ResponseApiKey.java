package com.jobsearch.findyourjob.domain.dto;/*
 * @created by Tom 10/10/2023
 */

public class ResponseApiKey {

    private String apiKey;

    public ResponseApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
