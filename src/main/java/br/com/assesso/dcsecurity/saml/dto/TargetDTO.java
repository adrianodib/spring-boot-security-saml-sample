package br.com.assesso.dcsecurity.saml.dto;

public class TargetDTO {
	
	private int idProduct;
	private String tpTarget;
	private String dsTarget;
	private String dsCompTarget;
	private int nuOrder;
	private String dsGif;
	private String dsPath;
	private String dsUrl;
	private String dsDefault;
	private String dsValue;
	
	public TargetDTO() {}

	public String getTpTarget() {
		return tpTarget;
	}

	public void setTpTarget(String tpTarget) {
		this.tpTarget = tpTarget;
	}

	public String getDsTarget() {
		return dsTarget;
	}

	public void setDsTarget(String dsTarget) {
		this.dsTarget = dsTarget;
	}

	public String getDsCompTarget() {
		return dsCompTarget;
	}

	public void setDsCompTarget(String dsCompTarget) {
		this.dsCompTarget = dsCompTarget;
	}

	public Integer getNuOrder() {
		return nuOrder;
	}

	public void setNuOrder(Integer nuOrder) {
		this.nuOrder = nuOrder;
	}

	public String getDsGif() {
		return dsGif;
	}

	public void setDsGif(String dsGif) {
		this.dsGif = dsGif;
	}

	public String getDsPath() {
		return dsPath;
	}

	public void setDsPath(String dsPath) {
		this.dsPath = dsPath;
	}

	public String getDsUrl() {
		return dsUrl;
	}

	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}

	public String getDsDefault() {
		return dsDefault;
	}

	public void setDsDefault(String dsDefault) {
		this.dsDefault = dsDefault;
	}

	public String getDsValue() {
		return dsValue;
	}

	public void setDsValue(String dsValue) {
		this.dsValue = dsValue;
	}

	public void setNuOrder(int nuOrder) {
		this.nuOrder = nuOrder;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
}