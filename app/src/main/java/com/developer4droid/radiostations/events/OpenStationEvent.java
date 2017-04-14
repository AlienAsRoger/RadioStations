package com.developer4droid.radiostations.events;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 13:55
 */

public class OpenStationEvent {
	
	private String name;
	private String guideId;

	public OpenStationEvent(String name, String guideId) {
		this.name = name;
		this.guideId = guideId;
	}

	public String getGuideId() {
		return guideId;
	}

	public String getName() {
		return name;
	}
}
