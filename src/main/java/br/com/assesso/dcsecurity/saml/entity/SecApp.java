package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;


/**
 * Aplicações DCSecurity, Datacare, etc...
 * @author adrianodib
 *
 */
@Entity
@Audited
@Table(name = "SEC_APP")
@IdClass(SecAppPK.class)
public class SecApp implements Serializable{

	private static final long serialVersionUID = 2776002715985753036L;

	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_APP", nullable = false)
	private byte[] idApp;
	
	@Id
	@Column(name = "ID_PRODUCT", nullable = false)
	private int idProduct;

	@Transient
	private String idAppString;
	
	private String dsApp;
	private String dsGif;
	private String dsSmallGif;
	private boolean isSystemRegistry;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", nullable=false, insertable=false ,updatable=false)
	public SecProduct product;

	
	public SecApp() {}
	
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

	public byte[] getIdApp() {
		return idApp;
	}

	public void setIdApp(byte[] idApp) {
		this.idApp = idApp;
		this.idAppString = new String(idApp);
	}

	public String getIdAppString() {
		if (this.idAppString == null) {
      if(this.idApp != null) {
        this.idAppString = new String(this.idApp);
      }
    }
		return idAppString;
	}

	public void setIdAppString(String idAppString) {
		this.idAppString = idAppString;
		this.idApp = idAppString.getBytes();
	}
	
	public SecProduct getProduct() {
		return product;
	}

	public void setProduct(SecProduct product) {
		this.product = product;
	}

	public boolean isSystemRegistry() {
		return isSystemRegistry;
	}

	public void setSystemRegistry(boolean isSystemRegistry) {
		this.isSystemRegistry = isSystemRegistry;
	}	
}