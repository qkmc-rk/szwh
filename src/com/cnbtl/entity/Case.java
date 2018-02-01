package com.cnbtl.entity;

import java.sql.Timestamp;
/**
 * Case entity
 * @author Mrruan
 *
 */
public class Case {

	private Integer id;
	private String type;
	private String title;
	private Integer editor;
	private String origin;
	private Timestamp date;
	private Integer click;
	private String content;
	
	
	//getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getEditor() {
		return editor;
	}
	public void setEditor(Integer editor) {
		this.editor = editor;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Case [id=" + id + ", type=" + type + ", title=" + title + ", editor=" + editor + ", origin=" + origin
				+ ", date=" + date + ", click=" + click + ", content=" + content + "]";
	}
}
