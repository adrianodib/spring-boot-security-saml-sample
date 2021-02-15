package br.com.assesso.dcsecurity.saml.exception;

/**
 * Excecao em tempo de execucao lancada pelo NotificacaoInterface. Quando houver excecao deste tipo
 * eh que existe alguma falha na logica da aplicacao.
 * 
 * @author Helio Mise
 *
 */
public class NotificacaoRuntimeException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NotificacaoRuntimeException() {
    super();
  }

  public NotificacaoRuntimeException(String message) {
    super(message);
  }

  public NotificacaoRuntimeException(Throwable cause) {
    super(cause);
  }

  public NotificacaoRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }
}
