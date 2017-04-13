package com.developer4droid.radiostations.network;

import android.util.Log;
import com.developer4droid.radiostations.model.Category;
import com.developer4droid.radiostations.model.base.BaseResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:41
 */

public class DataLoaderImpl implements DataLoader{

	private final ApiClient apiClient = ApiClient.retrofit.create(ApiClient.class);

	@Override
	public void loadCategories(final DataReceiver<List<Category>> dataReceiver) {
		final Call<BaseResponse<Category>> call = apiClient.loadCategories();
		call.enqueue(new Callback<BaseResponse<Category>>() {
			@Override
			public void onResponse(Call<BaseResponse<Category>> call, Response<BaseResponse<Category>> response) {
				if (response.isSuccessful()) {
					List<Category> categoryList = response.body().getBody();
					dataReceiver.onDataReceived(categoryList);
				} else {
					Log.d("TEST", "onResponse: Not Success");
				}
			}

			@Override
			public void onFailure(Call<BaseResponse<Category>> call, Throwable t) {
				Log.d("TEST", "onFailure: ");
			}
		});
	}


}
