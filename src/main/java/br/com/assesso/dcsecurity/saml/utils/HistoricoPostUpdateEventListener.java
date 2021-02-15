package br.com.assesso.dcsecurity.saml.utils;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl;
import org.hibernate.event.spi.PostUpdateEvent;

import br.com.assesso.dcsecurity.saml.domain.EntityBase;

public class HistoricoPostUpdateEventListener extends EnversPostUpdateEventListenerImpl {

	private static final long serialVersionUID = 1L;

  public HistoricoPostUpdateEventListener(EnversService enversService) {
    super(enversService);
  }

  @Override
  public void onPostUpdate(PostUpdateEvent event) {
     if (event.getEntity() instanceof EntityBase && ((EntityBase) event.getEntity()).getChave().getVersao() != 0) {
       /* Nao insere nas tabelas de auditoria quando */ 
       return;
     }
    super.onPostUpdate(event);    
  }
}
