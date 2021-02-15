package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.util.Arrays;

public class SecTargetPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private byte[] idTarget;
	private int idProduct;

    
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduct;
		result = prime * result + Arrays.hashCode(idTarget);
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
		SecTargetPK other = (SecTargetPK) obj;
		if (idProduct != other.idProduct)
			return false;
		if (!Arrays.equals(idTarget, other.idTarget))
			return false;
		return true;
	}


}
