package com.cnbtl.entity.extra;

public class TitleAndDate {
	
	private Integer id;
	private String title;
	private String date;
	
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
