package com.developer4droid.radiostations.viewmodel;

import android.databinding.Bindable;
import com.developer4droid.radiostations.BR;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.model.Station;
import com.developer4droid.radiostations.ui.interfaces.ImageLoader;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 16:38
 */

public class StationViewModel extends OutlineViewModel {

	private String subText;

	public StationViewModel() {
		MyApplication.getInstance().getGlobalComponent().inject(this);
	}

	public void setModel(Station model, ImageLoader imageLoader) {
		setName(model.getText());
		setSubText(model.getSubtext());
		imageLoader.loadImage(model.getImage());
	}

	@Bindable
	public String getSubText() {
		return subText;
	}

	public void setSubText(String subText) {
		this.subText = subText;
		notifyPropertyChanged(BR.subText);
	}
}
