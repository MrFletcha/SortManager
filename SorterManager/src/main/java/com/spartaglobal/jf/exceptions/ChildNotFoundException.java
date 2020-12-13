package com.spartaglobal.jf.exceptions;

public class ChildNotFoundException extends Throwable {

    @Override
    public String getMessage() {
        return "No child node element has been found";
    }
}
