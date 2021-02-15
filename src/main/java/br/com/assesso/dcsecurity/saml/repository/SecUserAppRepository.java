package br.com.assesso.dcsecurity.saml.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.assesso.dcsecurity.saml.entity.SecUserApp;

public interface SecUserAppRepository extends JpaRepository<SecUserApp, String> {
	
	@Query(value = "SELECT SUA.* "
			+ "FROM SEC_USER_APP SUA "
			+ "INNER JOIN SEC_ROLE_GRANT SRG ON SUA.ID_PRODUCT = SRG.ID_PRODUCT AND SUA.ID_ROLE = SRG.ID_ROLE AND SUA.CD_VER_ROLE = SRG .CD_VER_ROLE "
			+ "INNER JOIN SEC_GRANT_TARGET SGT ON SRG.ID_PRODUCT = SGT.ID_PRODUCT AND SGT.ID_GRANT = SRG.ID_GRANT AND SGT.CD_VER_GRANT = SRG.CD_VER_GRANT "
			+ "INNER JOIN SEC_TARGET TARGET ON SGT.ID_PRODUCT = TARGET.ID_PRODUCT AND SGT.ID_TARGET = TARGET.ID_TARGET "
			+ "INNER JOIN SEC_USER SECUSER ON SECUSER.ID_USER = SUA.ID_USER " 
			+ "WHERE SUA.ID_PRODUCT = ?1 AND SUA.ID_APP = ?2 AND SECUSER.DS_USERNAME = ?3 AND SUA.STATUS = 'A'",	nativeQuery = true)
	
	Set<SecUserApp> findByIdProductIdUserIdApp (@Param("idProduct") int idProduct, @Param("idApp") int idApp, @Param("idUser") String username);  

	//devolver o conteudo sec_target e do sec_grant_targer
	
}

