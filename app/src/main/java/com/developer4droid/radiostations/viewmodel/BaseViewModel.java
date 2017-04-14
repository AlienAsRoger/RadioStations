package com.developer4droid.radiostations.viewmodel;

import android.databinding.BaseObservable;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.events.StubEvent;
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
	}

	public void registerBus() {
		eventBus.register(this);
	}

	public void unRegister() {
		eventBus.unregister(this);
	}

	/**
	 * Stub. Required here to not throw exception that no method with @Subscribe annotation
	 */
	@Subscribe
	public void onEvent(StubEvent event) {
	}
}
