package com.cisco.prj.entity.dao;

public class FetchException extends  Exception{
    public FetchException() {
    }

    public FetchException(String message) {
        super(message);
    }

    public FetchException(String message, Throwable cause) {
        super(message, cause);
    }
}
