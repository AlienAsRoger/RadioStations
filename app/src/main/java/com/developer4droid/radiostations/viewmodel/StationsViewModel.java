package com.developer4droid.radiostations.viewmodel;

import android.databinding.Bindable;
import com.developer4droid.radiostations.BR;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.model.Transmission;
import com.developer4droid.radiostations.network.DataLoader;
import com.developer4droid.radiostations.network.DataReceiver;

import javax.inject.Inject;
import java.util.List;

import static com.developer4droid.radiostations.ui.interfaces.StationsContract.ActionListener;
import static com.developer4droid.radiostations.ui.interfaces.StationsContract.ViewFrame;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 13:36
 */

public class StationsViewModel extends BaseViewModel implements ActionListener,
		DataReceiver<List<Transmission>> {


	@Inject
	DataLoader dataLoader;

	private boolean isLoading;
	private ViewFrame viewFrame;
	private String name;

	public StationsViewModel(String name) {
		this.name = name;
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
	public void onResume(ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
		setLoading(true);
		dataLoader.loadTransmissions(name, this);
	}

	@Override
	public void onDataReceived(List<Transmission> data) {
		setLoading(false);
		viewFrame.updateAdapter(data.get(0).getChildren());
	}




}
