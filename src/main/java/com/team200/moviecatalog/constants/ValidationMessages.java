package com.team200.moviecatalog.constants;

public final class ValidationMessages {

    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String EMAIL_INVALID = "Email must be valid";
    public static final String NICKNAME_REQUIRED = "Nickname is required";
    public static final String PASSWORD_REQUIRED = "Password is required";
    public static final String PASSWORD_PATTERN =
            "Password must contain at least one letter, "
                    + "one number, no spaces, and be 8-64 chars long";
    public static final String REPEAT_PASSWORD_REQUIRED = "Repeat password is required";

    private ValidationMessages() {
    }

}
