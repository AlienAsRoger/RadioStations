package com.developer4droid.radiostations.viewmodel;

import android.databinding.Bindable;
import com.developer4droid.radiostations.BR;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.events.OpenStationEvent;
import com.developer4droid.radiostations.model.Outline;
import com.developer4droid.radiostations.network.DataLoader;
import com.developer4droid.radiostations.network.DataReceiver;
import com.developer4droid.radiostations.ui.interfaces.GenresContract;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 17:19
 */

public class OutlinesViewModel extends BaseViewModel  implements GenresContract.ActionListener,
		DataReceiver<List<Outline>> {

	@Inject
	DataLoader dataLoader;

	private boolean isLoading;
	private GenresContract.ViewFrame viewFrame;
	private String name;
	private String categoryKey;

	public OutlinesViewModel(String name, String categoryKey) {
		this.name = name;
		this.categoryKey = categoryKey;
		MyApplication.getInstance().getGlobalComponent().inject(this);
	}

	@Bindable
	public boolean isLoading() {
		return isLoading;
	}

	public void setLoading(boolean loading) {
		isLoading = loading;
		notifyPropertyChanged(BR.loading);
	}

	// ------------------------ //
	// Interface Implementation //
	// ------------------------ //

	@Override
	public void onResume(GenresContract.ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
		setLoading(true);
		dataLoader.loadOutlines(categoryKey, this);
	}

	@Override
	public void onDataReceived(List<Outline> data) {
		setLoading(false);
		if (!data.isEmpty()) {

			if (data.get(0).getChildren() != null) { // TODO this is workaround to support different outlines under same type.
				viewFrame.updateAdapter(data.get(0).getChildren());
			} else {
				viewFrame.updateOutLineAdapter(data);
			}
		}
	}


	// --------- //
	// Event Bus //
	// --------- //

	@SuppressWarnings("unused")
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(OpenStationEvent event) {
		viewFrame.openStation(event.getName(), event.getGuideId());
	}
}
