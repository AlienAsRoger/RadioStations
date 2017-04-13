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

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

	private List<Category> itemsList;

	public CategoriesAdapter(List<Category> itemsList) {

		this.itemsList = itemsList;
	}

	@Override
	public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View itemView = inflater.inflate(R.layout.category_row_view, parent, false);
		CategoryViewModel viewModel = new CategoryViewModel();
		CategoryRowViewBinding binding = CategoryRowViewBinding.bind(itemView);
		binding.setCategory(viewModel);

		return new CategoryViewHolder(itemView, binding, viewModel);
	}

	@Override
	public void onBindViewHolder(CategoryViewHolder holder, int position) {
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

	static class CategoryViewHolder extends RecyclerView.ViewHolder {

		private CategoryRowViewBinding binding;
		private CategoryViewModel viewModel;

		public CategoryViewHolder(View itemView, CategoryRowViewBinding binding, CategoryViewModel viewModel) {
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
