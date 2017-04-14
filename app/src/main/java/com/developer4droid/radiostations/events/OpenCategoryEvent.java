package com.developer4droid.radiostations.events;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 12:24
 */

public class OpenCategoryEvent {
	private String name;
	private String key;

	public OpenCategoryEvent(String name, String key) {
		this.name = name;
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public String getKey() {
		return key;
	}
}
