package com.developer4droid.radiostations.network;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 12:50
 */

public interface DataReceiver<T> {

	void onDataReceived(T data);
}
