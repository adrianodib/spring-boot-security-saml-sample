package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Entity
@Audited
@Table(name = "SEC_PRODUCT")
public class SecProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCT", nullable = false)
	private int idProduct;
	
	private String dsProduct;

	public SecProduct() {}
	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getDsProduct() {
		return dsProduct;
	}

	public void setDsProduct(String dsProduct) {
		this.dsProduct = dsProduct;
	}

	
}
