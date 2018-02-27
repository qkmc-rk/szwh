package com.szwh.entity.extra;

public class TitleAndDate {
	
	private Integer id;
	private String title;
	private String date;
	private Integer click;
	private String type;
	private String origin;
	
	
	public Integer getId() {
		return id;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date2) {
		this.date = date2;
	}
	@Override
	public String toString() {
		return "TitleAndDate [id=" + id + ", title=" + title + ", date=" + date + "]";
	}
}
