package com.developer4droid.radiostations.model.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 12:58
 */

public class BaseResponse<T> {

	private HeaderItem header;
	private List<T> body;


	public List<T> getBody() {
		return body;
	}

	public HeaderItem getHeader() {
		return header;
	}
}
