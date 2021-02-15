package br.com.assesso.dcsecurity.saml.domain;

import java.io.Serializable;

import br.com.assesso.dcsecurity.saml.utils.GerarID;


public class EntityBase implements Serializable, BaseInterface {

	private static final long serialVersionUID = 1L;

	public EntityBase() {
		if (this.getChave() == null)
			this.setChave(new ChaveTabela());
		if (this.getChave().getIdString() == null || this.getChave().getIdString() == "") {
			this.getChave().setIdString(GerarID.executa());
		}
	}

	private ChaveTabela chave;

	public ChaveTabela getChave() {
		return chave;
	}

	public void setChave(ChaveTabela chave) {
		this.chave = chave;
	}

	@Override
	public String getId() {
		return getChave().getIdString();
	}

	@Override
	public void setId(String id) {
		getChave().setIdString(id);
	}

	@Override
	public Long getVersao() {
		return getChave().getVersao();
	}

	@Override
	public void setVersao(Long codigoVersao) {
		getChave().setVersao(codigoVersao);
	}

}
