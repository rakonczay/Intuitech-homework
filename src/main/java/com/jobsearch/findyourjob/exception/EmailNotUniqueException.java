package com.jobsearch.findyourjob.exception;/*
 * @created by Tom 10/10/2023
 */

public class EmailNotUniqueException extends RuntimeException {
    public EmailNotUniqueException() {
        super("Email is not unique");
    }
}