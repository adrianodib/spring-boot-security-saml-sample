package br.com.assesso.dcsecurity.saml.utils;

import java.util.UUID;

/**
 * Gera um UUID no padrão da Assesso
 * @author adrianodib
 *
 */
public class GerarID {

	public static String executa() {
		String retorno = "";
		String uuid = UUID.randomUUID().toString();
		retorno = uuid.substring(14, 18).concat(uuid.substring(9, 13)).concat(uuid.substring(0, 8))
				.concat(uuid.substring(19, 23)).concat(uuid.substring(24));
		return retorno;
	}

}
