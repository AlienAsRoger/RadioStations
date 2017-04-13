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
import com.developer4droid.radiostations.databinding.ActivityStationsBinding;
import com.developer4droid.radiostations.model.Station;
import com.developer4droid.radiostations.ui.adapter.StationsAdapter;
import com.developer4droid.radiostations.ui.interfaces.StationsContract;
import com.developer4droid.radiostations.viewmodel.StationsViewModel;

import java.util.List;

public class StationsActivity extends AppCompatActivity implements StationsContract.ViewFrame {


	private static final String CATEGORY_NAME = "category name";

	@BindView(R.id.recycler_view)
	RecyclerView recyclerView;

	private ActivityStationsBinding binding;
	private StationsViewModel viewModel;
	private StationsAdapter adapter;
	private String categoryName;

	public static Intent createIntent(Context context, String name) {
		Intent intent = new Intent(context, StationsActivity.class);
		intent.putExtra(CATEGORY_NAME, name);
		return intent;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_stations);

		// Use butter knife for fast binding
		ButterKnife.bind(this);
		categoryName = getIntent().getStringExtra(CATEGORY_NAME);

		init();
		initViews();
	}

	@Override
	protected void onResume() {
		super.onResume();

		binding.setStations(viewModel);

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
		viewModel = new StationsViewModel(categoryName);
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
	public void openStation(String name) {
		startActivity(StationsActivity.createIntent(this, name));
	}

}
