package com.example.lesson4;

import java.io.Serializable;

public class CatModel implements Serializable {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public CatModel(String statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    private String statusCode;
    private String description;


}
