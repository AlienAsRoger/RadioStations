package com.developer4droid.radiostations.viewmodel;

import android.databinding.Bindable;
import com.developer4droid.radiostations.BR;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.events.OpenStationEvent;
import com.developer4droid.radiostations.model.Outline;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 17:51
 */

public class OutlineViewModel extends BaseViewModel {

	protected String name;
	protected String guideId;

	public OutlineViewModel() {
		MyApplication.getInstance().getGlobalComponent().inject(this);
	}

	public void setModel(Outline model) {
		setName(model.getText());
		guideId = model.getGuideId();
	}

	@Bindable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyPropertyChanged(BR.name);
	}

	public void openItem() {
		eventBus.post(new OpenStationEvent(name, guideId));
	}
}
