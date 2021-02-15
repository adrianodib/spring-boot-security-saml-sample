package br.com.assesso.dcsecurity.saml.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@Table(name = "SEC_USER_APP", catalog = "")
@IdClass(SecUserAppPK.class)
public class SecUserApp {

	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_ROLE", nullable = false)
	private byte[] idRole;
	@Id
	@Column(name = "CD_VER_ROLE", nullable = false)
	private long versao;
	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_USER", nullable = false)
	private byte[] idUser;
	@Id
	@Column(columnDefinition = "BINARY(32)", name = "ID_APP", nullable = false)
	private byte[] idApp;
	@Id
	@Column(name = "ID_PRODUCT", nullable = false)
	private int idProduct;
	private String status;

	@ManyToOne	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)	
	@JoinColumn(name="ID_PRODUCT", nullable=false, insertable=false,updatable=false) 
	public SecProduct product;
	

	@ManyToOne
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@JoinColumn(name = "ID_PRODUCT", nullable = false, insertable = false, updatable = false)
	@JoinColumn(name = "ID_ROLE", nullable = false, insertable = false, updatable = false)
	@JoinColumn(name = "CD_VER_ROLE", nullable = false, insertable = false, updatable = false)
	public SecRole role;

	@ManyToOne
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@JoinColumn(name = "ID_APP", nullable = false, insertable = false, updatable = false)
	@JoinColumn(name = "ID_PRODUCT", nullable = false, insertable = false, updatable = false)
	public SecApp app;

	@JsonIgnore
	@ManyToOne()	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@JoinColumn(name = "ID_USER", insertable = false, updatable = false)
	public SecUser user;

	@JsonIgnore
	public SecUser getUser() {
		return user;
	}

	public void setUser(SecUser user) {
		this.user = user;
	}

	public byte[] getIdRole() {
		return idRole;
	}

	public void setIdRole(byte[] idRole) {
		this.idRole = idRole;
	}

	public byte[] getIdUser() {
		return idUser;
	}

	public void setIdUser(byte[] idUser) {
		this.idUser = idUser;
	}

	public byte[] getIdApp() {
		return idApp;
	}

	public void setIdApp(byte[] idApp) {
		this.idApp = idApp;
	}

	public long getVersao() {
		return versao;
	}

	public void setVersao(long versao) {
		this.versao = versao;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public SecProduct getProduct() { 
		return product; 
	}
	
	public void setProduct(SecProduct product) { 
		this.product = product; 
	}
	

	public SecRole getRole() {
		return role;
	}

	public void setRole(SecRole role) {
		this.role = role;
	}

	public SecApp getApp() {
		return app;
	}

	public void setApp(SecApp app) {
		this.app = app;
	}

}