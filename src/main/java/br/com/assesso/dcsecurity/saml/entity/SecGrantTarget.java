package br.com.assesso.dcsecurity.saml.entity;

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
 * @author ldoi
 *
 */
@Entity
@Audited
@Table(name = "SEC_GRANT_TARGET", catalog = "")
@IdClass(SecGrantTargetPK.class)
public class SecGrantTarget {

	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_GRANT", nullable = false)
	private byte[] idGrant;
	@Id
  @Column(name = "CD_VER_GRANT", nullable = false)
	private long versao;
	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_TARGET", nullable = false)
	private byte[] idTarget;
	@Id
	@Column(name = "ID_PRODUCT", nullable = false)
	private int idProduct;
	
	@Transient
	private String idGrantString;
	@Transient
	private String idTargetString;
	
	private boolean isReadonly;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", nullable=false, insertable=false ,updatable=false)
	public SecProduct product;
	
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
	
	public byte[] getIdTarget() {
		return idTarget;
	}
	
	public void setIdTarget(byte[] idTarget) {
		this.idTarget = idTarget;
		this.idTargetString = new String(idTarget);
	}
	
	public int getIdProduct() {
		return idProduct;
	}
	
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	public SecProduct getProduct() {
		return product;
	}
	
	public void setProduct(SecProduct product) {
		this.product = product;
	}
	
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
		this.idGrant = idGrantString.getBytes();
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

	public boolean isReadonly() {
		return isReadonly;
	}

	public void setReadonly(boolean isReadonly) {
		this.isReadonly = isReadonly;
	}

}