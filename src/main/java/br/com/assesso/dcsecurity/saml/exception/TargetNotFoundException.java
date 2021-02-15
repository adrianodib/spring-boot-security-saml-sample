package br.com.assesso.dcsecurity.saml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Target não encontrada.")
public class TargetNotFoundException extends Exception {
	private static final long serialVersionUID = 100L;
}
