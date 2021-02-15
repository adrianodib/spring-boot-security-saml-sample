package br.com.assesso.dcsecurity.saml.utils;

/**
 * Classe base que contem as constantes utilizadas no workflow.
 *
 * @author Helio Mise
 *
 */
public final class Constantes {

  /* Constantes */
	 public static final int VERSAO_EDICAO = 0;
	 
	 public static final String STATUS_ATIVO = "A";
	 public static final String STATUS_INATIVO = "I";
	 public static final String STATUS_BLOQUEADO = "B";
	 
	 public static final int TIPO_NOTIFICACAO_2FA_EMAIL = 0; 
	 public static final int TIPO_NOTIFICACAO_2FA_CELULAR = 1;
	 
	 /** Codigo de Retorno para erro generalizado do Workflow
	  *  <ul>
	  *    <li>Erro generalizado do Workflow.</li>
	  *  <ul>
	  */
	  public static final int RET_WKF_ERRO = 999;
	  
 
  /* Codigo da aplicacao para lookup do datasource */
  public static final String CODIGO_ASI = "ASI";

  public static final String APP = "APP";
  public static final String PRD = "PRD";
  public static final String UST = "ust";
  public static final String URLS = "urls";

  public static final String SEC_MSG_ERRO = "msg";
  public static final String SEC_MSG_SUCESSO = "msgSuc";
  public static final String SEC_MSG_GENERICO = "msgText";

  /* Codigo da aplicacao DEFAULT = ASI */
  public static final String PRD_ASI = "ASI";
  public static final String APP_ASI = "ASI";

   /* Nome do arquivo de bundle */
  public static final String NOME_ARQUIVO_BUNDLE = "MessageResourcesASI";
  public static final String NOME_BUNDLE_TEMPLATE = "TemplateFiles";

  /* Nome das p�ginas de login, troca de senha, menu e mensagem de erro */
  public static final String NOME_PAGINA_LOGIN = "/sec_loginform.jsp";
  public static final String NOME_PAGINA_TROCA_SENHA = "/sec_passform.jsp";
  public static final String NOME_PAGINA_ESQUECI_SENHA = "/sec_forgotpass.jsp";
  public static final String NOME_PAGINA_MENU = "/sec_menu.jsp";
  public static final String NOME_PAGINA_MSG_ERRO = "/msgPage.jsp";

  /* Lista de acoes */
  public static final String ACAO_INCLUIR = "incluir";
  public static final String ACAO_ALTERAR = "alterar";

  /* Targets */
  public static final String VALUE_ALL_TARGETS = "ALL_TARGETS";

  /* Tipos de identificacao de usuarios (usuario, perfil, outros) */
  public static final String TIPO_IDENTIFICACAO_POR_USUARIO = "USUARIO";
  public static final String TIPO_IDENTIFICACAO_POR_PERFIL = "PERFIL";

  /* Tipos de contato do usuario */
  public static final String TIPO_CONTATO_POR_EMAIL = "EMAIL";
  public static final String TIPO_CONTATO_POR_CELULAR_SMS = "SMS"; //TODO: Definicao inicial SMS, nao haveria outra forma de uso
  public static final String TIPO_CONTATO_POR_CELULAR_TTS = "TTS"; //TODO: Definicao adicional TTS
}
