package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import br.com.assesso.dcsecurity.saml.enums.AlteracaoEnum;

//@Entity
public class SecLog implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String username;  // frontend vai enviar 
	private Timestamp dataHora;
	private String funcionalidade;
	private AlteracaoEnum alteracao;
	private String ip; // frontend vai enviar
	
	public SecLog() {}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getDataHora() {
		return dataHora;
	}
	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}
	public String getFuncionalidade() {
		return funcionalidade;
	}
	public void setFuncionalidade(String funcionalidade) {
		this.funcionalidade = funcionalidade;
	}
	public AlteracaoEnum getAlteracao() {
		return alteracao;
	}
	public void setAlteracao(AlteracaoEnum alteracao) {
		this.alteracao = alteracao;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}