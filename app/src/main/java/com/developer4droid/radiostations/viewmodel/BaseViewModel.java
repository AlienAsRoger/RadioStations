package com.developer4droid.radiostations.viewmodel;

import android.databinding.BaseObservable;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.events.OpenCategoryEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:43
 */

public abstract class BaseViewModel extends BaseObservable{

	@Inject
	protected EventBus eventBus;


	public BaseViewModel() {
		MyApplication.getInstance().getGlobalComponent().inject(this);
		eventBus.register(this);
	}

	/**
	 * Stub. Required here to not throw exception that no method with @Subscribe annotation
	 */
	@Subscribe
	public void onEvent(OpenCategoryEvent event) {
	}
}
