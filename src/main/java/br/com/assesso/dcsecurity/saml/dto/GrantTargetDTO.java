package br.com.assesso.dcsecurity.saml.dto;


public class GrantTargetDTO {

	private byte[] idGrant;
	private long versao;
	private byte[] idTarget;
	private int idProduct;
	private boolean isReadonly;

	public byte[] getIdGrant() {
		return idGrant;
	}

	public void setIdGrant(byte[] idGrant) {
		this.idGrant = idGrant;
	}

	public long getVersao() {
		return versao;
	}

	public void setVersao(long versao) {
		this.versao = versao;
	}

	public byte[] getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(byte[] idTarget) {
		this.idTarget = idTarget;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public boolean isReadonly() {
		return isReadonly;
	}

	public void setReadonly(boolean isReadonly) {
		this.isReadonly = isReadonly;
	}

}