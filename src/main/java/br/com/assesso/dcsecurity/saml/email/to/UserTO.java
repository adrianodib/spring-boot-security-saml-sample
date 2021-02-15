package br.com.assesso.dcsecurity.saml.email.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.assesso.dcsecurity.saml.utils.StatementConstants;


public class UserTO implements Serializable {

  private static final long serialVersionUID = 1L;

  public UserTO() {
    listUserAppTO = new ArrayList<UserAppTO>();
    listContactTO = new ArrayList<ContactTO>();
  }

  private String email;
  private String name;
  private String login;
  private String pass;
  private int id;
  private String loginApp;
  private String passApp;
  private List<UserAppTO> listUserAppTO;
  private char changePass;
  private String status;
  private List<ContactTO> listContactTO;
  private boolean notifyEmail;
  private String cell;
  private boolean notifyCell;
  private boolean notifyCellCall;
  
  public UserTO (String name) {
	  this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return this.login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPass() {
    return pass==null?"":pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getLoginApp() {
    return loginApp;
  }

  public void setLoginApp(String loginApp) {
    this.loginApp = loginApp;
  }

  public String getPassApp() {
    return passApp==null?"":passApp;
  }

  public void setPassApp(String passApp) {
    this.passApp = passApp;
  }

  public List<UserAppTO> getListUserAppTO() {
    return listUserAppTO;
  }

  public void setListUserAppTO(List<UserAppTO> listUserAppTO) {
    this.listUserAppTO = listUserAppTO;
  }

  public char getChangePass() {
    return changePass != '1' ? '0' : changePass;
  }

  public void setChangePass(char changePass) {
    this.changePass = changePass;
  }

  public void setChangePass(String changePass) {
    this.changePass = changePass == null || changePass.equals("") ? '0' : changePass.charAt(0);
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

  public List<ContactTO> getListContactTO() {
    return listContactTO;
  }

  public void setListContactTO(List<ContactTO> listContactTO) {
    this.listContactTO = listContactTO;
  }

  public boolean isNotifyEmail() {
    return this.notifyEmail;
  }

  public void setNotifyEmail(boolean notifyEmail) {
    this.notifyEmail = notifyEmail;
  }

  public String getCell() {
    return this.cell;
  }

  public void setCell(String cell) {
    this.cell = cell;
  }

  public boolean isNotifyCell() {
    return this.notifyCell;
  }

  public void setNotifyCell(boolean notifyCell) {
    this.notifyCell = notifyCell;
  }

  public boolean isNotifyCellCall() {
    return this.notifyCellCall;
  }

  public void setNotifyCellCall(boolean notifyCellCall) {
    this.notifyCellCall = notifyCellCall;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.getId();
    result = prime * result + ((this.getLogin() == null) ? 0 : this.getLogin().hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof UserTO)) {
      return false;
    }
    UserTO other = (UserTO) obj;
    if (this.getId() != other.getId()) {
      return false;
    }
    if (this.getLogin() == null) {
      if (other.getLogin() != null) {
        return false;
      }
    } else if (!this.getLogin().equals(other.getLogin())) {
      return false;
    }
    return true;
  }
}
