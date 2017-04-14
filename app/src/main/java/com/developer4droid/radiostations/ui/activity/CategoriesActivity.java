package com.developer4droid.radiostations.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.ActivityCategoriesBinding;
import com.developer4droid.radiostations.model.Category;
import com.developer4droid.radiostations.ui.adapter.CategoriesAdapter;
import com.developer4droid.radiostations.ui.interfaces.CategoriesContract;
import com.developer4droid.radiostations.viewmodel.CategoriesViewModel;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity implements CategoriesContract.ViewFrame{

	@BindView(R.id.recycler_view)
	RecyclerView recyclerView;

	private ActivityCategoriesBinding binding;
	private CategoriesViewModel viewModel;
	private CategoriesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_categories);

		// Use butter knife for fast binding
		ButterKnife.bind(this);

		init();
		initViews();
	}

	@Override
	protected void onResume() {
		super.onResume();

		binding.setCategories(viewModel);

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
		viewModel = new CategoriesViewModel();
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
	}

	// ------------------------ //
	// Interface Implementation //
	// ------------------------ //

	@Override
	public void updateAdapter(List<Category> itemList) {
		adapter.updateItems(itemList);
	}

	@Override
	public void openCategory(String name, String key) {
		startActivity(GenresActivity.createIntent(this, name, key));
	}
}
