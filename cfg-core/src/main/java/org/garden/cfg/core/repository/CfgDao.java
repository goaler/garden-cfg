package org.garden.cfg.core.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.garden.cfg.core.repository.entity.CfgApp;
import org.garden.cfg.core.repository.entity.CfgDoc;
import org.garden.cfg.core.repository.entity.CfgItem;
import org.springframework.transaction.annotation.Transactional;

public interface CfgDao {
	
	public List<CfgDoc> getDocs(@Param("userCode") String userCode);
	
	public List<CfgApp> getApps(@Param("userCode") String userCode);

	public List<CfgItem> getDocProps(@Param("docId") String docId);

	@Transactional
	public void addProps(@Param("props") List<CfgItem> props);

	public Integer getLastPosition(@Param("groupId") int groupId);

}
