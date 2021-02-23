package com.anma.bh.sb.springtesting.files;

import java.net.MalformedURLException;

public class StorageFileNotFoundException extends FileStorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
