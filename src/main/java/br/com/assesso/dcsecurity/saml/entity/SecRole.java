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
 * Role = papel
 * @author adrianodib
 *
 */
@Entity
@Audited
@Table(name = "SEC_ROLE")
@IdClass(SecRolePK.class)
public class SecRole implements Serializable{

	private static final long serialVersionUID = 2776003715985753036L;

	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_ROLE", nullable = false)
	private byte[] idRole;
	
	@Id
	@Column(name = "CD_VER_ROLE", nullable = false)
	private long versao;
	
	@Id
	@Column(name = "ID_PRODUCT", nullable = false)
	private int idProduct;
	
	@Transient
	private String idRoleString;
	
	private String dsRole;
	private String dsCompRole;
	private String dsName;
	private boolean isSystemRegistry;	
	
	public SecRole() {}

	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", nullable=false, insertable=false ,updatable=false)
	public SecProduct product;
	
	public SecProduct getProduct() {
		return product;
	}

	public void setProduct(SecProduct product) {
		this.product = product;
	}	
	public String getDsRole() {
		return dsRole;
	}
		
	public byte[] getIdRole() {
		return idRole;
	}

	public void setIdRole(byte[] idRole) {
		this.idRole = idRole;
		this.idRoleString = new String(idRole);
	}

	public long getVersao() {
		return versao;
	}

	public void setVersao(long versao) {
		this.versao = versao;
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

	public boolean isSystemRegistry() {
		return isSystemRegistry;
	}

	public void setSystemRegistry(boolean isSystemRegistry) {
		this.isSystemRegistry = isSystemRegistry;
	}
	
}