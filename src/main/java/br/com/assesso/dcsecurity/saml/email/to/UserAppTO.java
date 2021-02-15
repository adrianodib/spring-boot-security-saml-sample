package br.com.assesso.dcsecurity.saml.email.to;

import java.io.Serializable;

import br.com.assesso.dcsecurity.saml.utils.StatementConstants;

public class UserAppTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private ProductTO product;
  private AppTO app;
  private RoleTO role;
  private String status;

  public UserAppTO() {
    product = new ProductTO();
    app = new AppTO();
    role = new RoleTO();
  }

  public ProductTO getProduct() {
    return product;
  }

  public void setProduct(ProductTO product) {
    this.product = product;
  }

  public AppTO getApp() {
    return app;
  }

  public void setApp(AppTO app) {
    this.app = app;
  }

  public RoleTO getRole() {
    return role;
  }

  public void setRole(RoleTO role) {
    this.role = role;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public boolean isAtivo() {
    return this.status.equals(StatementConstants.SEC_USER_APP_FG_STATUS_ATIVO);
  }
}