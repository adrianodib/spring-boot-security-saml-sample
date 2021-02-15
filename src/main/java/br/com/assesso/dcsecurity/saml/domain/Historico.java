package br.com.assesso.dcsecurity.saml.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import br.com.assesso.dcsecurity.saml.utils.HistoricoListener;

@Entity
@RevisionEntity(HistoricoListener.class)
@Table(name = "SEC_HISTORICO")
public class Historico {

  @Id
  @GeneratedValue(generator = "SEC_SEQ_HISTORIC", strategy = GenerationType.SEQUENCE)
  @Column(name = "SEQ_HISTORICO", length = 8, nullable = false)
  @RevisionNumber
  private Long sequenciaHistorico;

  @RevisionTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DT_EVENTO")
  private Date timestamp;

  @Column(name = "CD_USUARIO")
  private Long codigoUsuario;

  @Column(name = "DS_EMAIL_USUARIO")
  private String emailUsuario;

  @Column(name = "NM_USUARIO")
  private String nomeUsuario;

  @Column(name = "DS_ENTIDADE_ID")
  private String entidadeID;
  
  @Column(name = "VL_IP")
  private String ip;

  @Column(columnDefinition = "BINARY(32)", name = "ID_CHAVE")
  private byte[] id;
  
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Long getSequenciaHistorico() {
    return sequenciaHistorico;
  }

  public void setSequenciaHistorico(Long sequenciaHistorico) {
    this.sequenciaHistorico = sequenciaHistorico;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Long getCodigoUsuario() {
    return codigoUsuario;
  }

  public void setCodigoUsuario(Long codigoUsuario) {
    this.codigoUsuario = codigoUsuario;
  }

  public String getEmailUsuario() {
    return emailUsuario;
  }

  public void setEmailUsuario(String emailUsuario) {
    this.emailUsuario = emailUsuario;
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public byte[] getId() {
    return id;
  }

  public void setId(byte[] id) {
    this.id = id;
  }

	public String getEntidadeID() {
		return entidadeID;
	}

	public void setEntidadeID(String entidadeID) {
		this.entidadeID = entidadeID;
	}
  
  

}
