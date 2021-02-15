package br.com.assesso.dcsecurity.saml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.assesso.dcsecurity.saml.domain.ChaveTabela;
import br.com.assesso.dcsecurity.saml.entity.SecUser;

public interface SecUserRepository extends JpaRepository<SecUser, ChaveTabela>{
	
	SecUser findByDsUsername(String dsUsername);

	SecUser findByDsEmail(String email);

	SecUser findByIdUser(byte[] id);
	
	@Query(value = "SELECT SECUSER.* "			
			+ "FROM SEC_USER_APP SUA "
			+ "INNER JOIN SEC_PRODUCT SPR ON SUA.ID_PRODUCT = SPR.ID_PRODUCT "
			+ "INNER JOIN SEC_APP SAP ON SUA.ID_APP = SAP.ID_APP "
			+ "INNER JOIN SEC_USER SECUSER ON SECUSER.ID_USER = SUA.ID_USER " 
			+ "WHERE SPR.DS_PRODUCT = ?1 AND SAP.DS_APP = ?2 AND SECUSER.DS_USERNAME = ?3 AND SECUSER.DS_EMAIL = ?4 ", nativeQuery = true)
	
	SecUser findByProductUserAppEmail (@Param("Product") String product, @Param("App") String app, @Param("User") String username, @Param("Email") String email);  

	@Query(value = "SELECT SECUSER.* "			
			+ "FROM SEC_USER_APP SUA "
			+ "INNER JOIN SEC_PRODUCT SPR ON SUA.ID_PRODUCT = SPR.ID_PRODUCT "
			+ "INNER JOIN SEC_APP SAP ON SUA.ID_APP = SAP.ID_APP "
			+ "INNER JOIN SEC_USER SECUSER ON SECUSER.ID_USER = SUA.ID_USER " 
			+ "WHERE SPR.DS_PRODUCT = ?1 AND SAP.DS_APP = ?2 AND SECUSER.DS_USERNAME = ?3 ", nativeQuery = true)
	
	SecUser findByProductUserApp (@Param("Product") String product, @Param("App") String app, @Param("User") String username);  


}
