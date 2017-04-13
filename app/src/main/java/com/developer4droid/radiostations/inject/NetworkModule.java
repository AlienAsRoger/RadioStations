package com.developer4droid.radiostations.inject;

import com.developer4droid.radiostations.network.DataLoader;
import com.developer4droid.radiostations.network.DataLoaderImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:47
 */

@Module
public class NetworkModule {

	@Provides
	DataLoader provideDataLoader() {
		return new DataLoaderImpl();
	}
}
