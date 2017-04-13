package com.developer4droid.radiostations.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:32
 */

public class Category {
/*
"element": "outline",
  "type": "link",
  "text": "Local Radio",
  "URL": "http://opml.radiotime.com/Browse.ashx?c=local",
  "key": "local"
 */

	private String element;
	private String type;
	private String text;
	@SerializedName("URL")
	private String url;
	private String key;

	public String getElement() {
		return element;
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}

	public String getUrl() {
		return url;
	}

	public String getKey() {
		return key;
	}

}
