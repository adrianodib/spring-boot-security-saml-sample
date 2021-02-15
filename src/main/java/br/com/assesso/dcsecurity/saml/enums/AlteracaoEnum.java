package br.com.assesso.dcsecurity.saml.enums;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AlteracaoEnum {
	
	// *******************************************************************************************************
	// ATENÇÃO: não alterar a ordem dos enumeradores devido a persistência ser realizada pelo ordinal do enum
	// *******************************************************************************************************
	
	INSERCAO  ("Inserção"),  // 0
	DELECAO   ("Deleção"),   // 1
	ALTERACAO ("Alteração"), // 2
	CRIACAO   ("Criação");   // 3
	
	private String description;	
	
	private AlteracaoEnum(String description) {
		this.description = description;
	}
	
	@JsonValue
	public Integer getValue() {
		return this.ordinal();	
	}	
	
	@JsonCreator
	public static AlteracaoEnum forValue(String value) {
		for (AlteracaoEnum en : AlteracaoEnum.values()) {
			if (value.equals(String.valueOf(en.ordinal()))) {
				return en;
			}
		}
		
		throw new EnumConstantNotPresentException(AlteracaoEnum.class, value);
	}	
	
	public static Map<Integer, String> getEnumMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (AlteracaoEnum en : AlteracaoEnum.values()) {
			map.put(en.ordinal(), en.description);
		}
		return map;
	}		
}