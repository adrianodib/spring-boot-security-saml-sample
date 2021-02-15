package br.com.assesso.dcsecurity.saml.exception;

/**
 * Excecao padrao lancada pelo NotificacaoInterface. Esta excecao deve ser tratada.
 * 
 * @author Helio Mise
 *
 */
public class NotificacaoException extends Exception {

  private static final long serialVersionUID = 1L;

  public NotificacaoException() {
    super();
  }

  public NotificacaoException(String message) {
    super(message);
  }

  public NotificacaoException(Throwable cause) {
    super(cause);
  }

  public NotificacaoException(String message, Throwable cause) {
    super(message, cause);
  }
}
