package br.com.assesso.dcsecurity.saml.dto;

import java.io.Serializable;

public class NewPassDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private byte[] id;
	private String passAntigo;
	private String passNovo1;
	private String passNovo2;
	
	public NewPassDto() {}

	public String getPassAntigo() {
		return passAntigo;
	}

	public void setPassAntigo(String passAntigo) {
		this.passAntigo = passAntigo;
	}

	public String getPassNovo1() {
		return passNovo1;
	}

	public void setPassNovo1(String passNovo1) {
		this.passNovo1 = passNovo1;
	}

	public String getPassNovo2() {
		return passNovo2;
	}

	public void setPassNovo2(String passNovo2) {
		this.passNovo2 = passNovo2;
	}

	public byte[] getId() {
		return id;
	}

	public void setId(byte[] id) {
		this.id = id;
	}

}
