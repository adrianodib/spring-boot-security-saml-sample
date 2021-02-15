package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

/**
 * Target = permissões
 * @author adrianodib
 *
 */
@Entity
@Audited
@Table(name = "SEC_TARGET")
@IdClass(SecTargetPK.class)
public class SecTarget implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_TARGET", nullable = false)
	private byte[] idTarget;
	@Transient
	private String idTargetString;

	@Id
	@Column(name = "ID_PRODUCT", nullable = false)
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
	private boolean isSystemRegistry;	
	
	@Transient
	private boolean isReadyOnly;

	public SecTarget() {}
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", nullable=false, insertable=false ,updatable=false)
	public SecProduct product;
	
	@ManyToMany
	@Transient
	private List<SecGrant> secGrantList;
	
	public List<SecGrant> getSecGrantList() {
		return secGrantList;
	}

	public void setSecGrantList(List<SecGrant> secGrantList) {
		this.secGrantList = secGrantList;
	}	
	
	public SecProduct getProduct() {
		return product;
	}

	public void setProduct(SecProduct product) {
		this.product = product;
	}	

	public byte[] getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(byte[] idTarget) {
		this.idTarget = idTarget;
		this.idTargetString = new String(idTarget);
	}

	public String getIdTargetString() {
		if (this.idTargetString == null) {
      if(this.idTarget != null) {
        this.idTargetString = new String(this.idTarget);
      }
    }
		return idTargetString;
	}

	public void setIdTargetString(String idTargetString) {
		this.idTargetString = idTargetString;
		this.idTarget = idTargetString.getBytes();
	}

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

	public int getNuOrder() {
		return nuOrder;
	}

	public void setNuOrder(int nuOrder) {
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

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getDsValue() {
		return dsValue;
	}

	public void setDsValue(String dsValue) {
		this.dsValue = dsValue;
	}

	public boolean isReadyOnly() {
		return isReadyOnly;
	}

	public void setReadyOnly(boolean isReadyOnly) {
		this.isReadyOnly = isReadyOnly;
	}

	public String getDsCompTarget() {
		return dsCompTarget;
	}

	public void setDsCompTarget(String dsCompTarget) {
		this.dsCompTarget = dsCompTarget;
	}

	public boolean isSystemRegistry() {
		return isSystemRegistry;
	}

	public void setSystemRegistry(boolean isSystemRegistry) {
		this.isSystemRegistry = isSystemRegistry;
	}
	
	
}