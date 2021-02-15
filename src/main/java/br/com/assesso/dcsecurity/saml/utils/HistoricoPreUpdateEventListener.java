package br.com.assesso.dcsecurity.saml.utils;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPreUpdateEventListenerImpl;
import org.hibernate.event.spi.PreUpdateEvent;

import br.com.assesso.dcsecurity.saml.domain.EntityBase;

public class HistoricoPreUpdateEventListener extends EnversPreUpdateEventListenerImpl {

	private static final long serialVersionUID = 1L;

  public HistoricoPreUpdateEventListener(EnversService enversService) {
    super(enversService);
  }

  @Override
  public boolean onPreUpdate(PreUpdateEvent event) {
     if (event.getEntity() instanceof EntityBase && ((EntityBase) event.getEntity()).getChave().getVersao() != 0) {
       /* Nao insere nas tabelas de auditoria quando */ 
       return false;
     } 
     return super.onPreUpdate(event);
  }

}
