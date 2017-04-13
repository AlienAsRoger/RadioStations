package com.developer4droid.radiostations.viewmodel;

import android.databinding.Bindable;
import com.developer4droid.radiostations.BR;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.events.OpenCategoryEvent;
import com.developer4droid.radiostations.model.Category;
import com.developer4droid.radiostations.network.DataLoader;
import com.developer4droid.radiostations.network.DataReceiver;
import com.developer4droid.radiostations.ui.interfaces.CategoriesContract;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:43
 */

public class CategoriesViewModel extends BaseViewModel implements CategoriesContract.ActionListener,
		DataReceiver<List<Category>> {

	@Inject
	DataLoader dataLoader;

	private boolean isLoading;
	private CategoriesContract.ViewFrame viewFrame;

	public CategoriesViewModel() { // TODO as fast solution we inject Application right here, but proper solution should be to use @ActivityComponent
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
	public void onResume(CategoriesContract.ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
		setLoading(true);
		dataLoader.loadCategories(this);
	}


	@Override
	public void onDataReceived(List<Category> data) {
		setLoading(false);

		viewFrame.updateAdapter(data);
	}

	// --------- //
	// Event Bus //
	// --------- //

	@SuppressWarnings("unused")
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onEvent(OpenCategoryEvent event) {
		viewFrame.openCategory(event.getName());
	}
}
