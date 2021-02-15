package br.com.assesso.dcsecurity.saml.utils;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversListenerDuplicationStrategy;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class HistoricoIntegrator implements Integrator {
	@Override
	public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
		final EnversService  enversService = serviceRegistry.getService(EnversService.class);
		final EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);
		listenerRegistry.addDuplicationStrategy(EnversListenerDuplicationStrategy.INSTANCE);
		if (enversService.getEntitiesConfigurations().hasAuditedEntities()) {
			 listenerRegistry.appendListeners(EventType.POST_DELETE, new EnversPostDeleteEventListenerImpl(enversService));
			 listenerRegistry.appendListeners(EventType.POST_INSERT, new HistoricoPostInsertEventListener(enversService));
			 listenerRegistry.appendListeners(EventType.POST_UPDATE, new EnversPostUpdateEventListenerImpl(enversService));
			 listenerRegistry.appendListeners(EventType.PRE_UPDATE, new HistoricoPreUpdateEventListener(enversService));
			 listenerRegistry.appendListeners(EventType.POST_UPDATE, new HistoricoPostUpdateEventListener(enversService));
		}
	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
		// TODO Auto-generated method stub
		
	}
}
