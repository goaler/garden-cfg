package org.garden.cfg.controller.obj;

import org.garden.cfg.core.repository.entity.CfgDoc;

public class DocInfo {
    private Integer docId;

    private String appCode;

    private String envCode;

    private String clusterCode;

    private String comment;

    private Integer status;
    
    public DocInfo() {
    	
    }
    
    public DocInfo(CfgDoc doc) {
    	this.docId = doc.getDocId();
    	this.appCode = doc.getAppCode();
    	this.envCode = doc.getEnvCode();
    	this.clusterCode = doc.getClusterCode();
    	this.comment = doc.getComment();
    	this.status = doc.getStatus();
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getEnvCode() {
        return envCode;
    }

    public void setEnvCode(String envCode) {
        this.envCode = envCode;
    }

    public String getClusterCode() {
        return clusterCode;
    }

    public void setClusterCode(String clusterCode) {
        this.clusterCode = clusterCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}