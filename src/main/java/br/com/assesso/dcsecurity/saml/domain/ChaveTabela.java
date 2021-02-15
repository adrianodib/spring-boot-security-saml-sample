package br.com.assesso.dcsecurity.saml.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class ChaveTabela implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(columnDefinition = "BINARY(32)", name = "ID", nullable = false)
  private byte[] id;

  @Transient
  private String idString;

  @Column(columnDefinition = "NUMERIC(10)", name = "VL_VERSAO")
  private Long versao;

  @JsonIgnore
  public byte[] getId() {
    return id;
  }

  public void setId(byte[] id) {
    this.id = id;
    this.idString = new String(id);
  }

  public String getIdString() {
    if (this.idString == null) {
      if(this.id != null) {
        this.idString = new String(this.id);
      }
    }
    return idString;
  }

  public void setIdString(String idString) {
    this.idString = idString;
    this.id = idString.getBytes();
  }

  public Long getVersao() {
    return this.versao;
  }

  public void setVersao(Long versao) {
    this.versao = versao;
  }

  public ChaveTabela() {

  }

  public ChaveTabela(byte[] id, Long versao) {
    super();
    this.id = id;
    this.versao = versao;
  }
}
