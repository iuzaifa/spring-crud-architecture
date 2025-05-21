package com.bitsnbyte_product.constant;


public class CommonConstants {




    public static final String API_BASE_PATH = "/api";
    public static final String USER_BASE_PATH = "/user";



    // USERS APIS
    public static final String CREATE_USERS =  "/register";
    public static final String GET_ALL_USERS =  "/users";
    public static final String GET_BY_ID_USER =  "/{userId}";
    public static final String DELETE_USER_BY_ID =  "/{userId}";
    public static final String UPDATE_USER_BY_ID =  "/{userId}";


    // PRODUCTS APIS
    public static final String CREATE_PRODUCTS =  "/product";
    public static final String GET_ALL_PRODUCTS =  "/product";
    public static final String GET_PRODUCT_BY_ID = "/product/{productId}";
    public static final String DELETE_PRODUCT_BY_ID = "/product/{productId}";
    public static final String UPDATE_PRODUCT_BY_ID = "/product/{productId}";



    // CATEGORIES APIS
    public static final String CREATE_CATEGORIES =  "/categories";
    public static final String GET_ALL_CATEGORIES =  "/categories";
    public static final String GET_CATEGORY_BY_ID =  "/categories/{categoryId}";
    public static final String DELETE_CATEGORY_BY_ID =  "/categories/{categoryId}";
    public static final String UPDATE_CATEGORY_BY_ID =  "/categories/{categoryId}";




}
