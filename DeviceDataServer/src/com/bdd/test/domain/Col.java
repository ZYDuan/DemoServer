/**
 * 
 */
package com.bdd.test.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author zyd
 * @date 2018年4月13日 上午10:29:16 
 * @ClassName: Col 
 */
@Document(collection = "col")
public class Col {
	private String title;
	private String description;
	private String by;
	private String url;
	private List<Tags> tags;
//	private String likes;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	
	
//	public String getLikes() {
//		return likes;
//	}
//	public void setLikes(String likes) {
//		this.likes = likes;
//	}
	
	
}
