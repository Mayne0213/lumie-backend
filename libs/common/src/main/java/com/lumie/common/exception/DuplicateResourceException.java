package com.lumie.common.exception;

public class DuplicateResourceException extends BusinessException {

    public DuplicateResourceException(String resourceName, Object identifier) {
        super(CommonErrorCode.DUPLICATE_RESOURCE,
              String.format("%s already exists with identifier: %s", resourceName, identifier));
    }
}
