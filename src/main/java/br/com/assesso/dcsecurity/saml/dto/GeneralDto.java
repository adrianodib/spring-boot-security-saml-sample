package br.com.assesso.dcsecurity.saml.dto;

import java.io.Serializable;

/**
 * Objeto que representa as definições iniciais do projeto
 * @author adrianodib
 *
 */
public class GeneralDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String language;
	private String hasInternetConnection;
	private String milisToResendTokenSms;
	private String milisToResendTokenEmail;
	private String passwordMinimumSize;
	
	public GeneralDto() {}

	public GeneralDto(String language, String hasInternet, String timeToResendSms, String timeToResendEmail, String passwordMinimumSize) {
		
		this.language = language;
		this.hasInternetConnection = hasInternet;
		this.milisToResendTokenSms = timeToResendSms;
		this.milisToResendTokenEmail = timeToResendEmail;
		this.passwordMinimumSize = passwordMinimumSize;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHasInternetConnection() {
		return hasInternetConnection;
	}

	public void setHasInternetConnection(String hasInternetConnection) {
		this.hasInternetConnection = hasInternetConnection;
	}

	public String getMilisToResendTokenSms() {
		return milisToResendTokenSms;
	}

	public void setMilisToResendTokenSms(String milisToResendTokenSms) {
		this.milisToResendTokenSms = milisToResendTokenSms;
	}

	public String getMilisToResendTokenEmail() {
		return milisToResendTokenEmail;
	}

	public void setMilisToResendTokenEmail(String milisToResendTokenEmail) {
		this.milisToResendTokenEmail = milisToResendTokenEmail;
	}

	public String getPasswordMinimumSize() {
		return passwordMinimumSize;
	}

	public void setPasswordMinimumSize(String passwordMinimumSize) {
		this.passwordMinimumSize = passwordMinimumSize;
	}
}