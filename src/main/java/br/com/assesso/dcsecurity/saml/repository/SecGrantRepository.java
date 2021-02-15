package br.com.assesso.dcsecurity.saml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.assesso.dcsecurity.saml.domain.ChaveTabela;
import br.com.assesso.dcsecurity.saml.entity.SecGrant;


public interface SecGrantRepository extends JpaRepository<SecGrant, ChaveTabela>{
	
	@Query(value = "SELECT SECGRANT.* "			
			+ "FROM SEC_GRANT SECGRANT "
			+ "WHERE SECGRANT.ID_GRANT = ?1 AND SECGRANT.CD_VER_GRANT = ?2 AND SECGRANT.ID_PRODUCT = ?3 ", nativeQuery = true)

		SecGrant findByIdGrantVersaoIdProduct ( @Param("idGrant") byte[] idRole, @Param("Versao") long versao, @Param("idProduct") int idProduct);  


}
