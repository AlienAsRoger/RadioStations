package com.developer4droid.radiostations.viewmodel;

import android.databinding.Bindable;
import com.developer4droid.radiostations.BR;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.events.OpenStationEvent;
import com.developer4droid.radiostations.model.Station;
import com.developer4droid.radiostations.ui.interfaces.ImageLoader;
import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 16:38
 */

public class StationViewModel  extends BaseViewModel {

	@Inject
	EventBus eventBus; // can be also interface

	private String name;

	public StationViewModel() {
		MyApplication.getInstance().getGlobalComponent().inject(this);
	}

	public void setModel(Station model, ImageLoader imageLoader) {
		setName(model.getText());
		imageLoader.loadImage(model.getImage());
	}

	@Bindable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyPropertyChanged(BR.name);
	}

	public void openStation() {
		eventBus.post(new OpenStationEvent(name));
	}

}
