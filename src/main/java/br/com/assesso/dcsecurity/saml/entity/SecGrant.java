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
 * Grant = privilégios
 * @author adrianodib
 *
 */
@Entity
@Audited
@Table(name = "SEC_GRANT")
@IdClass(SecGrantPK.class)
public class SecGrant implements Serializable {

	private static final long serialVersionUID = -6709537490220540147L;

  @Id
  @Column(columnDefinition = "BINARY(32)", name = "ID_GRANT", nullable = false)
	private byte[] idGrant;
  @Id
  @Column(name = "CD_VER_GRANT", nullable = false)
	private long versao;  
  @Id
  @Column(name = "ID_PRODUCT", nullable = false)
	private int idProduct;
	
	@Transient
	private String idGrantString;
	
	private String dsGrant;
	private String dsCompGrant;
	private String dsName;
	private boolean isSystemRegistry;	

	public SecGrant() {	}
	
	/*@ManyToMany
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@JoinTable(name="sec_grant_target", joinColumns={@JoinColumn(name="id_Grant"), @JoinColumn(name="cd_Ver_Grant"),@JoinColumn(name="id_Product")}, 
	   inverseJoinColumns={@JoinColumn(name="id_Target"),@JoinColumn(name="id_Product")
	})
	private List<SecTarget> secTargetList;*/
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", nullable=false, insertable=false ,updatable=false)
	public SecProduct product;

/*
	@ManyToOne
	@JsonIgnore
	public SecRole secRoleList;*/
	
	public SecProduct getProduct() {
		return product;
	}

	public void setProduct(SecProduct product) {
		this.product = product;
	}	
	
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

	/*public List<SecTarget> getSecTargetList() {
		return secTargetList;
	}

	public void setSecTargetList(List<SecTarget> secTargetList) {
		this.secTargetList = secTargetList;
	}*/

	/*public SecRole getSecRoleList() {
		return secRoleList;
	}

	public void setSecRoleList(SecRole secRoleList) {
		this.secRoleList = secRoleList;
	}*/

	public String getIdGrantString() {
		if (this.idGrantString == null) {
      if(this.idGrant != null) {
        this.idGrantString = new String(this.idGrant);
      }
    }
		return idGrantString;
	}

	public void setIdGrantString(String idGrantString) {
		this.idGrantString = idGrantString;
		this.idGrant = this.idGrantString.getBytes();
	}
	
  public byte[] getIdGrant() {
    return idGrant;
  }

  public void setIdGrant(byte[] idGrant) {
      this.idGrant = idGrant;
      this.idGrantString = new String(idGrant);	
  }

  public long getVersao() {
		return versao;
	}

	public void setVersao(long versao) {
		this.versao = versao;
	}

	public String getDsCompGrant() {
		return dsCompGrant;
	}

	public void setDsCompGrant(String dsCompGrant) {
		this.dsCompGrant = dsCompGrant;
	}

	public boolean isSystemRegistry() {
		return isSystemRegistry;
	}

	public void setSystemRegistry(boolean isSystemRegistry) {
		this.isSystemRegistry = isSystemRegistry;
	}

}