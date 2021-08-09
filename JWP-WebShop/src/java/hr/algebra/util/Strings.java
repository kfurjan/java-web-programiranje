package hr.algebra.util;

/**
 *
 * @author efurkev
 */
public class Strings {
    
    // html form names
    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_REPEAT = "passwordRepeat";
    
    // request, session keys
    public static final String USER_KEY = "userKey";
    public static final String ERROR_MESSAGE_KEY = "errorMessageKey";
    
    // view strings
    public static final String FIELDS_CANT_BE_EMPTY = "Fields cannot be empty!";
    public static final String NON_MATCHING_PASSWORDS = "Passwords do not match!";
    public static final String INVALID_EMAIL_PASSWORD = "Invalid email address or password!";
    public static final String ERROR_WHILE_REGISTERING = "An error occured while registering new user";
    
    // application constants
    public static final String PERSISTENCE_UNIT = "JWP-WebShopPU";
    
    // application endpoints
    public static final String HOME_ENDPOINT = "/";
    public static final String LOGIN_ENDPOINT = "/";
    public static final String REGISTER_ENDPOINT = "/register.jsp";
}
