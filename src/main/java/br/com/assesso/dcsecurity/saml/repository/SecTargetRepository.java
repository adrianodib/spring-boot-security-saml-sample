package br.com.assesso.dcsecurity.saml.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.assesso.dcsecurity.saml.domain.ChaveTabela;
import br.com.assesso.dcsecurity.saml.entity.SecTarget;

public interface SecTargetRepository extends JpaRepository<SecTarget, ChaveTabela>{
	
	SecTarget findByIdTarget(byte[] id);

	@Query(value = "SELECT "
			+ "TARGET.ID_TARGET AS IDTARGET, "
			+ "TARGET.TP_TARGET AS TPTARGET, "
			+ "TARGET.DS_TARGET AS DSTARGET, "
			+ "TARGET.NU_ORDER AS NUORDER, "
			+ "TARGET.DS_GIF AS DSGIF, "
			+ "TARGET.DS_PATH AS DSPATH, "
			+ "TARGET.DS_URL AS DSURL, "
			+ "TARGET.DS_DEFAULT AS DSDEFAULT, "
			+ "TARGET.ID_PRODUCT AS IDPRODUCT, "
			+ "TARGET.DS_VALUE AS DSVALUE, "
			+ "SGT.IS_READONLY AS ISREADYONLY "
			+ "FROM SEC_USER_APP SUA "
			+ "INNER JOIN SEC_ROLE_GRANT SRG ON SUA.ID_PRODUCT = SRG.ID_PRODUCT AND SUA.ID_ROLE = SRG.ID_ROLE AND SUA.CD_VER_ROLE = SRG .CD_VER_ROLE "
			+ "INNER JOIN SEC_GRANT_TARGET SGT ON SRG.ID_PRODUCT = SGT.ID_PRODUCT AND SGT.ID_GRANT = SRG.ID_GRANT AND SGT.CD_VER_GRANT = SRG.CD_VER_GRANT "
			+ "INNER JOIN SEC_TARGET TARGET ON SGT.ID_PRODUCT = TARGET.ID_PRODUCT AND SGT.ID_TARGET = TARGET.ID_TARGET "
			+ "INNER JOIN SEC_USER SECUSER ON SECUSER.ID_USER = SUA.ID_USER " 
			+ "WHERE SUA.ID_PRODUCT = ?1 AND SUA.ID_APP = ?2 AND SECUSER.DS_USERNAME = ?3 AND SUA.STATUS = 'A'", nativeQuery = true)
	
	Set<SecTarget> findByIdProductIdUserIdApp (@Param("idProduct") int idProduct, @Param("idApp") byte[] idApp, @Param("idUser") String username);  

	
	@Query(value = "SELECT "
			+ "TARGET.ID_TARGET AS IDTARGET, "
			+ "TARGET.TP_TARGET AS TPTARGET, "
			+ "TARGET.DS_TARGET AS DSTARGET, "
			+ "TARGET.NU_ORDER AS NUORDER, "
			+ "TARGET.DS_GIF AS DSGIF, "
			+ "TARGET.DS_PATH AS DSPATH, "
			+ "TARGET.DS_URL AS DSURL, "
			+ "TARGET.DS_DEFAULT AS DSDEFAULT, "
			+ "TARGET.ID_PRODUCT AS IDPRODUCT, "
			+ "TARGET.DS_VALUE AS DSVALUE, "
			+ "SGT.IS_READONLY AS ISREADYONLY "
			+ "FROM SEC_USER_APP SUA "
			+ "INNER JOIN SEC_PRODUCT SPR ON SUA.ID_PRODUCT = SPR.ID_PRODUCT "
			+ "INNER JOIN SEC_APP SAP ON SUA.ID_APP = SAP.ID_APP "
			+ "INNER JOIN SEC_ROLE_GRANT SRG ON SUA.ID_PRODUCT = SRG.ID_PRODUCT AND SUA.ID_ROLE = SRG.ID_ROLE AND SUA.CD_VER_ROLE = SRG .CD_VER_ROLE "
			+ "INNER JOIN SEC_GRANT_TARGET SGT ON SRG.ID_PRODUCT = SGT.ID_PRODUCT AND SGT.ID_GRANT = SRG.ID_GRANT AND SGT.CD_VER_GRANT = SRG.CD_VER_GRANT "
			+ "INNER JOIN SEC_TARGET TARGET ON SGT.ID_PRODUCT = TARGET.ID_PRODUCT AND SGT.ID_TARGET = TARGET.ID_TARGET "
			+ "INNER JOIN SEC_USER SECUSER ON SECUSER.ID_USER = SUA.ID_USER " 
			+ "WHERE SPR.DS_PRODUCT = ?1 AND SAP.DS_APP = ?2 AND SECUSER.DS_USERNAME = ?3 AND SUA.STATUS = 'A'", nativeQuery = true)
	
	Set<SecTarget> findByProductUserApp (@Param("Product") String product, @Param("App") String app, @Param("User") String username);  

}
