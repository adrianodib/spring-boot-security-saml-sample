package br.com.assesso.dcsecurity.saml.dto;

public class RoleDTO {

	private int idProduct;
	private String dsRole;
	private String dsCompRole;
	private String dsName;
	
	public RoleDTO() {}
	
		public String getDsRole() {
		return dsRole;
	}
		
	public void setDsRole(String dsRole) {
		this.dsRole = dsRole;
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

	public String getDsCompRole() {
		return dsCompRole;
	}

	public void setDsCompRole(String dsCompRole) {
		this.dsCompRole = dsCompRole;
	}

	
}