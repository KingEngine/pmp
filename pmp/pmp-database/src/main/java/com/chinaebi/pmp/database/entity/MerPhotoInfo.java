package com.chinaebi.pmp.database.entity;

import java.sql.Timestamp;

/**
 * 对应表 mer_photo_info
 * 
 * @author king
 *
 */
public class MerPhotoInfo implements java.io.Serializable {

	private static final long serialVersionUID = -1487665019207587128L;
	private int id;/* 对应表中id */
	private int mid;/* 对应表中mid */
	private String photoUrl;/* 对应表中photo_url */
	private Timestamp makeTime;/* 对应表中make_time */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Timestamp getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(Timestamp makeTime) {
		this.makeTime = makeTime;
	}
}
