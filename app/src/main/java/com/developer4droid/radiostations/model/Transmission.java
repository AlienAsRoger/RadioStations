package com.developer4droid.radiostations.model;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 13:41
 */

import java.util.List;

/**
 * FM, AM, Internet Only
 */
public class Transmission {
	/*
      "element": "outline",
      "text": "FM",
      "children": [
	 */

	private String text;
	private List<Station> children;

	public String getText() {
		return text;
	}

	public List<Station> getChildren() {
		return children;
	}
}
