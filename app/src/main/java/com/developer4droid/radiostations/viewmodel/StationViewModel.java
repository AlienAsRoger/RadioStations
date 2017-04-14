package com.developer4droid.radiostations.viewmodel;

import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.events.OpenStationEvent;
import com.developer4droid.radiostations.model.Station;
import com.developer4droid.radiostations.ui.interfaces.ImageLoader;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 16:38
 */

public class StationViewModel extends OutlineViewModel {

	public StationViewModel() {
		MyApplication.getInstance().getGlobalComponent().inject(this);
	}

	public void setModel(Station model, ImageLoader imageLoader) {
		setName(model.getText());
		imageLoader.loadImage(model.getImage());
	}

	public void openItem() {
		eventBus.post(new OpenStationEvent(name, guideId));
	}

}
