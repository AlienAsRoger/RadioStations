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
import com.developer4droid.radiostations.model.Outline;
import com.developer4droid.radiostations.model.Station;
import com.developer4droid.radiostations.ui.adapter.HeaderItem;
import com.developer4droid.radiostations.ui.adapter.SectionedAdapter;
import com.developer4droid.radiostations.ui.adapter.StationItem;
import com.developer4droid.radiostations.ui.adapter.StationsAdapter;
import com.developer4droid.radiostations.ui.interfaces.StationsContract;
import com.developer4droid.radiostations.viewmodel.StationsViewModel;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

import java.util.ArrayList;
import java.util.List;

public class StationsActivity extends AppCompatActivity implements StationsContract.ViewFrame {


	private static final String NAME = "name";
	private static final String ID = "id";

	@BindView(R.id.recycler_view)
	RecyclerView recyclerView;

	private ActivityStationsBinding binding;
	private StationsViewModel viewModel;
	private StationsAdapter adapter;
	private String categoryName;
	private String stationId;

	public static Intent createIntent(Context context, String name, String id) {
		Intent intent = new Intent(context, StationsActivity.class);
		intent.putExtra(NAME, name);
		intent.putExtra(ID, id);
		return intent;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_stations);

		// Use butter knife for fast binding
		ButterKnife.bind(this);
		categoryName = getIntent().getStringExtra(NAME);
		stationId = getIntent().getStringExtra(ID);

		init();
		initViews();
	}

	@Override
	protected void onResume() {
		super.onResume();

		binding.setStations(viewModel);

		viewModel.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();

		viewModel.unRegister();
	}

	// ------------- //
	// Local methods //
	// ------------- //

	/**
	 * Init Adapter and ViewModel
	 */
	private void init() {
		adapter = new StationsAdapter(null);
		viewModel = new StationsViewModel(categoryName, stationId);
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
	public void updateSectionsAdapter(List<Outline> data) {
		List<AbstractFlexibleItem> itemList = new ArrayList<>();
		for (Outline item : data) {
			// create header first
			HeaderItem headerItem = new HeaderItem(item);
			itemList.add(headerItem);
			if (item.getChildren() != null) {
				for (Station station : item.getChildren()) {
					StationItem stationItem = new StationItem(station, headerItem);
					itemList.add(stationItem);
				}
			}
		}

		SectionedAdapter adapter = new SectionedAdapter(itemList);
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void openStation(String name) {
		// TODO define action
	}

}
