package com.developer4droid.radiostations.events;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 13:55
 */

public class OpenStationEvent {
	
	private String name;

	public OpenStationEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
