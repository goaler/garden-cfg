package org.garden.cfg.service;

import java.util.List;

import org.garden.cfg.core.repository.entity.CfgCluster;
import org.garden.cfg.core.repository.entity.CfgClusterExample;
import org.garden.cfg.core.repository.mapper.CfgClusterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterService {
	
	@Autowired
	private CfgClusterMapper cfgClusterMapper;
	
	public List<CfgCluster> findClusters() {
		CfgClusterExample example = new CfgClusterExample();
		example.createCriteria();
		List<CfgCluster> clusters = cfgClusterMapper.selectByExample(example);
		return clusters;
	}
	
}
