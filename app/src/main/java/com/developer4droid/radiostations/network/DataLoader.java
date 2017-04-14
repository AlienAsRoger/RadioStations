package com.developer4droid.radiostations.network;

import com.developer4droid.radiostations.model.Category;
import com.developer4droid.radiostations.model.Outline;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:41
 */

public interface DataLoader {

	void loadCategories(DataReceiver<List<Category>> dataReceiver);

	void loadOutlines(String categoryName, DataReceiver<List<Outline>> dataReceiver);

	void loadStations(String id, DataReceiver<List<Outline>> dataReceiver);
}
