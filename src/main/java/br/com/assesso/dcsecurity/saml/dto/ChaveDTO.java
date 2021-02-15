package br.com.assesso.dcsecurity.saml.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChaveDTO implements Serializable {

	private static final long serialVersionUID = -7342707463378710978L;

	@JsonProperty(value = "ID")
	private String idString;
	
	@JsonProperty(value = "Versao")
	private Long versao;
	
	public ChaveDTO () {}
	
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public Long getVersao() {
		return versao;
	}
	public void setVersao(Long versao) {
		this.versao = versao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idString == null) ? 0 : idString.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
		ChaveDTO other = (ChaveDTO) obj;
		if (idString == null) {
			if (other.idString != null)
				return false;
		} else if (!idString.equals(other.idString))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}
}