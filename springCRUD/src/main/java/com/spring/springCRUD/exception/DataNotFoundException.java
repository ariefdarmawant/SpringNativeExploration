package com.spring.springCRUD.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataNotFoundException extends RuntimeException{

    public Class<?> clazz;

    public String message;
}
