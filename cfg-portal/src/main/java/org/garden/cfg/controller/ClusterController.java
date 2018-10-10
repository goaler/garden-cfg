package org.garden.cfg.controller;

import java.util.ArrayList;
import java.util.List;

import org.garden.cfg.controller.obj.ClusterInfo;
import org.garden.cfg.core.repository.entity.CfgCluster;
import org.garden.cfg.service.ClusterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cluster")
public class ClusterController {

	@Autowired
	private ClusterService clusterService;
	
	@GetMapping("list")
	public List<ClusterInfo> findClusters() {
		List<CfgCluster> clusters = clusterService.findClusters();
		List<ClusterInfo> infos = new ArrayList<>();
		for(CfgCluster cluster:clusters) {
			ClusterInfo info = new ClusterInfo();
			BeanUtils.copyProperties(cluster, info);
			infos.add(info);
		}
		return infos;
	}
	
}
