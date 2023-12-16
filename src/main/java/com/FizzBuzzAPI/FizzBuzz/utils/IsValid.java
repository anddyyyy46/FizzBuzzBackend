package com.FizzBuzzAPI.FizzBuzz.utils;

public class IsValid {
    private String errorText;
    private boolean isValid;

    public IsValid(String errorText, boolean isValid) {
        this.errorText = errorText;
        this.isValid = isValid;
    }

    public IsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getErrorText() {
        return errorText;
    }

    public boolean isValid() {
        return isValid;
    }

}
