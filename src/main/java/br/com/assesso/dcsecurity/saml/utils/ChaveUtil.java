package br.com.assesso.dcsecurity.saml.utils;

import java.util.UUID;

import org.springframework.util.StringUtils;

import br.com.assesso.dcsecurity.saml.domain.ChaveTabela;
import br.com.assesso.dcsecurity.saml.dto.ChaveDTO;
import br.com.assesso.dcsecurity.saml.dto.ChaveDTOImpl;

public class ChaveUtil {

	private ChaveUtil() {
		super();
	}

	public static String executa() {
		String retorno = "";
		String uuid = UUID.randomUUID().toString();
		retorno = uuid.substring(14, 18).concat(uuid.substring(9, 13)).concat(uuid.substring(0, 8))
				.concat(uuid.substring(19, 23)).concat(uuid.substring(24));
		return retorno;
	}

	public static String trataId(String id) {
		if (StringUtils.isEmpty(id)) {
			return ChaveUtil.executa();
		} else {
			return id;
		}
	}

	public static Long trataVersao(Long versao) {
		if (StringUtils.isEmpty(versao)) {
			return 0L;
		} else {
			return versao;
		}
	}

	public static ChaveTabela trataChave(String id, Long versao) {
		return trataChave(new ChaveDTOImpl(id, versao));
	}

	public static ChaveTabela trataChave(ChaveDTO chaveDTO) {
		ChaveTabela chave = new ChaveTabela();
		if (chaveDTO == null) {
			chaveDTO = new ChaveDTOImpl();
		}

		chave.setIdString(trataId(chaveDTO.getIdString()));
		chave.setVersao(trataVersao(chaveDTO.getVersao()));

		return chave;
	}

	public static ChaveDTOImpl trataChave(ChaveTabela chave) {
		ChaveDTOImpl chaveDTO = new ChaveDTOImpl();
		if (chave == null) {
			return null;
		}

		if (!StringUtils.isEmpty(chave.getIdString())) {
			chaveDTO.setIdString(chave.getIdString());
		}

		if (!StringUtils.isEmpty(chave.getVersao())) {
			chaveDTO.setVersao(chave.getVersao());
		}

		return chaveDTO;
	}

}