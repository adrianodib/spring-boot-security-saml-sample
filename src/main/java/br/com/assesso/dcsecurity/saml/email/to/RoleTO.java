package br.com.assesso.dcsecurity.saml.email.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoleTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private int id;
  private ProductTO product;
  private String description;
  private String name;
  private List<GrantTO> listGrantTO;

  public RoleTO() {
    this.product = new ProductTO();
    this.listGrantTO = new ArrayList<GrantTO>();
  }

  public ProductTO getProduct() {
    return product;
  }

  public void setProduct(ProductTO product) {
    this.product = product;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return (description==null)?"":description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<GrantTO> getListGrantTO() {
    return listGrantTO;
  }

  public void setListGrantTO(List<GrantTO> listGrantTO) {
    this.listGrantTO = listGrantTO;
  }

}