package com.developer4droid.radiostations.viewmodel;

import android.databinding.Bindable;
import com.developer4droid.radiostations.BR;
import com.developer4droid.radiostations.application.MyApplication;
import com.developer4droid.radiostations.events.OpenCategoryEvent;
import com.developer4droid.radiostations.model.Category;
import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 12:21
 */

public class CategoryViewModel extends BaseViewModel {

	@Inject
	EventBus eventBus; // can be also interface

	private String name;
	private Category model;

	public CategoryViewModel() {
		MyApplication.getInstance().getGlobalComponent().inject(this);
	}

	public void setModel(Category model) {
		this.model = model;
		setName(model.getKey());
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
		eventBus.post(new OpenCategoryEvent(name));
	}

}
