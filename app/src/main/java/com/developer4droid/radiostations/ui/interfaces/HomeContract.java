package com.developer4droid.radiostations.ui.interfaces;

import com.developer4droid.radiostations.model.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:54
 */

public interface HomeContract {

	interface ViewFrame{

		void updateAdapter(List<Category> itemList);
	}

	interface ActionListener {
		void onResume(ViewFrame viewFrame);
	}
}
