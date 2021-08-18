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
    
    public static final String PRODUCT_ID_ORDER = "productIdOrder";
    public static final String PRODUCT_NAME_ORDER = "productNameOrder";
    public static final String PRODUCT_DESC_ORDER = "productDescriptionOrder";
    public static final String PRODUCT_SKU_ORDER = "productSkuOrder";
    public static final String PRODUCT_TOTAL_QUANTITY_ORDER = "productTotalQuantityOrder";
    public static final String PRODUCT_CATEGORY_ORDER = "productCategoryOrder";
    public static final String PRODUCT_CATEGORY_ID_ORDER = "productCategoryIdOrder";
    public static final String PRODUCT_PRICE_ORDER = "productPriceOrder";
    public static final String PRODUCT_QUANTITY_TO_ORDER = "productQuantityToOrder";
    public static final String BUTTON_ORDER_PRODUCT = "btnOrderProduct";

    public static final String PRODUCT_ID_CART = "productIdCart";
    public static final String BUTTON_UPDATE_PRODUCT_CART = "btnUpdateCartItem";
    public static final String BUTTON_DELETE_PRODUCT_CART = "btnDeleteCartItem";
    
    // request, session keys
    public static final String USER_KEY = "user";
    public static final String CART_KEY = "cart";
    public static final String PRODUCT_KEY = "products";
    public static final String PAYMENT_METHOD_KEY = "paymentMethods";
    public static final String AVAILABLE_PRODUCT_KEY = "availableProducts";
    public static final String HOME_ERROR_MESSAGE_KEY = "homeErrorMessage";
    public static final String CART_ERROR_MESSAGE_KEY = "cartErrorMessage";
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
    public static final String ERROR_WITH_ORDER_QUANTITY = "Order quantity cannot be greater than total quantity of the product!";
    public static final String ERROR_ITEM_ALREADY_IN_CART = "Desired item is already added to cart!";
    
    // application constants
    public static final String EMPTY_STRING = "";
    public static final String DOUBLE_QUOTE = "\"";
    public static final String DATE_PATTERN = "yyyy-mm-dd hh:mm:ss";
    public static final String PERSISTENCE_UNIT = "JWP-WebShopPU";
    
    // application endpoints
    public static final String HOME_ENDPOINT = "/";
    public static final String CART_ENDPOINT = "/cart.jsp";
    public static final String LOGIN_ENDPOINT = "/login.jsp";
    public static final String PRODUCT_ENDPOINT = "/product.jsp";
    public static final String REGISTER_ENDPOINT = "/register.jsp";
    public static final String USER_HISTORY_ENDPOINT = "/userHistory.jsp";
    public static final String PRODUCT_CATEGORY_ENDPOINT = "/productCategory.jsp";
}
