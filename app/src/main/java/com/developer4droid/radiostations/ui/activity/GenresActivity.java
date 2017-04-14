package com.developer4droid.radiostations.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.ActivityGenreBinding;
import com.developer4droid.radiostations.model.Outline;
import com.developer4droid.radiostations.model.Station;
import com.developer4droid.radiostations.ui.adapter.OutlineAdapter;
import com.developer4droid.radiostations.ui.adapter.StationsAdapter;
import com.developer4droid.radiostations.ui.interfaces.GenresContract;
import com.developer4droid.radiostations.viewmodel.OutlinesViewModel;

import java.util.List;

public class GenresActivity extends AppCompatActivity implements GenresContract.ViewFrame {


	private static final String NAME = "category name";
	private static final String KEY = "key";

	@BindView(R.id.recycler_view)
	RecyclerView recyclerView;

	private ActivityGenreBinding binding;
	private OutlinesViewModel viewModel;
	private StationsAdapter adapter;
	private String categoryName;
	private String categoryKey;

	public static Intent createIntent(Context context, String name, String key) {
		Intent intent = new Intent(context, GenresActivity.class);
		intent.putExtra(NAME, name);
		intent.putExtra(KEY, key);
		return intent;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_genre);

		// Use butter knife for fast binding
		ButterKnife.bind(this);
		categoryName = getIntent().getStringExtra(NAME);
		categoryKey = getIntent().getStringExtra(KEY);

		init();
		initViews();
	}

	@Override
	protected void onResume() {
		super.onResume();

		binding.setOutline(viewModel);

		viewModel.onResume(this);
	}

	// ------------- //
	// Local methods //
	// ------------- //

	/**
	 * Init Adapter and ViewModel
	 */
	private void init() {
		adapter = new StationsAdapter(null);
		viewModel = new OutlinesViewModel(categoryName, categoryKey);
	}

	/**
	 * Initiate views after main objects
	 */
	private void initViews() {
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
				layoutManager.getOrientation());
		recyclerView.addItemDecoration(dividerItemDecoration);

		recyclerView.setAdapter(adapter);

		setTitle(categoryName);
	}

	// ------------------------ //
	// Interface Implementation //
	// ------------------------ //

	@Override
	public void updateAdapter(List<Station> itemList) {
		adapter.updateItems(itemList);
	}

	@Override
	public void updateOutLineAdapter(List<Outline> data) {
		recyclerView.setAdapter(new OutlineAdapter(data));
	}

	@Override
	public void openStation(String name, String guideId) {
		startActivity(StationsActivity.createIntent(this, name, guideId));
	}

}
