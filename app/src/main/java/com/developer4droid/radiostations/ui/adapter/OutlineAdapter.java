package com.developer4droid.radiostations.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.OutlineRowViewBinding;
import com.developer4droid.radiostations.model.Outline;
import com.developer4droid.radiostations.viewmodel.OutlineViewModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 17:46
 */

public class OutlineAdapter extends RecyclerView.Adapter<OutlineAdapter.OutlineViewHolder> {

	private List<Outline> itemsList;

	public OutlineAdapter(List<Outline> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public OutlineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View itemView = inflater.inflate(R.layout.outline_row_view, parent, false);
		OutlineViewModel viewModel = new OutlineViewModel();
		OutlineRowViewBinding binding = OutlineRowViewBinding.bind(itemView);
		binding.setOutline(viewModel);

		return new OutlineViewHolder(itemView, binding, viewModel);
	}

	@Override
	public void onBindViewHolder(OutlineViewHolder holder, int position) {
		holder.setItem(itemsList.get(position));
	}

	@Override
	public int getItemCount() {
		return itemsList == null ? 0 : itemsList.size();
	}

	public static class OutlineViewHolder extends RecyclerView.ViewHolder {

		protected OutlineRowViewBinding binding;
		protected OutlineViewModel viewModel;

		public OutlineViewHolder(View itemView, OutlineRowViewBinding binding, OutlineViewModel viewModel) {
			super(itemView);
			this.binding = binding;
			this.viewModel = viewModel;
		}

		public void setItem(Outline station) {
			viewModel.setModel(station);
			binding.executePendingBindings();
		}

	}
}
