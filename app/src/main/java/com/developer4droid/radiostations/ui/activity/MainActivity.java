package com.developer4droid.radiostations.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.ActivityMainBinding;
import com.developer4droid.radiostations.model.Category;
import com.developer4droid.radiostations.ui.adapter.CategoriesAdapter;
import com.developer4droid.radiostations.ui.interfaces.HomeContract;
import com.developer4droid.radiostations.viewmodel.HomeViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.ViewFrame{

	@BindView(R.id.recycler_view)
	RecyclerView recyclerView;

	private ActivityMainBinding binding;
	private HomeViewModel viewModel;
	private CategoriesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		// Use butter knife for fast binding
		ButterKnife.bind(this);

		init();
		initViews();
	}

	@Override
	protected void onResume() {
		super.onResume();

		binding.setHome(viewModel);

		viewModel.onResume(this);
	}

	// ------------- //
	// Local methods //
	// ------------- //

	/**
	 * Init Adapter and ViewModel
	 */
	private void init() {
		adapter = new CategoriesAdapter(null);
		viewModel = new HomeViewModel();
	}

	/**
	 * Initiate views after main objects
	 */
	private void initViews() {
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
	}

	// ------------------------ //
	// Interface Implementation //
	// ------------------------ //

	@Override
	public void updateAdapter(List<Category> itemList) {
		adapter.updateItems(itemList);
	}

	// --------- //
	// Event Bus //
	// --------- //

}
