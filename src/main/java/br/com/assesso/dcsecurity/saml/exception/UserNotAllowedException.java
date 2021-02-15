package br.com.assesso.dcsecurity.saml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Operação não permitida para este usuário.")
public class UserNotAllowedException extends Exception {
	private static final long serialVersionUID = 100L;
}
