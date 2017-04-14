package com.developer4droid.radiostations.model;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 13:41
 */

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * FM, AM, Internet Only
 */
public class Outline {
	/*
      "element": "outline",
      "text": "FM",
      "children": [ WTF!
      ]

      // ----------
	  "element": "outline",
      "type": "link",
      "text": "60's",
      "URL": "http://opml.radiotime.com/Browse.ashx?id=g407",
      "guide_id": "g407"

	 */

	private String text;
	private List<Station> children;
	@SerializedName("URL")
	private String url;
	private String guide_id;

	public String getText() {
		return text;
	}

	@Nullable
	public List<Station> getChildren() {
		return children;
	}

	public String getUrl() {
		return url;
	}

	public String getGuideId() {
		return guide_id;
	}
}
