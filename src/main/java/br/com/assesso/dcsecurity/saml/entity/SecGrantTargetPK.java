package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.util.Arrays;

public class SecGrantTargetPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private byte[] idGrant;
	private byte[] idTarget;
	private long versao;
  private int idProduct;


 public byte[] getIdGrant() {
		return idGrant;
	}

	public void setIdGrant(byte[] idGrant) {
		this.idGrant = idGrant;
	}

	public byte[] getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(byte[] idTarget) {
		this.idTarget = idTarget;
	}

	public long getVersao() {
		return versao;
	}

	public void setVersao(long versao) {
		this.versao = versao;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(idGrant);
		result = prime * result + idProduct;
		result = prime * result + Arrays.hashCode(idTarget);
		result = prime * result + (int) (versao ^ (versao >>> 32));
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
		SecGrantTargetPK other = (SecGrantTargetPK) obj;
		if (!Arrays.equals(idGrant, other.idGrant))
			return false;
		if (idProduct != other.idProduct)
			return false;
		if (!Arrays.equals(idTarget, other.idTarget))
			return false;
		if (versao != other.versao)
			return false;
		return true;
	}

}
