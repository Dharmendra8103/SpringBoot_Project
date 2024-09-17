package com.codewitharjun.app.exception;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException(Long id){
        super(String.format("Could not found the user with id %d" ,id));
    }
}
