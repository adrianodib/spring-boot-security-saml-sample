package br.com.assesso.dcsecurity.saml.dto;

import br.com.assesso.dcsecurity.saml.domain.ChaveTabela;

public class ChaveDTOImpl extends ChaveDTO {

	private static final long serialVersionUID = 1L;

	public ChaveDTOImpl() {	}

	public ChaveDTOImpl(String id, Long versao) {
		super.setIdString(id);
		super.setVersao(versao);
	}

	public ChaveDTOImpl(ChaveTabela chave) {
		super.setIdString(chave.getIdString());
		super.setVersao(chave.getVersao());
	}

}
