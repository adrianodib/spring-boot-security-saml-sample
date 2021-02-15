package br.com.assesso.dcsecurity.saml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.assesso.dcsecurity.saml.domain.ChaveTabela;
import br.com.assesso.dcsecurity.saml.entity.SecRole;

public interface SecRoleRepository extends JpaRepository<SecRole, ChaveTabela>{
	
	 @Query(value = "SELECT SECROLE.* "			
			+ "FROM SEC_ROLE SECROLE "
			+ "WHERE SECROLE.ID_ROLE = ?1 AND SECROLE.CD_VER_ROLE = ?2 AND SECROLE.ID_PRODUCT = ?3 ", nativeQuery = true)

		SecRole findByIdRoleVersaoIdProduct ( @Param("idRole") byte[] idRole, @Param("Versao") long versao, @Param("idProduct") int idProduct);  

}
