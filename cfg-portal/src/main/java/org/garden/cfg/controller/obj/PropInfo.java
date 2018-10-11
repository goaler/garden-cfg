package org.garden.cfg.controller.obj;

import java.util.Date;

public class PropInfo {

	private Integer itemId;

	private Integer docId;

	private String key;

	private String value;

	private String comment;

	private Integer position;

	private String text;

	private Integer status;

	private String createUserCode;

	private Date createTime;

	private String updateUserCode;

	private Date updateTime;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
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

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "PropInfo [itemId=" + itemId + ", docId=" + docId + ", key=" + key + ", value=" + value + ", comment="
				+ comment + ", position=" + position + ", text=" + text + ", status=" + status + ", createUserCode="
				+ createUserCode + ", createTime=" + createTime + ", updateUserCode=" + updateUserCode + ", updateTime="
				+ updateTime + "]";
	}

}
