package com.lumie.common.exception;

public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(CommonErrorCode.RESOURCE_NOT_FOUND,
              String.format("%s not found with identifier: %s", resourceName, identifier));
    }
}
