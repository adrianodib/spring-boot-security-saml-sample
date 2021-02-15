package br.com.assesso.dcsecurity.saml.email.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GrantTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private int id;
  private ProductTO product;
  private String description;
  private String name;
  private List<TargetTO> listTargetTO;
  
  public GrantTO() {
    product = new ProductTO();
    listTargetTO = new ArrayList<TargetTO>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ProductTO getProduct() {
    return product;
  }

  public void setProduct(ProductTO product) {
    this.product = product;
  }

  public String getDescription() {
    return (this.description==null)?"":this.description;
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

  public List<TargetTO> getListTargetTO() {
    return listTargetTO;
  }

  public void setListTargetTO(List<TargetTO> listTargetTO) {
    this.listTargetTO = listTargetTO;
  }

}