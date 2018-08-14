package org.garden.cfg.controller.obj;

import org.garden.cfg.core.repository.entity.CfgCluster;

public class ClusterInfo {
	private Integer clusterId;

	private String clusterCode;

	private String clusterName;

	private String comment;

	public ClusterInfo() {
	}

	public ClusterInfo(CfgCluster cluster) {
		this.clusterId = cluster.getClusterId();
		this.clusterCode = cluster.getClusterCode();
		this.clusterName = cluster.getClusterName();
		this.comment = cluster.getComment();
	}

	public Integer getClusterId() {
		return clusterId;
	}

	public void setClusterId(Integer clusterId) {
		this.clusterId = clusterId;
	}

	public String getClusterCode() {
		return clusterCode;
	}

	public void setClusterCode(String clusterCode) {
		this.clusterCode = clusterCode;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ClusterInfo [clusterId=" + clusterId + ", clusterCode=" + clusterCode + ", clusterName=" + clusterName
				+ ", comment=" + comment + "]";
	}

}
