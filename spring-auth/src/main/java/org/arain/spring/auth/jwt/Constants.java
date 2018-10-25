package org.arain.spring.auth.jwt;

/**
 * 
 * @author arain
 * @date 2018年10月18日 下午3:32:17
 */
public class Constants {
    public final static String RESOURCE_TYPE_MENU = "MENU";
    public final static String RESOURCE_TYPE_BTN = "BUTTON";
    public static final Integer EX_TOKEN_ERROR_CODE = 40101;
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40102;
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40131;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final Integer EX_OTHER_CODE = 500;
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
    public static final String JWT_KEY_USER_SERIALNO = "serialNo";
    public static final String JWT_KEY_NAME = "name";
    public static final String JWT_KEY_HEAD = "head";
    public static final String JWT_KEY_REGION = "region";

}
