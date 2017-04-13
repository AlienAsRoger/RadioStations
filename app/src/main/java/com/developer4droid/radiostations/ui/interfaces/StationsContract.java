package com.developer4droid.radiostations.ui.interfaces;

import com.developer4droid.radiostations.model.Station;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 13:47
 */

public interface StationsContract {

	interface ViewFrame{

		void updateAdapter(List<Station> itemList);

		void openStation(String name);
	}

	interface ActionListener {
		void onResume(ViewFrame viewFrame);
	}
}
