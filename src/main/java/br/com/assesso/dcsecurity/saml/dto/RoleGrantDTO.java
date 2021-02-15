package br.com.assesso.dcsecurity.saml.dto;

public class RoleGrantDTO {

	private byte[] idRole;
	private long versaoRole;
	private byte[] idGrant;
	private long versaoGrant;	
	private int idProduct;

	public byte[] getIdRole() {
		return idRole;
	}

	public void setIdRole(byte[] idRole) {
		this.idRole = idRole;
	}

	public long getVersaoRole() {
		return versaoRole;
	}

	public void setVersaoRole(long versaoRole) {
		this.versaoRole = versaoRole;
	}

	public byte[] getIdGrant() {
		return idGrant;
	}

	public void setIdGrant(byte[] idGrant) {
		this.idGrant = idGrant;
	}

	public long getVersaoGrant() {
		return versaoGrant;
	}

	public void setVersaoGrant(long versaoGrant) {
		this.versaoGrant = versaoGrant;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

}