package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "SEC_HISTORY_LOGIN")
public class SecHistoryLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistory;

	private Date dtLogin;
	private String dsUserName;
	private String dsApp;
	private String dsProduct;
	private String vlIP;
	private String dsBrowser;
	
	public SecHistoryLogin() {}

	public Date getDtLogin() {
		return dtLogin;
	}
	
	public void setDtLogin(Date dtLogin) {
		this.dtLogin = dtLogin;
	}
	
	public int getIdHistory() {
		return idHistory;
	}
	public void setIdHistory(int idHistory) {
		this.idHistory = idHistory;
	}

	public String getDsUserName() {
		return dsUserName;
	}

	public void setDsUserName(String dsUserName) {
		this.dsUserName = dsUserName;
	}

	public String getDsApp() {
		return dsApp;
	}

	public void setDsApp(String dsApp) {
		this.dsApp = dsApp;
	}

	public String getDsProduct() {
		return dsProduct;
	}

	public void setDsProduct(String dsProduct) {
		this.dsProduct = dsProduct;
	}

	public String getVlIP() {
		return vlIP;
	}

	public void setVlIP(String vlIP) {
		this.vlIP = vlIP;
	}

	public String getDsBrowser() {
		return dsBrowser;
	}

	public void setDsBrowser(String dsBrowser) {
		this.dsBrowser = dsBrowser;
	}
	
}