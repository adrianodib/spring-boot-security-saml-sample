package br.com.assesso.dcsecurity.saml.email;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.assesso.adf.mail.MailAddress;
import br.com.assesso.adf.mail.MailMessage;
import br.com.assesso.adf.mail.MailerException;
import br.com.assesso.adf.mail.MailerService;
import br.com.assesso.adf.mail.MailerServiceLocator;
import br.com.assesso.adf.mail.SimpleMessage;
import br.com.assesso.adf.sms.Cell;
import br.com.assesso.adf.sms.SmsService;
import br.com.assesso.adf.sms.SmsServiceException;
import br.com.assesso.adf.sms.SmsServiceLocator;
import br.com.assesso.adf.tts.TtsService;
import br.com.assesso.adf.tts.TtsServiceException;
import br.com.assesso.adf.tts.TtsServiceLocator;
import br.com.assesso.dcsecurity.saml.exception.NotificacaoException;
import br.com.assesso.dcsecurity.saml.exception.NotificacaoRuntimeException;
import br.com.assesso.dcsecurity.saml.email.to.ContactTO;
import br.com.assesso.dcsecurity.saml.email.to.UserTO;
import br.com.assesso.dcsecurity.saml.utils.Constantes;



public class NotificacaoService {

  public static final Log LOG = LogFactory.getLog(NotificacaoService.class);

  private String assunto;
  private String mensagem;
  private MailerService mailerService;
  private SmsService smsService;
  private TtsService ttsService;

  /**
   * Inicializa
   *
   * @param assunto
   * @param mensagem
   */
  private void initialize(String assunto, String mensagem) {
    this.setAssunto(assunto);
    this.setMensagem(mensagem);
  }

  /**
   * Construtor
   *
   * @param assunto
   * @param mensagem
   */
  public NotificacaoService(String assunto, String mensagem) {
    super();
    this.initialize(assunto, mensagem);
  }

  public String getAssunto() {
    return this.assunto;
  }

  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  public String getMensagem() {
    return this.mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  private MailerService getMailerService() {
    if (this.mailerService == null) {
      this.mailerService = MailerServiceLocator.getIntance().getMailer();
    }
    return this.mailerService;
  }

  public SmsService getSmsService() {
    if (this.smsService == null) {
      this.smsService = SmsServiceLocator.getInstance().getService();
    }
    return this.smsService;
  }

  private TtsService getTtsService() {
    if (this.ttsService == null) {
      this.ttsService = TtsServiceLocator.getInstance().getService();
    }
    return this.ttsService;
  }

  private void adicionaContatoEmail(String email, String nome) {
    this.getMailerService().addRecipients(new MailAddress(email, nome));
  }

  private void adicionaContatoSms(String numero, String nome) {
    this.getSmsService().addRecipients(new Cell(numero, nome));
  }

  private void adicionaContatoTts(String numero, String nome) {
    this.getTtsService().addRecipients(new Cell(numero, nome));
  }

  /**
   * Metodo para notificar Usuarios.
   *
   * @param usuarios
   *
   * @return {@link void}
   *
   * @throws NotificacaoException
   * @throws NotificacaoRuntimeException
   */
  public void notifica(List<UserTO> usuarios) throws NotificacaoException, NotificacaoRuntimeException {
    if(LOG.isDebugEnabled()) {
      LOG.debug(this.getClass().getName() + ".notifica -> INICIO");
    }

    try {
      for (UserTO userTO : usuarios) {
        List<ContactTO> contatos = userTO.getListContactTO();
        for (ContactTO contactTO : contatos) {
          if (!contactTO.isNotify()) {
            continue;
          }

          if (Constantes.TIPO_CONTATO_POR_EMAIL.equals(contactTO.getType())) {
            this.adicionaContatoEmail(contactTO.getValue(), userTO.getName());
          } else if (Constantes.TIPO_CONTATO_POR_CELULAR_SMS.equals(contactTO.getType())) {
            this.adicionaContatoSms(contactTO.getValue(), userTO.getName());
          } else if (Constantes.TIPO_CONTATO_POR_CELULAR_TTS.equals(contactTO.getType())) {
            this.adicionaContatoTts(contactTO.getValue(), userTO.getName());
          } 
        }
      }

      // Envio 
      this.enviaEmail();
      this.enviaSms();
      this.enviaTts();
      


    } catch (Exception e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro nao mapeado ao notificar Usuarios:\n" + e);
      }
    }

    return;
  }

  /**
   * Metodo para disparar envio de e-mails.
   *
   * @return {@link void}
   *
   * @throws NotificacaoException
   * @throws NotificacaoRuntimeException
   */
  private void enviaEmail() throws Exception, RuntimeException {
    if(LOG.isDebugEnabled()) {
      LOG.debug(this.getClass().getName() + ".enviaEmail -> INICIO");
    }

    try {
      if (this.mailerService == null) {
        return;
      }

      this.getMailerService().setSubject(this.getAssunto());

      String mensagem = "<pre>" + this.getMensagem() + "</pre>";
      MailMessage mailMessage = new SimpleMessage(mensagem);

      this.getMailerService().send(mailMessage);

    } catch (MailerException e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro ao disparar envio de e-mails:\n" + e.getMessage());
      }
    } catch (Exception e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro nao mapeado ao disparar envio de e-mails:\n" + e.getMessage());
      }
    } finally {
      if(LOG.isDebugEnabled()) {
        LOG.debug(this.getClass().getName() + ".enviaEmail -> FIM");
      }
    }

    return;
  }

  /**
   * Metodo para disparar envio de SMSs.
   *
   * @return {@link void}
   *
   * @throws NotificacaoException
   * @throws NotificacaoRuntimeException
   */
  private void enviaSms() throws Exception, RuntimeException {
    if(LOG.isDebugEnabled()) {
      LOG.debug(this.getClass().getName() + ".enviaSms -> INICIO");
    }

    try {
      if (this.smsService == null) {
        return;
      }

      this.getSmsService().setMessage(this.getAssunto());
      this.getSmsService().send();

    } catch (SmsServiceException e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro ao disparar envio de SMSs:\n" + e.getMessage());
      }
    } catch (Exception e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro ao disparar envio de SMSs:\n" + e.getMessage());
      }
    } finally {
      if(LOG.isDebugEnabled()) {
        LOG.debug(this.getClass().getName() + ".enviaSms -> FIM");
      }
    }

    return;
  }

  public void enviaSmsCompleto(String mensagem) throws Exception, RuntimeException {
	  if(LOG.isDebugEnabled()) {
		  LOG.debug(this.getClass().getName() + ".enviaSms -> INICIO");
	  }
	  
	  try {
		  if (this.smsService == null) {
			  return;
		  }
		  
		  this.getSmsService().setMessage(mensagem);
		  this.getSmsService().send();
		  
	  } catch (SmsServiceException e) {
		  if (LOG.isErrorEnabled()) {
			  LOG.error("Erro ao disparar envio de SMSs:\n" + e.getMessage());
		  }
	  } catch (Exception e) {
		  if (LOG.isErrorEnabled()) {
			  LOG.error("Erro ao disparar envio de SMSs:\n" + e.getMessage());
		  }
	  } finally {
		  if(LOG.isDebugEnabled()) {
			  LOG.debug(this.getClass().getName() + ".enviaSms -> FIM");
		  }
	  }
	  
	  return;
  }

  /**
   * Metodo para disparar envio de TTSs.
   *
   * @return {@link void}
   *
   * @throws NotificacaoException
   * @throws NotificacaoRuntimeException
   */
  private void enviaTts() throws Exception, RuntimeException {
    if(LOG.isDebugEnabled()) {
      LOG.debug(this.getClass().getName() + ".enviaTts -> INICIO");
    }

    try {
      if (this.ttsService == null) {
        return;
      }

      this.getTtsService().setMessage(this.getAssunto());
      this.getTtsService().send();

    } catch (TtsServiceException e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro ao disparar envio de TTSs:\n" + e.getMessage());
      }
    } catch (Exception e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro ao disparar envio de TTSs:\n" + e.getMessage());
      }
    } finally {
      if(LOG.isDebugEnabled()) {
        LOG.debug(this.getClass().getName() + ".enviaTts -> FIM");
      }
    }

    return;
  }

  /**
   * Metodo para verificar Status de uma Chave de Notificacao (Usuario).
   *
   * @param chaveNotificacao
   * @param tipoContato
   *
   * @return {@link int}
   *
   * @throws NotificacaoException
   * @throws NotificacaoRuntimeException
   */
  public int statusChaveNotificacao(String chaveNotificacao, String tipoContato) throws Exception, RuntimeException {
    if(LOG.isDebugEnabled()) {
      LOG.debug(this.getClass().getName() + ".statusChaveNotificacao -> INICIO");
    }

    int retorno = Constantes.RET_WKF_ERRO;

    try {
      if (MailerService.TIPO_SERVICO.equals(tipoContato)) {
        this.getMailerService().status(chaveNotificacao);
      } else if (SmsService.TIPO_SERVICO.equals(tipoContato)) {
        retorno = this.getSmsService().status(chaveNotificacao);
      } else if (TtsService.TIPO_SERVICO.equals(tipoContato)) {
        retorno = this.getTtsService().status(chaveNotificacao);
      } 

    } catch (RuntimeException e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro ao verificar Status de uma Chave de Notificacao (Usuario):\n" + e);
      }
      throw new RuntimeException(e);
    } catch (Exception e) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Erro nao mapeado ao verificar Status de uma Chave de Notificacao (Usuario):\n" + e);
      }
      throw new Exception(e);
    } finally {
      if(LOG.isDebugEnabled()) {
        LOG.debug(this.getClass().getName() + ".statusChaveNotificacao -> FIM");
      }
    }

    return retorno;
  }
}