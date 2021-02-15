package br.com.assesso.dcsecurity.saml.utils;
public class StatementConstants {

  /*Statements ASI*/
  public static final String ST_ASI_GET_USERS = "ASI_GET_USERS";

  /*Statements*/
  /* ASI v.1 */
  public static final String ST_GET_USER_ASI_V1 = "GET_USER_ASI_V1";
  public static final String ST_GET_TARGETS_ASI_V1_BY_USER = "GET_TARGETS_ASI_V1_BY_USER";
  /* ASI2 */
  public static final String ST_GET_APP_BY_ID = "GET_APP_BY_ID";
  public static final String ST_GET_APPS_BY_PRODUCT = "GET_APPS_BY_PRODUCT";
  public static final String ST_GET_GRANT_BY_ID = "GET_GRANT_BY_ID";
  public static final String ST_GET_GRANTS_BY_PRODUCT = "GET_GRANTS_BY_PRODUCT";
  public static final String ST_GET_GRANTS_BY_ROLE = "GET_GRANTS_BY_ROLE";
  public static final String ST_GET_PRODUCTS = "GET_PRODUCTS";
  public static final String ST_GET_ROLE_BY_ID = "GET_ROLE_BY_ID";
  public static final String ST_GET_ROLES_BY_PRODUCT = "GET_ROLES_BY_PRODUCT";
  public static final String ST_GET_TARGETS_BY_GRANT = "GET_TARGETS_BY_GRANT";
  public static final String ST_GET_TARGETS_BY_PRODUCT = "GET_TARGETS_BY_PRODUCT";
  public static final String ST_GET_TARGETS_BY_PRODUCT_APP_USER = "GET_TARGETS_BY_PRODUCT_APP_USER";
  public static final String ST_GET_TARGETS_BY_PRODUCT_APP_ROLE = "GET_TARGETS_BY_PRODUCT_APP_ROLE"; 
  public static final String ST_GET_USER = "GET_USER";
  public static final String ST_GET_USERS_BY_PRODUCT_APP = "GET_USERS_BY_PRODUCT_APP";
  public static final String ST_GET_NAME_USER_BY_ID = "GET_NAME_USER_BY_ID";
  public static final String ST_GET_FIELD_TARGET = "GET_FIELD_TARGET";
  public static final String ST_SEQUENCE = "SEQUENCE";
  public static final String ST_INSERT_APP = "INSERT_APP";
  public static final String ST_INSERT_GRANT = "INSERT_GRANT";
  public static final String ST_INSERT_GRANT_TARGET = "INSERT_GRANT_TARGET";
  public static final String ST_INSERT_ROLE = "INSERT_ROLE";
  public static final String ST_INSERT_ROLE_GRANT = "INSERT_ROLE_GRANT";
  public static final String ST_INSERT_TARGET = "INSERT_TARGET";
  public static final String ST_INSERT_USER = "INSERT_USER";
  public static final String ST_INSERT_USER_APP = "INSERT_USER_APP";
  public static final String ST_UPDATE_APP = "UPDATE_APP";
  public static final String ST_UPDATE_GRANT = "UPDATE_GRANT";
  public static final String ST_UPDATE_PASS = "UPDATE_PASS";
  public static final String ST_UPDATE_ROLE = "UPDATE_ROLE";
  public static final String ST_UPDATE_USER = "UPDATE_USER";
  public static final String ST_UPDATE_FIELD_TARGET = "UPDATE_FIELD_TARGET";
  public static final String ST_DELETE_APP = "DELETE_APP";
  public static final String ST_DELETE_GRANT = "DELETE_GRANT";
  public static final String ST_DELETE_GRANT_TARGET = "DELETE_GRANT_TARGET";
  public static final String ST_DELETE_ROLE = "DELETE_ROLE";
  public static final String ST_DELETE_ROLE_GRANT = "DELETE_ROLE_GRANT";
  public static final String ST_DELETE_USER_APP = "DELETE_USER_APP";
  public static final String ST_DELETE_USER = "DELETE_USER";
  public static final String ST_DISABLE_USER_APP = "DISABLE_USER_APP";
  public static final String ST_DISABLE_USER = "DISABLE_USER";
  public static final String ST_ENABLE_USER_APP = "ENABLE_USER_APP";
  public static final String ST_ENABLE_USER = "ENABLE_USER";
  public static final String ST_DELETE_TARGET = "DELETE_TARGET";
  public static final String ST_HAS_ROLE_GRANT_BY_GRANT = "HAS_ROLE_GRANT_BY_GRANT";
  public static final String ST_HAS_USER_APP_BY_ROLE = "HAS_USER_APP_BY_ROLE";
  public static final String ST_HAS_USER_APP_BY_APP = "HAS_USER_APP_BY_APP";
  public static final String ST_HAS_LOGIN_DUP = "HAS_LOGIN_DUP";
  public static final String ST_HAS_ROLE_DUP = "HAS_ROLE_DUP";
  public static final String ST_HAS_GRANT_DUP = "HAS_GRANT_DUP";
  public static final String ST_HAS_APP_DUP = "HAS_APP_DUP";
  public static final String CARREGA_GRANT = "CARREGA_GRANT";
  public static final String EXCLUI_GRANT_TARGET = "EXCLUI_GRANT_TARGET";

  /*Values*/
  public static final String SEC_USER_APP_FG_STATUS_ATIVO = "A";
  public static final String SEC_USER_APP_FG_STATUS_INATIVO = "I";

  /*Sequences*/
  public static final String SEQ_ID_APP = "ID_APP";
  public static final String SEQ_ID_GRANT = "ID_GRANT";
  public static final String SEQ_ID_ROLE = "ID_ROLE";
  public static final String SEQ_ID_USER = "ID_USER";
  public static final String SEQ_ID_TARGET = "ID_TARGET";
}