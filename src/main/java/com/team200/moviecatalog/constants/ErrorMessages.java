package com.team200.moviecatalog.constants;

public final class ErrorMessages {

    public static final String INVALID_AUTH_TOKEN = "Invalid authentication token";
    public static final String AUTHENTICATION_REQUIRED = "Authentication required";
    public static final String ACCESS_DENIED = "You do not have permission to access this resource";
    public static final String INVALID_EMAIL_OR_PASSWORD = "Invalid email or password";
    public static final String MALFORMED_JSON = "Malformed JSON request";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
    public static final String DATA_INTEGRITY_VIOLATION = "Data integrity violation";
    public static final String GOOGLE_INVALID_ID_TOKEN = "Invalid Google ID token";
    public static final String GOOGLE_TOKEN_VERIFICATION_FAILED =
            "Unable to verify Google ID token";
    public static final String GOOGLE_CLIENT_ID_REQUIRED =
            "Google OAuth client ID must be configured";
    public static final String ROLE_USER_NOT_FOUND = "Role USER not found";

    private ErrorMessages() {
    }
}
