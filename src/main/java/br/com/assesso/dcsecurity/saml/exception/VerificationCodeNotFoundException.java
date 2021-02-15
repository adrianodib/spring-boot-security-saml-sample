package br.com.assesso.dcsecurity.saml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Token não encontrado.")
public class VerificationCodeNotFoundException extends Exception {
	private static final long serialVersionUID = 100L;
}
