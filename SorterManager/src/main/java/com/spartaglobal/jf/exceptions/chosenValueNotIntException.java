package com.spartaglobal.jf.exceptions;

public class chosenValueNotIntException extends Exception {

    @Override
    public String getMessage() {
        return "You failed to input a numerical value, so I guess me and you are done. Goodbye You!";
    }
}
