package br.com.assesso.dcsecurity.saml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.assesso.dcsecurity.saml.domain.ChaveTabela;
import br.com.assesso.dcsecurity.saml.entity.SecGrantTarget;

public interface SecGrantTargetRepository extends JpaRepository<SecGrantTarget, ChaveTabela>{
	
	@Query(value = "SELECT A.* "			
			+ "FROM SEC_GRANT_TARGET A "
			+ "WHERE A.ID_GRANT = ?1 AND A.CD_VER_GRANT = ?2 AND A.ID_TARGET = ?3 AND A.ID_PRODUCT = ?4 ", nativeQuery = true)

		SecGrantTarget findByChave ( @Param("idGrant") byte[] idGrant, @Param("versao") long versao, @Param("idTarget") byte[] idTarget, @Param("idProduct") int idProduct);  


	@Query(value = "SELECT A.* "			
			+ "FROM SEC_GRANT_TARGET A "
			+ "WHERE A.CD_VER_GRANT = ?1 AND A.ID_TARGET = ?2 AND A.ID_PRODUCT = ?3 ", nativeQuery = true)

		SecGrantTarget findByIdVersaoIdTargetIdProduct ( @Param("versao") long versao, @Param("idTarget") byte[] idTarget, @Param("idProduct") int idProduct);  

}
