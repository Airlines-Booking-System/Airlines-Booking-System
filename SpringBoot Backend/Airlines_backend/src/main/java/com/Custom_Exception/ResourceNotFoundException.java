package com.Custom_Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String errMsg)
    {
        super(errMsg);
    }
    
    
}
