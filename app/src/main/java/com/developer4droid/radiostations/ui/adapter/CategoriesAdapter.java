package com.developer4droid.radiostations.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.CategoryRowViewBinding;
import com.developer4droid.radiostations.model.Category;
import com.developer4droid.radiostations.viewmodel.CategoryViewModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 12:05
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.StationViewHolder> {

	private List<Category> itemsList;

	public CategoriesAdapter(List<Category> itemsList) {

		this.itemsList = itemsList;
	}

	@Override
	public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View itemView = inflater.inflate(R.layout.category_row_view, parent, false);
		CategoryViewModel viewModel = new CategoryViewModel();
		CategoryRowViewBinding binding = CategoryRowViewBinding.bind(itemView);
		binding.setStation(viewModel);

		return new StationViewHolder(itemView, binding, viewModel);
	}

	@Override
	public void onBindViewHolder(StationViewHolder holder, int position) {
		holder.setItem(itemsList.get(position));
	}

	@Override
	public int getItemCount() {
		return itemsList == null ? 0 : itemsList.size();
	}

	public void updateItems(List<Category> itemList) {
		this.itemsList = itemList;
		notifyDataSetChanged();
	}

	static class StationViewHolder extends RecyclerView.ViewHolder {

		private CategoryRowViewBinding binding;
		private CategoryViewModel viewModel;

		public StationViewHolder(View itemView, CategoryRowViewBinding binding, CategoryViewModel viewModel) {
			super(itemView);
			this.binding = binding;
			this.viewModel = viewModel;
		}

		public void setItem(Category category) {
			viewModel.setModel(category);
			binding.executePendingBindings();
		}
	}
}
