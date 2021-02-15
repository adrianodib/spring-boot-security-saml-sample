package br.com.assesso.dcsecurity.saml.utils;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;

import br.com.assesso.dcsecurity.saml.domain.EntityBase;

public class HistoricoPostInsertEventListener extends EnversPostInsertEventListenerImpl {

	private static final long serialVersionUID = 1L;

  public HistoricoPostInsertEventListener(EnversService enversService) {
    super(enversService);
  }

  @Override
  public void onPostInsert(PostInsertEvent event) {
    if (event.getEntity() instanceof EntityBase && ((EntityBase) event.getEntity()).getChave().getVersao() != 0) {
      /* Nao insere nas tabelas de auditoria quando */
      return;
    }
    super.onPostInsert(event);
  }
}
