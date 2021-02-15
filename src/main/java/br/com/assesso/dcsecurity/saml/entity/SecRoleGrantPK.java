package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author ldoi
 *
 */
public class SecRoleGrantPK implements Serializable{

	private static final long serialVersionUID = -6676491971061719351L;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(idGrant);
		result = prime * result + idProduct;
		result = prime * result + Arrays.hashCode(idRole);
		result = prime * result + (int) (versaoGrant ^ (versaoGrant >>> 32));
		result = prime * result + (int) (versaoRole ^ (versaoRole >>> 32));
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
		SecRoleGrantPK other = (SecRoleGrantPK) obj;
		if (!Arrays.equals(idGrant, other.idGrant))
			return false;
		if (idProduct != other.idProduct)
			return false;
		if (!Arrays.equals(idRole, other.idRole))
			return false;
		if (versaoGrant != other.versaoGrant)
			return false;
		if (versaoRole != other.versaoRole)
			return false;
		return true;
	}

}