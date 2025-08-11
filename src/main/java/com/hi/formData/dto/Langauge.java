package com.hi.formData.dto;

public enum Langauge {
    JAVA("자바"), C("C언어"),
    CPP("C++"), PYTHON("파이썬");
    private final String description;
    Langauge(String description) {
        this.description = description;
    }
}
