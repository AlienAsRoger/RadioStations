package com.developer4droid.radiostations.inject.components;

import com.developer4droid.radiostations.inject.AppModule;
import com.developer4droid.radiostations.inject.NetworkModule;
import com.developer4droid.radiostations.viewmodel.*;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:46
 */

@Singleton
@Component(modules = {
		NetworkModule.class,
		AppModule.class
})
public interface GlobalComponent {

	void inject(CategoriesViewModel model);

	void inject(CategoryViewModel model);

	void inject(StationsViewModel model);

	void inject(StationViewModel model);

	void inject(BaseViewModel model);
}
