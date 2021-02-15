package br.com.assesso.dcsecurity.saml.email.to;

import java.io.Serializable;

public class ContactTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String type;
  private String value;
  private int priority;
  private boolean notify;

  public ContactTO() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return (this.type == null) ? "" : this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getValue() {
    return (this.value == null) ? "" : this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public int getPriority() {
    return this.priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public boolean isNotify() {
    return this.notify;
  }

  public void setNotify(boolean notify) {
    this.notify = notify;
  }
}
