package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.util.Arrays;

public class SecAppPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private byte[] idApp;
	private int idProduct;

    
	public byte[] getIdApp() {
		return idApp;
	}


	public void setIdApp(byte[] idApp) {
		this.idApp = idApp;
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
		result = prime * result + Arrays.hashCode(idApp);
		result = prime * result + idProduct;
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
		SecAppPK other = (SecAppPK) obj;
		if (!Arrays.equals(idApp, other.idApp))
			return false;
		if (idProduct != other.idProduct)
			return false;
		return true;
	}


}
