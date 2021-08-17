package hr.algebra.util;

/**
 *
 * @author efurkev
 */
public class Strings {
    
    // html form names
    public static final String EMAIL = "email";
    public static final String ADMIN = "Admin";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_REPEAT = "passwordRepeat";
    public static final String CATEGORY_ID = "categoryID";
    public static final String PRODUCT_SKU_CREATE = "productSkuCreate";
    public static final String PRODUCT_NAME_CREATE = "productNameCreate";
    public static final String PRODUCT_PRICE_CREATE = "productPriceCreate";
    public static final String PRODUCT_QUANTITY_CREATE = "productQuantityCreate";
    public static final String PRODUCT_ID_UPDATE_DELETE = "productIDUpdateDelete";
    public static final String PRODUCT_CATEGORY_ID_CREATE = "productCategoryCreateID";
    public static final String PRODUCT_NAME_UPDATE_DELETE = "productNameUpdateDelete";
    public static final String PRODUCT_SKU_UPDATE_DELETE = "productSkuUpdateDelete";
    public static final String PRODUCT_DESC_UPDATE_DELETE = "productDescriptionUpdateDelete";
    public static final String PRODUCT_PRICE_UPDATE_DELETE = "productPriceUpdateDelete";
    public static final String PRODUCT_CATEGPRY_NAME_CREATE = "productCategoryCreateName";
    public static final String PRODUCT_QUANTITY_UPDATE_DELETE = "productQuantityUpdateDelete";
    public static final String PRODUCT_CATEGPRY_UPDATE_DELETE = "productCategoryUpdateDelete";
    public static final String CATEGORY_NAME_CREATE = "categoryNameCreate";
    public static final String CATEGORY_NAME_UDPATE_DELETE = "categoryNameUpdateDelete";
    public static final String BUTTON_CREATE_PRODUCT = "btnCreateProduct";
    public static final String BUTTON_UPDATE_PRODUCT = "btnUpdateProduct";
    public static final String BUTTON_DELETE_PRODUCT = "btnDeleteProduct";
    public static final String BUTTON_CREATE_CATEGORY = "btnCreateProductCategory";
    public static final String BUTTON_UPDATE_CATEGORY = "btnUpdateProductCategory";
    public static final String BUTTON_DELETE_CATEGORY = "btnDeleteProductCategory";
    public static final String PRODUCT_DESCRIPTION_CREATE = "productDescriptionCreate";
    public static final String CATEGORY_DESCRIPTION_CREATE = "categoryDescriptionCreate";
    public static final String CATEGORY_DESCRIPTION_UPDATE_DELETE = "categoryDescriptionUpdateDelete";
    
    // request, session keys
    public static final String USER_KEY = "user";
    public static final String PRODUCT_KEY = "products";
    public static final String AVAILABLE_PRODUCT_KEY = "availableProducts";
    public static final String USER_HISTORY_KEY = "userHistory";
    public static final String ERROR_MESSAGE_KEY = "errorMessage";
    public static final String PRODUCT_CATEGORY_KEY = "productCategory";
    public static final String PRODUCT_ERROR_MESSAGE_KEY = "productErrorMessage";
    public static final String PRODUCT_CATEGORY_ERROR_MESSAGE_KEY = "productCategoryErrorMessage";
    
    // view strings
    public static final String GENERAL_ERROR = "An error occured!";
    public static final String FIELDS_CANT_BE_EMPTY = "Fields cannot be empty!";
    public static final String NON_MATCHING_PASSWORDS = "Passwords do not match!";
    public static final String INVALID_EMAIL_PASSWORD = "Invalid email address or password!";
    public static final String ERROR_WHILE_REGISTERING = "An error occured while registering new user";
    public static final String ERROR_WHILE_CREATING_PRODUCT = "An error occured while creating new product!";
    public static final String ERROR_WHILE_UPDATING_PRODUCT = "An error occured while updating product!";
    public static final String ERROR_WHILE_DELETING_PRODUCT = "An error occured while deleting product!";
    public static final String ERROR_WHILE_CREATING_PRODUCT_CATEGORY = "An error occured while creating new product category!";
    public static final String ERROR_WHILE_UPDATING_PRODUCT_CATEGORY = "An error occured while updating product category!";
    public static final String ERROR_WHILE_DELETING_PRODUCT_CATEGORY = "An error occured while deleting product category!";
    
    // application constants
    public static final String EMPTY_STRING = "";
    public static final String DOUBLE_QUOTE = "\"";
    public static final String DATE_PATTERN = "yyyy-mm-dd hh:mm:ss";
    public static final String PERSISTENCE_UNIT = "JWP-WebShopPU";
    
    // application endpoints
    public static final String HOME_ENDPOINT = "/";
    public static final String LOGIN_ENDPOINT = "/login.jsp";
    public static final String PRODUCT_ENDPOINT = "/product.jsp";
    public static final String REGISTER_ENDPOINT = "/register.jsp";
    public static final String USER_HISTORY_ENDPOINT = "/userHistory.jsp";
    public static final String PRODUCT_CATEGORY_ENDPOINT = "/productCategory.jsp";
}
