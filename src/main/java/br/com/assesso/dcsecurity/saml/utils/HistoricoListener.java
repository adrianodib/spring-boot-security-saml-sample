package br.com.assesso.dcsecurity.saml.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.envers.RevisionListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.assesso.dcsecurity.saml.domain.Historico;

public class HistoricoListener implements RevisionListener {
  @Override
  public void newRevision(Object objetoRevisao) {
    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    HttpServletRequest request = attr.getRequest();
    
    String codigo = request.getHeader("Usuario-Codigo");
    String nome = request.getHeader("Username");
    String email = request.getHeader("Usuario-Email");
    String ip = request.getHeader("Usuario-IP");
    String entidade = request.getHeader("Entidade-Chave");
    String id = request.getHeader("Id-Chave");

    Historico revisao = (Historico) objetoRevisao;
    revisao.setCodigoUsuario(Long.parseLong(codigo == null ? "0" : codigo));
    revisao.setNomeUsuario(nome);
    revisao.setEmailUsuario(email);
    revisao.setTimestamp(new Date());
    revisao.setIp(ip);
    revisao.setEntidadeID(entidade);
    revisao.setId(id.getBytes());
  }
}
