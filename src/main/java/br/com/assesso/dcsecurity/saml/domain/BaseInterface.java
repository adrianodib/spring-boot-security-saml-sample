package br.com.assesso.dcsecurity.saml.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=EntityBase.class)
public interface BaseInterface {

  public abstract String getId();
  
  public abstract void setId(String id);
  
  public abstract Long getVersao();
  
  public abstract void setVersao(Long versao);

  @JsonProperty(value="Chave")
  ChaveTabela getChave();

  void setChave(ChaveTabela chave);
  
}
