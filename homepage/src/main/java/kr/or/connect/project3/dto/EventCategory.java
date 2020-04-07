package kr.or.connect.project3.dto;

public class EventCategory {
	private String description;
	private String content;
	private String place;
	private String url;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "EventCategory [description=" + description + ", content=" + content + ", place=" + place + ", url="
				+ url + "]";
	}
	
}
