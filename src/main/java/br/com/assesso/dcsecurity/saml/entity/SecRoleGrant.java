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
@Table(name = "SEC_ROLE_GRANT", catalog = "")
@IdClass(SecRoleGrantPK.class)
public class SecRoleGrant {

	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_ROLE", nullable = false)
	private byte[] idRole;
	@Id
	@Column(name = "CD_VER_ROLE", nullable = false)
	private long versaoRole;
	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_GRANT", nullable = false)
	private byte[] idGrant;
	@Id
	@Column(name = "CD_VER_GRANT", nullable = false)
	private long versaoGrant;	
	@Id
	@Column(name = "ID_PRODUCT", nullable = false)
	private int idProduct;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", nullable=false, insertable=false ,updatable=false)
	public SecProduct product;
	
	@Transient
	private String idRoleString;
	@Transient
	private String idGrantString;

	public byte[] getIdRole() {
		return idRole;
	}

	public void setIdRole(byte[] idRole) {
		this.idRole = idRole;
		this.idRoleString = new String(idRole);
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
		this.idGrantString = new String(idGrant);
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

	public SecProduct getProduct() {
		return product;
	}

	public void setProduct(SecProduct product) {
		this.product = product;
	}

	public String getIdRoleString() {
		if (this.idRoleString == null) {
      if(this.idRole != null) {
        this.idRoleString = new String(this.idRole);
      }
    }
		return idRoleString;
	}

	public void setIdRoleString(String idRoleString) {
		this.idRoleString = idRoleString;
		this.idRole = idRoleString.getBytes();
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

}