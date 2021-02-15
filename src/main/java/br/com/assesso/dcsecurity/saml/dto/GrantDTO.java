package br.com.assesso.dcsecurity.saml.dto;

public class GrantDTO {

	private int idProduct;
	private String dsGrant;
	private String dsCompGrant;
	private String dsName;

	public GrantDTO() {	}
	
	public String getDsGrant() {
		return dsGrant;
	}

	public void setDsGrant(String dsGrant) {
		this.dsGrant = dsGrant;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getDsCompGrant() {
		return dsCompGrant;
	}

	public void setDsCompGrant(String dsCompGrant) {
		this.dsCompGrant = dsCompGrant;
	}
	
}