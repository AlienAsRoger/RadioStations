package com.developer4droid.radiostations.model;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 13:37
 */

public class Station {
	/*
          "element": "outline",
          "type": "audio",
          "text": "88.5 | KQED-FM (National News)",
          "URL": "http://opml.radiotime.com/Tune.ashx?id=s34804",
          "bitrate": "32",
          "reliability": "99",
          "guide_id": "s34804",
          "subtext": "Fresh Air",
          "genre_id": "g3124",
          "formats": "mp3",
          "show_id": "p17",
          "item": "station",
          "image": "http://cdn-radiotime-logos.tunein.com/s34804q.png",
          "current_track": "Fresh Air",
          "now_playing_id": "s34804",
          "preset_id": "s34804"
	 */

	private String text;
	private String subtext;
	private String image;

	public String getText() {
		return text;
	}

	public String getSubtext() {
		return subtext;
	}

	public String getImage() {
		return image;
	}
}
