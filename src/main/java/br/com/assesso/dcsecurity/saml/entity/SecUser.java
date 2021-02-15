package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author adrianodib
 *
 */
@Entity
@Audited
@Table(name = "SEC_USER")
public class SecUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
  private static final int EXPIRATION = 60 * 10;
	
	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_USER", nullable = false)	 
	private byte[] idUser;
	
	@Transient
	private String idUserString;
	
	private String dsEmail;
	private String dsName;
	@JsonIgnore
	private String dsPass;
	private String dsUsername;
	private String dsCell;
  private Date dtUltChangePass;
  private boolean isChangePass;
	private String status;
	private boolean isNotifyEmail;
	private boolean isNotifyCell;
	private boolean isNotifyCellCall;
	
	/* Utilizada para armazenar a quantidade de tentativas não sucedidadas de login - senha invalida*/
	private int vlAttemptLogin;
	private boolean isSystemRegistry;	
	
	private int tpNotify_2fa;
	
	private String dsCode_2FA;
	
  private Date dtExpiryCode_2FA; //Alterar isso para Timestamp
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "user")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)	  
  private List<SecUserApp> userAppList;
	
  public int getTpNotify2fa() {
		return tpNotify_2fa;
	}

	public void setTpNotify2fa(int tpNotify2fa) {
		this.tpNotify_2fa = tpNotify2fa;
	}
	
	public SecUser() {
		//this.secret = Base32.random();
	} 
	
	public int getTpNotify_2fa() {
		return tpNotify_2fa;
	}

	public void setTpNotify_2fa(int tpNotify_2fa) {
		this.tpNotify_2fa = tpNotify_2fa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	@JsonIgnore
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

	public boolean isChangePass() {
		return isChangePass;
	}

	public void setChangePass(boolean isChangePass) {
		this.isChangePass = isChangePass;
	}

	public Date getDtUltChangePass() {
		return dtUltChangePass;
	}

	public void setDtUltChangePass(Date dtUltChangePass) {
		this.dtUltChangePass = dtUltChangePass;
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

	public String getDsCode_2FA() {
		return dsCode_2FA;
	}

	public void setDsCode_2FA(String dsCode_2FA) {
		this.dsCode_2FA = dsCode_2FA;
	}

	public Date getDtExpiryCode_2FA() {
		return dtExpiryCode_2FA;
	}

	public void setDtExpiryCode_2FA(Date dtExpiryCode_2FA) {
		this.dtExpiryCode_2FA = dtExpiryCode_2FA;
	}
	
	public List<SecUserApp> getUserAppList() {
		return userAppList;
	}

	public void setUserAppList(List<SecUserApp> userAppList) {
		this.userAppList = userAppList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecUser other = (SecUser) obj;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

	public String getVerificationCode() {
		return dsCode_2FA;
	}

	public void setVerificationCode(String verificationCode) {
		this.dsCode_2FA = verificationCode;
        this.dtExpiryCode_2FA = calculateExpiryDate(EXPIRATION);		
	}

	public Date getVerificationCodeExpiryDate() {
		return dtExpiryCode_2FA;
	}

	public void setVerificationCodeExpiryDate(Date expiryDate) {
		this.dtExpiryCode_2FA = expiryDate;
	}

  private Date calculateExpiryDate(final int expiryTimeInMinutes) {
      final Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(new Date().getTime());
      cal.add(Calendar.MINUTE, expiryTimeInMinutes);
      return new Date(cal.getTime().getTime());
  }

	public String getIdUserString() {
		if (this.idUserString == null) {
      if(this.idUser != null) {
        this.idUserString = new String(this.idUser);
      }
    }
		return idUserString;
	}

	public void setIdUserString(String idUserString) {
		this.idUserString = idUserString;
		this.idUser = idUserString.getBytes();
	}

	public byte[] getIdUser() {
		return idUser;
	}
	
	public void setIdUser(byte[] idUser) {
		this.idUser = idUser;
		this.idUserString = new String(idUser);
	}

	public int getVlAttemptLogin() {
		return vlAttemptLogin;
	}

	public void setVlAttemptLogin(int vlAttemptLogin) {
		this.vlAttemptLogin = vlAttemptLogin;
	}

	public boolean isSystemRegistry() {
		return isSystemRegistry;
	}

	public void setSystemRegistry(boolean isSystemRegistry) {
		this.isSystemRegistry = isSystemRegistry;
	}
  
}