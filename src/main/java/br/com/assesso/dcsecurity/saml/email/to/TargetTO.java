package br.com.assesso.dcsecurity.saml.email.to;

import java.io.Serializable;

public class TargetTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String type;
  private String description;
  private String extraInfo;
  private String value;
  private int order;
  private String gif;
  private String path;
  private String url;
  private String defaultValue;
  private boolean readonly;
  private ProductTO product;
  private AppTO application;
  private GrantTO grant;
  private RoleTO role;

  public TargetTO() {
    product = new ProductTO();
    application = new AppTO();
    role = new RoleTO();
    grant = new GrantTO();
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return (this.type==null)?"":this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return (this.description==null)?"":this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getExtraInfo() {
    return (extraInfo==null)?"":extraInfo;
  }

  public void setExtraInfo(String pextraInfo) {
    extraInfo = pextraInfo;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public ProductTO getProduct() {
    return product;
  }

  public void setProduct(ProductTO product) {
    this.product = product;
  }

  public String getGif() {
    return gif;
  }

  public void setGif(String gif) {
    this.gif = gif;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }
  
  public GrantTO getGrant() {
    return grant;
  }

  public void setGrant(GrantTO grant) {
    this.grant = grant;
  }

  public RoleTO getRole() {
    return role;
  }

  public void setRole(RoleTO role) {
    this.role = role;
  }
  
  public AppTO getApplication() {
    return application;
  }

  public void setApplication(AppTO application) {
    this.application = application;
  }

  public boolean getReadonly() {
    return readonly;
  }

  public void setReadonly(boolean readonly) {
    this.readonly = readonly;
  }

  public String getValue() {
    return (this.value==null)?"":this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}