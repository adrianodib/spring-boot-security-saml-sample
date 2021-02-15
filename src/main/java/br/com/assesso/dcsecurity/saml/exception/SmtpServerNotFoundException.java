package br.com.assesso.dcsecurity.saml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Configuração do servidor SMTP não encontrada.")
public class SmtpServerNotFoundException extends Exception {
	private static final long serialVersionUID = 100L;
}
