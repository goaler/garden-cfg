package org.garden.cfg.controller.obj;

import org.garden.cfg.core.repository.entity.CfgItem;

public class PropInfo {
	
	private Integer propId;

	private String key;

	private String value;

	private String comment;

	private Integer position;

	private String text;

	private Integer status;

	public PropInfo() {

	}

	public PropInfo(CfgItem p) {
		this.propId = p.getItemId();
		this.key = p.getKey();
		this.value = p.getValue();
		this.comment = p.getComment();
		this.position = p.getPosition();
		this.text = p.getText();
		this.status = p.getStatus();
	}

	public Integer getPropId() {
		return propId;
	}

	public void setPropId(Integer propId) {
		this.propId = propId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PropInfo [key=" + key + ", value=" + value + ", comment=" + comment + ", position=" + position
				+ ", text=" + text + ", status=" + status + "]";
	}

}
