package br.com.assesso.dcsecurity.saml.dto;

import java.util.Set;

import br.com.assesso.dcsecurity.saml.entity.SecUserApp;

public class SecUserDTO {

	private String dsEmail;
	private String dsName;
	private String dsPass;
	private String dsUsername;
	private String dsCell;
  private boolean isChangePass;
	private boolean isNotifyEmail;
	private boolean isNotifyCell;
	private boolean isNotifyCellCall;
	private boolean isSystemRegistry;	
	private int tpNotify_2fa;
	private Set<SecUserApp> userAppList;
    
	public String getDsEmail() {
		return dsEmail;
	}
	
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	
	public String getDsName() {
		return dsName;
	}
	
	public void setDsName(String dsName) {
		this.dsName = dsName;
	}
	
	public String getDsPass() {
		return dsPass;
	}
	
	public void setDsPass(String dsPass) {
		this.dsPass = dsPass;
	}
	
	public String getDsUsername() {
		return dsUsername;
	}
	
	public void setDsUsername(String dsUsername) {
		this.dsUsername = dsUsername;
	}
	
	public String getDsCell() {
		return dsCell;
	}
	
	public void setDsCell(String dsCell) {
		this.dsCell = dsCell;
	}
	
	public boolean getIsChangePass() {
		return isChangePass;
	}
	
	public void setIsChangePass(boolean isChangePass) {
		this.isChangePass = isChangePass;
	}
	
	public boolean isNotifyEmail() {
		return isNotifyEmail;
	}
	
	public void setNotifyEmail(boolean isNotifyEmail) {
		this.isNotifyEmail = isNotifyEmail;
	}
	
	public boolean isNotifyCell() {
		return isNotifyCell;
	}
	
	public void setNotifyCell(boolean isNotifyCell) {
		this.isNotifyCell = isNotifyCell;
	}
	
	public boolean isNotifyCellCall() {
		return isNotifyCellCall;
	}
	
	public void setNotifyCellCall(boolean isNotifyCellCall) {
		this.isNotifyCellCall = isNotifyCellCall;
	}

	public boolean isSystemRegistry() {
		return isSystemRegistry;
	}

	public void setSystemRegistry(boolean isSystemRegistry) {
		this.isSystemRegistry = isSystemRegistry;
	}

	public int getTpNotify_2fa() {
		return tpNotify_2fa;
	}

	public void setTpNotify_2fa(int tpNotify_2fa) {
		this.tpNotify_2fa = tpNotify_2fa;
	}

	public Set<SecUserApp> getUserAppList() {
		return userAppList;
	}

	public void setUserAppList(Set<SecUserApp> userAppList) {
		this.userAppList = userAppList;
	}

	public void setChangePass(boolean isChangePass) {
		this.isChangePass = isChangePass;
	}
	
	
	
}