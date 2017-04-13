package com.developer4droid.radiostations.inject.components;

import com.developer4droid.radiostations.inject.AppModule;
import com.developer4droid.radiostations.inject.NetworkModule;
import com.developer4droid.radiostations.viewmodel.BaseViewModel;
import com.developer4droid.radiostations.viewmodel.CategoryViewModel;
import com.developer4droid.radiostations.viewmodel.HomeViewModel;
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

	void inject(HomeViewModel inject);

	void inject(CategoryViewModel model);

	void inject(BaseViewModel model);
}
