package com.developer4droid.radiostations.events;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 12:24
 */

public class OpenCategoryEvent {
	private String name;

	public OpenCategoryEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
