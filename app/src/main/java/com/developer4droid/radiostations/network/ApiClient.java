package com.developer4droid.radiostations.network;

import com.developer4droid.radiostations.model.Category;
import com.developer4droid.radiostations.model.Transmission;
import com.developer4droid.radiostations.model.base.BaseResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 11:34
 */

public interface ApiClient {
	String RENDER_JSON = "?render=json";
	String BASE_URL = "http://opml.radiotime.com/";

	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build();

	@GET(RENDER_JSON)
	Call<BaseResponse<Category>> loadCategories();

	@GET("Browse.ashx" + RENDER_JSON)
	Call<BaseResponse<Transmission>> loadTransmissions(@Query("c") String categoryName);

	@GET("Tune.ashx" + RENDER_JSON)
	Call<BaseResponse> loadStation(@Query("id") String id);
}
