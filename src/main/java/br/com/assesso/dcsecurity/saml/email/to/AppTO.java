package br.com.assesso.dcsecurity.saml.email.to;

import java.io.Serializable;

public class AppTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private int idProduct;
	private String dsApp;
	private String dsGif;
	private String dsSmallGif;
	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getDsApp() {
		return dsApp;
	}

	public void setDsApp(String dsApp) {
		this.dsApp = dsApp;
	}

	public String getDsGif() {
		return dsGif;
	}

	public void setDsGif(String dsGif) {
		this.dsGif = dsGif;
	}

	public String getDsSmallGif() {
		return dsSmallGif;
	}

	public void setDsSmallGif(String dsSmallGif) {
		this.dsSmallGif = dsSmallGif;
	}

}
